package com.feiralivre.api.dtos

import java.time.LocalDateTime
import java.util.UUID

data class UserResponseDto(
    val id: UUID,
    val name: String,
    val storeName: String,
    val cpf: String,
    val cnpj: String?,
    val email: String,
    val phoneNumber: String,
    val active: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
