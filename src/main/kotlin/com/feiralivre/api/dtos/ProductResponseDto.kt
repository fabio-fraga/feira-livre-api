package com.feiralivre.api.dtos

import java.time.LocalDateTime
import java.util.UUID

data class ProductResponseDto(
    val id: UUID,
    val title: String,
    val description: String?,
    val quantity: Int,
    val price: Float,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val userId: UUID,
    val files: List<FileResponseDto>
)
