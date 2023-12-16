package com.example.spring6reactivemongo.services;

import com.example.spring6reactivemongo.domain.Beer;
import com.example.spring6reactivemongo.model.BeerDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BeerService {
    Flux<BeerDto> listBeers();
    Mono<BeerDto> saveBeer(BeerDto beerDto);

    Mono<BeerDto> saveBeer(Mono<BeerDto> beerDto);

    Mono<BeerDto> getById(String beerId);

    Mono<BeerDto> updateBeer(String beerId, BeerDto beerDTO);

    Mono<BeerDto> patchBeer(String beerId, BeerDto beerDTO);

    Mono<Void> deleteBeerById(String beerId);

    Mono<BeerDto> findFirstByBeerName(String beerName);

    Flux<BeerDto> findByBeerStyle(String beerStyle);
}
