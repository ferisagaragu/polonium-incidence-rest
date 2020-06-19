package org.pechblenda.polonium.service.`interface`

import org.pechblenda.rest.Request
import org.springframework.http.ResponseEntity


interface IAuthService {
	@Throws fun signUp(request: Request): ResponseEntity<Any>
	@Throws fun signIn(request: Request): ResponseEntity<Any>
	@Throws fun recoverPassword(request: Request): ResponseEntity<Any>
	@Throws fun changePassword(request: Request): ResponseEntity<Any>
}