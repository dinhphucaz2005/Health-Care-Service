package com.example.spring_healthcare.model

import com.example.spring_healthcare.enum.Gender
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.util.UUID

@Document(collection = "users")
data class User(
    @Id
    val id: UUID? = null,
    val roleId: String,
    val name: String,
    val email: String,
    val username: String,
    val hashedPassword: String,
    val phone: String,
    val address: String? = null,
    val gender: Gender = Gender.OTHER,
    val avatar: String? = null,
    val dob: LocalDate? = null
)