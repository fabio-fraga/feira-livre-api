package com.feiralivre.api.mappers

import com.feiralivre.api.dtos.ProductRequestDto
import com.feiralivre.api.dtos.ProductResponseDto
import com.feiralivre.api.models.Product
import com.feiralivre.api.models.User
import org.springframework.stereotype.Service

@Service
class ProductMapper(private val fileMapper: FileMapper) {
    fun toDto(product: Product): ProductResponseDto {
        return ProductResponseDto(
            id = product.id,
            title = product.title,
            description = product.description,
            quantity = product.quantity,
            price = product.price,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt,
            userId = product.user.id,
            files = product.files.map { fileMapper.toDto(it) }
        )
    }

    fun fromDto(productRequestDto: ProductRequestDto, user: User): Product {
        return Product(
            title = productRequestDto.title,
            description = productRequestDto.description,
            quantity = productRequestDto.quantity,
            price = productRequestDto.price,
            user = user
        )
    }
}
