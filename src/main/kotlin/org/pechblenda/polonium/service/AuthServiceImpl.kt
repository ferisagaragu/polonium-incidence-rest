package org.pechblenda.polonium.service

import org.pechblenda.exception.BadRequestException
import org.pechblenda.exception.UnauthenticatedException

import org.pechblenda.polonium.dao.IUserDAO
import org.pechblenda.polonium.entity.User
import org.pechblenda.polonium.security.UserPrinciple
import org.pechblenda.polonium.service.`interface`.IAuthService

import org.pechblenda.rest.Request
import org.pechblenda.rest.Response
import org.pechblenda.security.JwtProvider
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class AuthServiceImpl: IAuthService, UserDetailsService {

	@Autowired
	private lateinit var userDAO: IUserDAO

	@Autowired
	private lateinit var response: Response

	@Autowired
	private lateinit var passwordEncoder: PasswordEncoder

	@Autowired
	private lateinit var authenticationManager: AuthenticationManager

	@Autowired
	private lateinit var jwtProvider: JwtProvider


	@Transactional
	override fun signUp(request: Request): ResponseEntity<Any> {
		val user = request.to<User>(User::class)

		user.password = passwordEncoder.encode(user.password)

		return response.toMap(
			userDAO.save(user)
		).firstId().created()
	}

	@Throws
	@Transactional
	override fun signIn(request: Request): ResponseEntity<Any> {
		val user = request.to<User>(User::class)
		val userOut = userDAO.findByUserNameOrEmail(
			user.userName
		).orElseThrow { throw BadRequestException("Upps el usuario no existe") }
		var jwt: String

		try {
			val authentication: Authentication = authenticationManager.authenticate(
				UsernamePasswordAuthenticationToken(
					userOut.userName,
					user.password
				)
			)

			SecurityContextHolder.getContext().authentication = authentication
			jwt = jwtProvider.generateJwtToken(authentication)
		} catch (e: Exception) {
			println(e.message)
			e.stackTrace
			throw UnauthenticatedException("Upps la contraseña es incorrecta");
		}


		var out = response.toMap(
			userOut
		)

		out["token"] = jwt

		return out.exclude("password").ok()
	}

	override fun recoverPassword(request: Request): ResponseEntity<Any> {
		TODO("Not yet implemented")
	}

	override fun changePassword(request: Request): ResponseEntity<Any> {
		TODO("Not yet implemented")
	}

	@Transactional(readOnly = true)
	override fun loadUserByUsername(userName: String): UserDetails {
		val user: User = userDAO.findByUserName(userName).orElseThrow {
			UsernameNotFoundException("Upps el usuario no existe")
		}
		return UserPrinciple.build(user)
	}


}