package com.lamichhane.beer.service.web.model;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@SuperBuilder
@Getter
@Setter
@Jacksonized
public class BeerDto {

    @Null
    private UUID id;

    @NotBlank(message = "beer name can't be empty or null")
    @Size(min=3,max=10,message = "size must be between 3 and 10")
    private String beerName;

    @Null
    private Integer version;

    @Null
    private OffsetDateTime createdDate;

    @Null
    private OffsetDateTime lastModifiedDate;

    @NotNull
    private String beerStyle;

    @Positive
    @NotNull
    private Long upc;

    @Positive
    @NotNull
    private BigDecimal price;
    private Integer quantityOnHand;

}
