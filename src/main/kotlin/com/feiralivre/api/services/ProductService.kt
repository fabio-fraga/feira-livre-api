package com.feiralivre.api.services

import com.feiralivre.api.models.Product
import com.feiralivre.api.repositories.ProductRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID

@Service
class ProductService(private val repository: ProductRepository) {
    fun create(product: Product): Product {
        return this.repository.save(product)
    }

    fun findById(id: UUID): Product? {
        return this.repository.findById(id).orElse(null)
    }

    fun findAll(): List<Product> {
        return this.repository.findAll()
    }

//    fun update(productId: UUID, updatedProduct: Product): Product? {
//        val existingProduct = this.repository.findById(productId).orElse(null) ?: return null
//
//        updatedProduct.title.let { existingProduct.title = it }
//        updatedProduct.description?.let { existingProduct.description = it }
//        updatedProduct.quantity.let { existingProduct.quantity = it }
//        updatedProduct.price.let { existingProduct.price = it }
//
//        existingProduct.updatedAt = LocalDateTime.now()
//
//        return this.repository.save(existingProduct)
//    }

//    fun delete(id: UUID) {
//        this.repository.deleteById(id)
//    }
}
