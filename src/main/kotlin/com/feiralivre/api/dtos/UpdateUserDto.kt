package com.feiralivre.api.dtos

data class UpdateUserDto(
    val name: String?,
    val storeName: String?,
    val email: String?,
    val phoneNumber: String?,
    val password: String?
)
