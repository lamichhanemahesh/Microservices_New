package com.lamichhane.breweryclient.web.client;

import com.lamichhane.breweryclient.web.model.BeerDto;
import com.lamichhane.breweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryCustomerClientTest {

    @Autowired
    BreweryCustomerClient breweryCustomerClient;

    @Test
    void getCustomerById() {
        CustomerDto dto = breweryCustomerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto dto = CustomerDto.builder().id(UUID.randomUUID()).build();
        URI uri = breweryCustomerClient.saveNewCustomer(dto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).build();
        breweryCustomerClient.updateCustomer(UUID.randomUUID(),customerDto);
    }

    @Test
    void deleteCustomer() {
        breweryCustomerClient.deleteCustomer(UUID.randomUUID());
    }
}