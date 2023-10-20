package com.furkankayam.lab0project.model

import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import java.util.UUID

@Entity
@Table(name = "users")
data class User (
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    val id: UUID? = null,

    @Column(name = "first_name", nullable = false)
    val firstName: String,

    @Column(name = "last_name", nullable = false)
    val lastName: String,

    @Column(name = "phone_number", nullable = false)
    val phoneNumber: String,

    @Column(nullable = false)
    val password: String? = null,

    @Column(nullable = false)
    val email: String? = null,

    @Column(nullable = false)
    val address: String

) {
}