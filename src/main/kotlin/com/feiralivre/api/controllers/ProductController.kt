package com.feiralivre.api.controllers

import com.feiralivre.api.dtos.ProductRequestDto
import com.feiralivre.api.dtos.ProductResponseDto
import com.feiralivre.api.mappers.ProductMapper
import com.feiralivre.api.services.ProductService
import com.feiralivre.api.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productService: ProductService,
    private val userService: UserService,
    private val productMapper: ProductMapper
) {

    @PostMapping
    fun create(@RequestBody productRequestDto: ProductRequestDto): ResponseEntity<ProductResponseDto> {
        return try {
            val user = this.userService.findById(productRequestDto.userId)
                ?: return ResponseEntity(HttpStatus.NOT_FOUND)
            val product = this.productMapper.fromDto(productRequestDto, user)
            val createdProduct = this.productService.create(product)

            ResponseEntity(this.productMapper.toDto(createdProduct), HttpStatus.CREATED)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<ProductResponseDto> {
        return try {
            val product = this.productService.findById(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)

            ResponseEntity(this.productMapper.toDto(product), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<ProductResponseDto>> {
        return try {
            val products = this.productService.findAll()
            val productDtos = products.map { this.productMapper.toDto(it) }

            ResponseEntity(productDtos, HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

//    @PutMapping("/{id}")
//    fun update(@PathVariable id: UUID, @RequestBody productRequestDto: ProductRequestDto): ResponseEntity<ProductResponseDto> {
//        return try {
//            val product = this.productMapper.fromDto(productRequestDto)
//            val updatedProduct = this.productService.update(id, product) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
//            ResponseEntity(this.productMapper.toDto(updatedProduct), HttpStatus.OK)
//        } catch (e: Exception) {
//            ResponseEntity(HttpStatus.BAD_REQUEST)
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    fun delete(@PathVariable id: UUID): ResponseEntity<Void> {
//        return try {
//            this.productService.delete(id)
//            ResponseEntity(HttpStatus.NO_CONTENT)
//        } catch (e: Exception) {
//            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
//        }
//    }
}
