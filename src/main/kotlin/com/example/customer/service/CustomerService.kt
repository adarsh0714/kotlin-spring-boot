package com.example.customer.service

import com.example.customer.model.Customer
import com.example.customer.repository.CustomerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {
    fun getAllCustomers(pageable: Pageable): Page<Customer> {
        return customerRepository.findAll(pageable)
    }

    fun getCustomerById(customerId: UUID): Customer {
        return customerRepository.findByIdOrNull(customerId) ?: throw RuntimeException("$customerId doesn't exist")
    }

    fun createCustomer(customer: Customer): Customer {
        return customerRepository.save(customer)
    }
}