package com.omeracar.soap_calculator.service;

import com.omeracar.soap_calculator.client.CalculatorClient;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int add(int a, int b) {
        return CalculatorClient.add(a, b);
    }
