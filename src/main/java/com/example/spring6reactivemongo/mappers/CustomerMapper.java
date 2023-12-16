package com.example.spring6reactivemongo.mappers;

import com.example.spring6reactivemongo.domain.Customer;
import com.example.spring6reactivemongo.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customer);
}
