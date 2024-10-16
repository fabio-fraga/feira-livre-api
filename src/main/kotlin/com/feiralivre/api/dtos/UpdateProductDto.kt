package com.feiralivre.api.dtos

data class UpdateProductDto(
    val title: String?,
    val description: String?,
    val quantity: Int?,
    val price: Float?
)

