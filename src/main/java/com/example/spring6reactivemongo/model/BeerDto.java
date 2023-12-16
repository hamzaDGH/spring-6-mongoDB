package com.example.spring6reactivemongo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDto {

    private String id;

    @NotBlank
    @Size(min = 3,max = 255)
    private String beerName;

    @Size(min = 1,max = 255)
    private String beerStyle;

    @Size(max = 255)
    private String upc;
    private Integer quantityOnHand;
    private BigDecimal price;
    private LocalDateTime createDate;
    private LocalDateTime lastModifiedDate;
}
