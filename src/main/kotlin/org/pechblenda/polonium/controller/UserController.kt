package org.pechblenda.polonium.controller

import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@CrossOrigin(methods = [
	RequestMethod.GET
])
@RestController
@RequestMapping("/users")
class UserController {

	@GetMapping
	@PreAuthorize("hasRole('PROJECT')")
	fun signUp(): ResponseEntity<Any> {
		return ResponseEntity("Hola", HttpStatus.OK)
	}

}