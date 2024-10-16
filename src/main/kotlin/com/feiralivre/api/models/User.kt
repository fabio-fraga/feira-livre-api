package com.feiralivre.api.models

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    var name: String,

    @Column(name = "store_name", unique = true, nullable = false)
    var storeName: String,

    @Column(unique = true, length = 11)
    val cpf: String,

    @Column(name = "cnpj", unique = true, length = 14)
    val cnpj: String? = null,

    @Column(unique = true, nullable = false)
    var email: String,

    @Column(name = "email_verified_at")
    val emailVerifiedAt: LocalDateTime? = null,

    @Column(name = "phone_number", unique = true, nullable = false)
    var phoneNumber: String,

    @Column(nullable = false)
    var password: String,

    @Column(nullable = false)
    val active: Boolean = true,

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val products: List<Product> = emptyList()
)
