package com.feiralivre.api.dtos

import java.util.UUID

data class CreateProductDto(
    val title: String,
    val description: String?,
    val quantity: Int,
    val price: Float,
    val userId: UUID
)

