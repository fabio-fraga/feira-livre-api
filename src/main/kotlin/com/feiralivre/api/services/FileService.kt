package com.feiralivre.api.services

import com.feiralivre.api.models.File
import com.feiralivre.api.repositories.FileRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class FileService(private val repository: FileRepository) {
    fun create(file: File): File {
        return this.repository.save(file)
    }

    fun findById(id: UUID): File? {
        return this.repository.findById(id).orElse(null)
    }

//    fun delete(id: UUID) {
//        this.repository.deleteById(id)
//    }
}
