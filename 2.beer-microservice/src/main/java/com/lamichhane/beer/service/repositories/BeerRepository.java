package com.lamichhane.beer.service.repositories;

import com.lamichhane.beer.service.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {

}
