package com.lamichhane.beer.service.web.controller;

import com.lamichhane.beer.service.web.model.BeerDto;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Validated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@NotNull(message = "id can't be null") @PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDto beerDto){
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId,@Validated @RequestBody BeerDto beerDto){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
//        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
//        e.getConstraintViolations().forEach(constraintViolation -> {
//            errors.add(constraintViolation.getPropertyPath()+":"+constraintViolation.getMessage());
//        });
//        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
//    }
}
