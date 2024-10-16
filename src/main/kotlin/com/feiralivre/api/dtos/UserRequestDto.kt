package com.feiralivre.api.dtos

data class UserRequestDto(
    val name: String,
    val storeName: String,
    val cpf: String,
    val cnpj: String?,
    val email: String,
    val phoneNumber: String,
    val password: String
)
