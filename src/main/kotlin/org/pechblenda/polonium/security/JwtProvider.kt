package org.pechblenda.polonium.security

import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.SignatureException
import io.jsonwebtoken.UnsupportedJwtException

import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

import java.util.Date


@Component
class JwtProvider(
	@Value("\${app.auth.jwt-secret}")
	private val jwtSecret: String,
	@Value("\${app.auth.jwt-expiration}")
	private val jwtExpiration: Int
) {

	companion object {
		private val logger = LoggerFactory.getLogger(JwtProvider::class.java)
	}


	fun generateJwtToken(authentication: Authentication): String {
		val userPrinciple = authentication.principal as UserPrinciple

		return Jwts.builder()
			.setSubject(userPrinciple.username)
			.setIssuedAt(Date())
			.setExpiration(Date(Date().time + jwtExpiration))
			.signWith(SignatureAlgorithm.HS512, jwtSecret)
			.compact()
	}

	fun getUserNameFromJwtToken(token: String): String {
		return Jwts.parser()
			.setSigningKey(jwtSecret)
			.parseClaimsJws(token)
			.body
			.subject
	}

	fun validateJwtToken(authToken: String): Boolean {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken)
			return true
		} catch (e: SignatureException) {
			logger.error("Invalid JWT signature")
		} catch (e: MalformedJwtException) {
			logger.error("Invalid JWT token")
		} catch (e: ExpiredJwtException) {
			logger.error("Expired JWT token")
		} catch (e: UnsupportedJwtException) {
			logger.error("Unsupported JWT token")
		} catch (e: IllegalArgumentException) {
			logger.error("JWT claims string is empty")
		}

		return false
	}

}