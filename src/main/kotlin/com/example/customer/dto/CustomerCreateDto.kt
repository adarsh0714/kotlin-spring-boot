package com.example.customer.dto

import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size

data class CustomerCreateDto(
    @field:Size(max = 255)
    val name: String? = null,

    @field:Size(max = 255)
    val email: String? = null,

    @field:Positive
    val age: Int? = null
)
