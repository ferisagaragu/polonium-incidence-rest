package org.pechblenda.polonium.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions

import org.pechblenda.exception.HttpExceptionResponse
import org.pechblenda.rest.Response
import org.pechblenda.storage.FirebaseStorage

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource


@Configuration
class BeanConfig(
	@Value("\${google.auth.google-service-account-key}")
	private val googleServiceAccountKey: String,
	@Value("\${google.auth.bucket}")
	private val bucket: String
) {

	/*@Bean
	fun firebaseStorage(): FirebaseStorage {
		var storage: Storage

		try {
			val resource = ClassPathResource(googleServiceAccountKey)
			storage = StorageOptions.newBuilder()
				.setCredentials(GoogleCredentials.fromStream(resource.inputStream))
				.build()
				.service
		} catch (e: Exception) {
			error(e.message!!)
		}

		return FirebaseStorage(storage, bucket)
	}*/

	@Bean
	fun response(): Response {
		return Response()
	}

	@Bean
	fun httpExceptionResponse(): HttpExceptionResponse {
		return HttpExceptionResponse()
	}

}