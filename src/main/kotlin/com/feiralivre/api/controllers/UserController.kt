package com.feiralivre.api.controllers

import com.feiralivre.api.dtos.UserRequestDto
import com.feiralivre.api.dtos.UserResponseDto
import com.feiralivre.api.mappers.UserMapper
import com.feiralivre.api.models.Greeting
import com.feiralivre.api.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService,
    private val userMapper: UserMapper
) {

    @PostMapping
    fun create(@RequestBody userRequestDto: UserRequestDto): ResponseEntity<UserResponseDto> {
        return try {
            val user = this.userMapper.fromDto(userRequestDto)
            val createdUser = this.userService.create(user)

            ResponseEntity(this.userMapper.toDto(createdUser), HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<UserResponseDto> {
        return try {
            val user = this.userService.findById(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)

            ResponseEntity(this.userMapper.toDto(user), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<UserResponseDto>> {
        return try {
            val users = this.userService.findAll()
            val userDtos = users.map { this.userMapper.toDto(it) }

            ResponseEntity.ok(userDtos)
        } catch (e: Exception) {
            println(e.message)
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody userRequestDto: UserRequestDto): ResponseEntity<UserResponseDto> {
        return try {
            val user = this.userMapper.fromDto(userRequestDto)
            val updatedUser = this.userService.update(id, user) ?: return ResponseEntity(HttpStatus.NOT_FOUND)

            ResponseEntity(this.userMapper.toDto(updatedUser), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: UUID): ResponseEntity<Void> {
        return try {
            this.userService.delete(id)

            ResponseEntity(HttpStatus.NO_CONTENT)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}
