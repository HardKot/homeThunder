package com.homethunder.backend.repository

import com.homethunder.backend.domain.entity.Post
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PostRepository : CrudRepository<Post, UUID> {
}
