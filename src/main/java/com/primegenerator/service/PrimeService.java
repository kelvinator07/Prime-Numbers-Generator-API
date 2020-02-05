package com.primegenerator.service;

import com.primegenerator.dto.PrimeDto;

import java.util.List;

public interface PrimeService {

    List<Integer> generatePrimeNumbers(PrimeDto primeDto);

    String validateUserInput(PrimeDto primeDto);
}
