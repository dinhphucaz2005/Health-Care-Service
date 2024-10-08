package com.example.spring_healthcare.repository

import com.example.spring_healthcare.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String> {
    fun findByName(name: String): List<User>
}
