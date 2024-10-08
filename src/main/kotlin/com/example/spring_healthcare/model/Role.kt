package com.example.spring_healthcare.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "roles")
data class Role(
    @Id val name: String,
    val description: String
)