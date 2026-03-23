package com.omeracar.soap_calculator.service;

import com.omeracar.soap_calculator.client.CalculatorClient;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int add(int a, int b) {
        return CalculatorClient.add(a, b);
    }

    public int subtract(int a, int b) {
        return CalculatorClient.subtract(a, b);
    }

    public int multiply(int a, int b) {
        return CalculatorClient.multiply(a, b);
    }

    public int divide(int a, int b) {
        return CalculatorClient.divide(a, b);
    }
}
