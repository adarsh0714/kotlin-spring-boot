package com.example.customer.repository

import com.example.customer.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CustomerRepository : JpaRepository<Customer, UUID> {
}