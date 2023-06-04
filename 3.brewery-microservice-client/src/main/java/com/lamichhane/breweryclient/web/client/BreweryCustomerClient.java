package com.lamichhane.breweryclient.web.client;

import com.lamichhane.breweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery",ignoreUnknownFields = false)
public class BreweryCustomerClient {

    private final RestTemplate restTemplate;
    public final String BEER_PATH_V1 = "/api/v1/customer";
    private String apihost;

    public void setApihost(String apihost){
        this.apihost = apihost;
    }

    public BreweryCustomerClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID uuid){
        return restTemplate.getForObject(apihost+BEER_PATH_V1+"/"+uuid.toString(),CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apihost+BEER_PATH_V1,customerDto);
    }

    public void updateCustomer(UUID uuid,CustomerDto customerDto){
        restTemplate.put(apihost+BEER_PATH_V1+"/"+uuid.toString(),customerDto);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apihost+BEER_PATH_V1+"/"+uuid);
    }
}
