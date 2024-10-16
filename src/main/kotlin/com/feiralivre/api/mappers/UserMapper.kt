package com.feiralivre.api.mappers

import com.feiralivre.api.dtos.UserResponseDto
import com.feiralivre.api.dtos.UserRequestDto
import com.feiralivre.api.models.User
import org.springframework.stereotype.Service

@Service
class UserMapper {
    fun toDto(user: User): UserResponseDto {
        return UserResponseDto(
            id = user.id,
            name = user.name,
            storeName = user.storeName,
            cpf = user.cpf,
            cnpj = user.cnpj,
            email = user.email,
            phoneNumber = user.phoneNumber,
            active = user.active,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt
        )
    }

    fun fromDto(userRequestDto: UserRequestDto): User {
        return User(
            name = userRequestDto.name,
            storeName = userRequestDto.storeName,
            cpf = userRequestDto.cpf,
            cnpj = userRequestDto.cnpj,
            email = userRequestDto.email,
            phoneNumber = userRequestDto.phoneNumber,
            password = userRequestDto.password
        )
    }
}
