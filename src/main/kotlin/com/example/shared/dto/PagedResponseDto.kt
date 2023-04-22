package com.example.shared.dto

data class PagedResponseDto<T>(
    val entities: List<T>,

    val total: Long,

    val totalPages: Int,

    val page: Int,

    val pageSize: Int
)
