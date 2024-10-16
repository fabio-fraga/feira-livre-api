package com.feiralivre.api.mappers

import com.feiralivre.api.dtos.FileRequestDto
import com.feiralivre.api.dtos.FileResponseDto
import com.feiralivre.api.models.File
import com.feiralivre.api.models.Product
import org.springframework.stereotype.Service

@Service
class FileMapper {
    fun toDto(file: File): FileResponseDto {
        return FileResponseDto(
            id = file.id,
            key = file.key,
            contentType = file.contentType,
            createdAt = file.createdAt,
            updatedAt = file.updatedAt,
            productId = file.product.id
        )
    }

    fun fromDto(fileRequestDto: FileRequestDto, product: Product): File {
        return File(
            key = fileRequestDto.key,
            contentType = fileRequestDto.contentType,
            product = product
        )
    }

}
