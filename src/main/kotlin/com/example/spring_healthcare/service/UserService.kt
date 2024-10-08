package com.example.spring_healthcare.service

import com.example.spring_healthcare.model.User
import com.example.spring_healthcare.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
) {

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun getUserById(id: String): User? {
        return userRepository.findById(id).orElse(null)
    }

    fun getUsersByName(name: String): List<User> {
        return userRepository.findByName(name)
    }

    fun updateUser(id: String, updatedUser: User): User? {
        val existingUser = getUserById(id)
        return if (existingUser != null) {
            val userToUpdate = existingUser.copy(
                name = updatedUser.name,
                email = updatedUser.email,
                phone = updatedUser.phone,
                dob = updatedUser.dob
            )
            userRepository.save(userToUpdate)
        } else {
            null
        }
    }

    fun deleteUser(id: String): Boolean {
        return if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
