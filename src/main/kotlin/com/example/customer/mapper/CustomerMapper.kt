package com.example.customer.mapper

import com.example.customer.dto.CustomerCreateDto
import com.example.customer.dto.CustomerDto
import com.example.customer.model.Customer
import com.example.shared.config.MapperConfig
import com.example.shared.dto.PagedResponseDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.springframework.data.domain.Page

@Mapper(config = MapperConfig::class)
abstract class CustomerMapper {

    fun customerPageToPagedResponseDto(customersPage: Page<Customer>): PagedResponseDto<CustomerDto> {
        return PagedResponseDto(
            entities = customersPage.content.map { customer -> customerModelToCustomerDto(customer) },
            total = customersPage.totalElements,
            totalPages = customersPage.totalPages,
            page = customersPage.pageable.pageNumber,
            pageSize = customersPage.pageable.pageSize
        )
    }

    abstract fun customerModelToCustomerDto(customer: Customer): CustomerDto

    @Mapping(target = "id", ignore = true)
    abstract fun customerCreateDtoToCustomerModel(customerCreateDto: CustomerCreateDto): Customer
}