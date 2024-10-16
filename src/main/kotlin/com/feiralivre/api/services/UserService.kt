package com.feiralivre.api.services

import com.feiralivre.api.models.User
import com.feiralivre.api.repositories.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID

@Service
class UserService(private val repository: UserRepository) {
    fun create(user: User): User {
        return this.repository.save(user)
    }

    fun findById(id: UUID): User? {
        return this.repository.findById(id).orElse(null)
    }

    fun findAll(): List<User> {
        return this.repository.findAll()
    }

    fun update(userId: UUID, updatedUser: User): User? {
        val existingUser = this.repository.findById(userId).orElse(null) ?: return null

        updatedUser.name.let { existingUser.name = it }
        updatedUser.storeName.let { existingUser.storeName = it }
        updatedUser.email.let { existingUser.email = it }
        updatedUser.phoneNumber.let { existingUser.phoneNumber = it }
        updatedUser.password.let { existingUser.password = it }

        existingUser.updatedAt = LocalDateTime.now()

        return this.repository.save(existingUser)
    }

    fun delete(id: UUID) {
        this.repository.deleteById(id)
    }
}
