package com.feiralivre.api.repositories

import com.feiralivre.api.models.File
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface FileRepository : JpaRepository<File, UUID> {}
