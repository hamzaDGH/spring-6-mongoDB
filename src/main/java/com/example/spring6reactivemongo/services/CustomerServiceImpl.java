package com.example.spring6reactivemongo.services;

import com.example.spring6reactivemongo.model.CustomerDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Mono<CustomerDto> saveCustomer(CustomerDto customerDto) {
        return null;

    }

    @Override
    public Mono<CustomerDto> getById(String id) {
        return null;
    }
}
