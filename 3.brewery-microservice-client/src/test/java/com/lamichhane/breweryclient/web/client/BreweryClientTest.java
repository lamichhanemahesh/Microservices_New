package com.lamichhane.breweryclient.web.client;

import com.lamichhane.breweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryBeerClient breweryBeerClient;

    @Test
    void getBeerById() {
        BeerDto dto = breweryBeerClient.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {
        BeerDto dto = BeerDto.builder().beerName("New Beer").build();
        URI uri = breweryBeerClient.saveNewBeer(dto);
        assertNotNull(uri);
    }

    @Test
    void updateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        breweryBeerClient.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    void deleteBeer(){
        breweryBeerClient.deleteBeer(UUID.randomUUID());
    }
}