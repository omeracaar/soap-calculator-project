package com.omeracar.soap_calculator.client;

import com.omeracar.soap_calculator.ws.CalculatorSoap;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CalculatorClient {

    private static final String WS_URL = "http://www.dneonline.com/calculator.asmx";

    private static CalculatorSoap createCalculatorSoap() {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(CalculatorSoap.class);
        factoryBean.setAddress(WS_URL);
        return (CalculatorSoap) factoryBean.create();
    }

    public static int add(int a, int b) {
        CalculatorSoap calculatorSoap = createCalculatorSoap();
        return calculatorSoap.add(a, b);
    }

    public static int subtract(int a, int b) {
        CalculatorSoap calculatorSoap = createCalculatorSoap();
        return calculatorSoap.subtract(a, b);
    }

    public static int multiply(int a, int b) {
        CalculatorSoap calculatorSoap = createCalculatorSoap();
        return calculatorSoap.multiply(a, b);
    }

    public static int divide(int a, int b) {
        CalculatorSoap calculatorSoap = createCalculatorSoap();
        return calculatorSoap.divide(a, b);
    }

}
