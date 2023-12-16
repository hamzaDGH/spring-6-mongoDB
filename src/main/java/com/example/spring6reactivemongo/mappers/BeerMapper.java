package com.example.spring6reactivemongo.mappers;

import com.example.spring6reactivemongo.domain.Beer;
import com.example.spring6reactivemongo.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDto beerDto);
    BeerDto beerToBeerDto(Beer beer);
}
