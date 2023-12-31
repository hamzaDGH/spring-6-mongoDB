package com.example.spring6reactivemongo.services;

import com.example.spring6reactivemongo.mappers.BeerMapper;
import com.example.spring6reactivemongo.model.BeerDto;
import com.example.spring6reactivemongo.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerMapper beerMapper;

    private final BeerRepository beerRepository;

    @Override
    public Flux<BeerDto> listBeers() {
        return beerRepository.findAll().map(beerMapper::beerToBeerDto);
    }

    @Override
    public Mono<BeerDto> saveBeer(BeerDto beerDto) {
        return beerRepository.save(beerMapper.beerDtoToBeer(beerDto)).map(beerMapper::beerToBeerDto);
    }

    @Override
    public Mono<BeerDto> saveBeer(Mono<BeerDto> beerDto) {
        return beerDto.map(beerMapper::beerDtoToBeer)
                .flatMap(beerRepository::save)
                .map(beerMapper::beerToBeerDto);
    }

    @Override
    public Mono<BeerDto> getById(String beerId) {
        return beerRepository.findById(beerId).map(beerMapper::beerToBeerDto);
    }

    @Override
    public Mono<BeerDto> updateBeer(String beerId, BeerDto beerDto) {
        return beerRepository.findById(beerId)
                .map(foundBeer -> {
                    foundBeer.setBeerName(beerDto.getBeerName());
                    foundBeer.setBeerStyle(beerDto.getBeerStyle());
                    foundBeer.setUpc(beerDto.getUpc());
                    foundBeer.setQuantityOnHand(beerDto.getQuantityOnHand());
                    foundBeer.setPrice(beerDto.getPrice());
                    return foundBeer;
                }).flatMap(beerRepository::save).map(beerMapper::beerToBeerDto);
    }

    @Override
    public Mono<BeerDto> patchBeer(String beerId, BeerDto beerDto) {
        return beerRepository.findById(beerId)
                .map(foundBeer -> {
                    if (StringUtils.hasText(foundBeer.getBeerName())) {
                        foundBeer.setBeerName(beerDto.getBeerName());
                    }
                    if (StringUtils.hasText(foundBeer.getBeerStyle())) {
                        foundBeer.setBeerStyle(foundBeer.getBeerStyle());
                    }
                    if (StringUtils.hasText(foundBeer.getUpc())) {
                        foundBeer.setUpc(beerDto.getUpc());
                    }
                    if (foundBeer.getQuantityOnHand() != null) {
                        foundBeer.setQuantityOnHand(beerDto.getQuantityOnHand());
                    }
                    if (foundBeer.getPrice() != null) {
                        foundBeer.setPrice(beerDto.getPrice());
                    }
                    return foundBeer;
                }).flatMap(beerRepository::save).map(beerMapper::beerToBeerDto);
    }

    @Override
    public Mono<Void> deleteBeerById(String beerId) {
        return beerRepository.deleteById(beerId);
    }

    @Override
    public Mono<BeerDto> findFirstByBeerName(String beerName) {
        return beerRepository.findFirstByBeerName(beerName)
                .map(beerMapper::beerToBeerDto);
    }

    @Override
    public Flux<BeerDto> findByBeerStyle(String beerStyle) {
        return beerRepository.findByBeerStyle(beerStyle)
                .map(beerMapper::beerToBeerDto);
    }
}
