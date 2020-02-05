package com.primegenerator;

import com.primegenerator.dto.PrimeDto;
import com.primegenerator.model.Prime;
import com.primegenerator.repository.PrimeRepository;
import com.primegenerator.service.PrimeService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import org.junit.Before;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


//@RunWith(SpringRunner.class)
@SpringBootTest
class PrimeNumbersGeneratorApplicationTests {

    @Autowired
    private PrimeRepository primeRepository;

    @Autowired
    private PrimeService primeService;

    private PrimeDto primeDto;

    private Prime prime;

    //@Before
    public void setUp() {
        prime.setUserName("Kelvin");
        prime.setTimeStamp(new Date());
        prime.setNumberOfPrimes(22);
        prime.setPrimeRange("2 to 50");
        prime.setAlgorithm("Naive");
        prime.setTimeElapsed(400);
    }

	@Test
	void contextLoads() {
	}

	@Test
    public void testGeneratePrimeNumber() {
        List<Integer> primeNumbers = new ArrayList<>();
        //assertDoesNotThrow(() -> primeRepository.save(prime));
    }

}
