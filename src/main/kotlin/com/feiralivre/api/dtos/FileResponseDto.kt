package com.feiralivre.api.dtos

import java.time.LocalDateTime
import java.util.UUID

data class FileResponseDto(
    val id: UUID,
    val key: String,
    val contentType: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val productId: UUID
)
