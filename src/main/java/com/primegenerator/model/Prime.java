package com.primegenerator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Kelvin
 *
 */
@Entity
public class Prime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private Date timeStamp;

    private String primeRange;

    private long timeElapsed;

    private String algorithm;

    private int numberOfPrimes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPrimeRange() {
        return primeRange;
    }

    public void setPrimeRange(String primeRange) {
        this.primeRange = primeRange;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public int getNumberOfPrimes() {
        return numberOfPrimes;
    }

    public void setNumberOfPrimes(int numberOfPrimes) {
        this.numberOfPrimes = numberOfPrimes;
    }
}
