package org.pecheblenda.poloniumincidencerest.config

import org.pechblenda.auth.AuthController
import org.pechblenda.doc.Documentation
import org.pecheblenda.poloniumincidencerest.entity.User

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan("org.pechblenda.bean")
class BeanConfig {

	@Bean
	fun documentation(): Documentation {
		return Documentation(
			mutableListOf(
				User::class
			),
			AuthController::class
		)
	}

}