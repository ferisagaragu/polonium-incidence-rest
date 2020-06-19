package org.pechblenda.polonium.controller

import org.pechblenda.exception.HttpExceptionResponse
import org.pechblenda.polonium.service.`interface`.IAuthService
import org.pechblenda.rest.Request

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.server.ResponseStatusException


@CrossOrigin(methods = [
	RequestMethod.POST
])
@RestController
@RequestMapping("/auth")
class AuthController(
	private val authService: IAuthService,
	private val httpExceptionResponse: HttpExceptionResponse
) {

	@PostMapping
	fun signUp(
		@RequestBody request: Request
	): ResponseEntity<Any> {
		return try {
			authService.signUp(request)
		} catch (e: ResponseStatusException) {
			httpExceptionResponse.error(e)
		}
	}

	@PostMapping("/sign-in")
	fun signIn(
		@RequestBody request: Request
	): ResponseEntity<Any> {
		return try {
			authService.signIn(request)
		} catch (e: ResponseStatusException) {
			httpExceptionResponse.error(e)
		}
	}

}