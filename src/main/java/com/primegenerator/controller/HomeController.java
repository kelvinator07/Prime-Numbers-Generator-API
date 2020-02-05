package com.primegenerator.controller;


import com.primegenerator.dto.PrimeDto;
import com.primegenerator.response.PrimeResponse;
import com.primegenerator.service.PrimeService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private PrimeService primeService;

    @ApiOperation(value = "Generate Prime Numbers", response = Boolean.class)
    @PostMapping("/prime")
    public ResponseEntity<?> primeGenerator(@RequestBody PrimeDto primeDto) {
//    public ResponseEntity<?> primeGenerator(@RequestParam("username") String username,
//                                  @RequestParam("selection") int selection,
//                                  @RequestParam("startValue") int startValue,
//                                  @RequestParam("stopValue") int stopValue ) {
//			@RequestParam(value="search", required = false) String search,

        PrimeResponse primeResponse = new PrimeResponse();

        String validationMessage = primeService.validateUserInput(primeDto);

        if (validationMessage != null) {
            primeResponse.setResponseCode(00);
            primeResponse.setResponseMessage(validationMessage);
            return new ResponseEntity<>(primeResponse, HttpStatus.BAD_REQUEST);
        }

        List<Integer> list = new ArrayList<>();
        list = primeService.generatePrimeNumbers(primeDto);
        String result = list.toString();

        primeResponse.setResponseCode(01);
        primeResponse.setResponseMessage(result);
        return new ResponseEntity<>(primeResponse, HttpStatus.OK);
    }


}
