package com.example.customer.controller

import com.example.customer.dto.CustomerCreateDto
import com.example.customer.dto.CustomerDto
import com.example.customer.mapper.CustomerMapper
import com.example.customer.service.CustomerService
import com.example.shared.dto.PagedResponseDto
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val customerService: CustomerService,
    private val customerMapper: CustomerMapper
) {
    @GetMapping
    fun getCustomers(
        @PageableDefault(sort = ["id"], value = 10) pageable: Pageable
    ): PagedResponseDto<CustomerDto> {
        return customerMapper.customerPageToPagedResponseDto(
            customerService.getAllCustomers(pageable)
        )
    }

    @GetMapping("/{customerId}")
    fun getCustomer(
        @PathVariable customerId: UUID
    ): CustomerDto {
        return customerMapper.customerModelToCustomerDto(
            customerService.getCustomerById(customerId)
        )
    }

    @PostMapping
    fun createCustomer(
        @Valid @RequestBody customerCreateDto: CustomerCreateDto
    ): CustomerDto {
        return customerMapper.customerModelToCustomerDto(
            customerService.createCustomer(
                customerMapper.customerCreateDtoToCustomerModel(customerCreateDto)
            )
        )
    }
}
