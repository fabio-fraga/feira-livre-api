package com.feiralivre.api.dtos

import java.util.UUID

data class CreateFileDto(
    val key: String,
    val contentType: String,
    val productId: UUID
)

