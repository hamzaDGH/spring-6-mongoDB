package com.example.spring6reactivemongo.services;

import com.example.spring6reactivemongo.model.CustomerDto;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Mono<CustomerDto> saveCustomer(CustomerDto customerDto);

    Mono<CustomerDto> getById (String id);
}
