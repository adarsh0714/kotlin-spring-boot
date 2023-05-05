package com.example.customer.dto

import java.util.UUID

data class CustomerDto(
    val id: UUID,

    val name: String,

    val email: String,

    val age: Int
)
