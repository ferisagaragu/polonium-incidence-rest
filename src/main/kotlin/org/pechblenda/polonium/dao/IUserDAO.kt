package org.pechblenda.polonium.dao

import org.pechblenda.polonium.entity.User
import org.springframework.data.jpa.repository.Query

import org.springframework.data.repository.CrudRepository

import java.util.UUID
import java.util.Optional


interface IUserDAO: CrudRepository<User, UUID> {

	fun findByUserName(userName: String): Optional<User>

	@Query(
		"select user from User user where " +
		"user.email = :userName or user.userName = :userName"
	)
	fun findByUserNameOrEmail(userName: String): Optional<User>

}