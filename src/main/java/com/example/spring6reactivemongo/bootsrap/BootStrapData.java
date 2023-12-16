package com.example.spring6reactivemongo.bootsrap;

import com.example.spring6reactivemongo.domain.Beer;
import com.example.spring6reactivemongo.domain.Customer;
import com.example.spring6reactivemongo.repositories.BeerRepository;
import com.example.spring6reactivemongo.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class BootStrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        beerRepository.deleteAll()
                .doOnSuccess(success ->{
                    loadBeerData();
                }).subscribe();

        //loadCustomerData();

        beerRepository.count().subscribe(count -> {
            System.out.println("Beer count is: " + count);
        });

//        customerRepository.count().subscribe(count -> {
//            System.out.println("Customer count is: " + count);
//        });
    }

    private void loadBeerData() {
        beerRepository.count().subscribe(count -> {
            if (count == 0) {
                Beer beer1 = Beer.builder()
                        .beerName("Bud Light")
                        .beerStyle("Pale Ale")
                        .upc("1234576")
                        .price(new BigDecimal("12.99"))
                        .quantityOnHand(122)
                        .createDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                Beer beer2 = Beer.builder()
                        .beerName("Budweiser")
                        .beerStyle("Pale Ale")
                        .upc("12345645")
                        .price(new BigDecimal("11.99"))
                        .quantityOnHand(392)
                        .createDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                Beer beer3 = Beer.builder()
                        .beerName("Corona")
                        .beerStyle("Pale Ale")
                        .upc("134533")
                        .price(new BigDecimal("7.99"))
                        .quantityOnHand(144)
                        .createDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                beerRepository.saveAll(Arrays.asList(beer1, beer2, beer3)).subscribe();
            }
        });

    }

    private void loadCustomerData() {
        customerRepository.count().subscribe(count->{
            if (count == 0) {
                Customer customer1 = Customer.builder()
                        .customerName("HamzaDg")
                        .createDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                Customer customer2 = Customer.builder()
                        .customerName("ImaneBelma")
                        .createDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                Customer customer3 = Customer.builder()
                        .customerName("MarouaneDg")
                        .createDate(LocalDateTime.now())
                        .lastModifiedDate(LocalDateTime.now())
                        .build();

                customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3)).subscribe();
            }
        });
    }
}
