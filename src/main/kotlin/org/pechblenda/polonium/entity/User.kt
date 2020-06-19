package org.pechblenda.polonium.entity

import org.pechblenda.rest.Response
import org.pechblenda.rest.annotation.Key
import org.pechblenda.rest.helper.ResponseList
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table


@Entity
@Table(name = "users")
class User(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	var id: UUID,
	var name: String,

	@Column( unique = true)
	var userName: String,

	@Column( unique = true)
	var email: String,

	var password: String,

	@ManyToMany
	var roles: MutableList<Role>
) {

	@Key(name = "roles", autoCall = true)
	fun convertRoles(): List<String> {
		return roles.map { role -> role.name }
	}

}