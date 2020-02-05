package com.primegenerator.service;

import com.primegenerator.dto.PrimeDto;
import com.primegenerator.model.Prime;
import com.primegenerator.repository.PrimeRepository;
import com.primegenerator.response.PrimeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PrimeServiceImpl implements PrimeService {

    @Autowired
    private PrimeRepository primeRepository;

    private Prime prime = new Prime();
    private long startTime;
    private long stopTime;

    @Override
    public List<Integer> generatePrimeNumbers(PrimeDto primeDto) {

        List<Integer> primeNumbers = new ArrayList<>();
        String algorithmSelected = "";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(primeDto.getStartValue());
        stringBuilder.append(" to ");
        stringBuilder.append(primeDto.getStopValue());

        if (primeDto.getSelection() == 1) {
            // Naive/BruteForce approach has a time complexity of O(n^2)
            primeNumbers = naiveApproach(primeDto.getStartValue(), primeDto.getStopValue());
            algorithmSelected = "Naive/BruteForce Approach";
        } else {
            // Sieve Algorithm has a time complexity of O(n logn)
            primeNumbers = seivePrime(primeDto.getStartValue(), primeDto.getStopValue());
            algorithmSelected = "Sieve Approach";
        }

        // calculate algorithm duration
        final long duration = (stopTime - startTime) / 1000;

        prime.setUserName(primeDto.getUsername());
        prime.setAlgorithm(algorithmSelected);
        prime.setNumberOfPrimes(primeNumbers.size());
        prime.setPrimeRange(stringBuilder.toString());
        prime.setTimeElapsed(duration);
        prime.setTimeStamp(new Date());

        // Save prime to database
        primeRepository.save(prime);

        return primeNumbers;
    }

    @Override
    public String validateUserInput(PrimeDto primeDto) {

        String validationMessage = null;

        if (primeDto.getSelection() < 1 || primeDto.getSelection() > 2) {
            validationMessage = "Selection should be 1 for Naive/BruteForce Approach or 2 for Sieve Algorithm";
        } else if (primeDto.getStartValue() < 1) {
            validationMessage = "Start Value must be greater than zero";
        } else if (primeDto.getStopValue() <= primeDto.getStartValue()) {
            validationMessage = "Stop Value must be greater than Start Value";
        }

        return validationMessage;
    }

    private List<Integer> seivePrime(int startValue, int stopValue) {
        startTime = System.nanoTime();

        List<Integer> primeNumbers = new ArrayList<>();

        stopTime = System.nanoTime();
        return primeNumbers;
    }

    private List<Integer> naiveApproach(int startValue, int stopValue) {
        startTime = System.nanoTime();

        List<Integer> primeNumbers = new ArrayList<>();

        for (int i = startValue; i <= stopValue; i++) {
            if (numberIsAPrime(i)) {
                primeNumbers.add(i);
            }
        }

        stopTime = System.nanoTime();
        return primeNumbers;
    }

    private boolean numberIsAPrime(int number) {
        // skip number 1
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
