package com.feiralivre.api.dtos

import java.util.UUID

data class FileRequestDto(
    val key: String,
    val contentType: String,
    val productId: UUID
)
