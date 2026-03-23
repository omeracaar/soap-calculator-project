package com.omeracar.soap_calculator.endpoint;

import com.omeracar.soap_calculator.ws.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculatorEndpoint {

    private static final String NAMESPACE_URI = "http://tempuri.org/";

    private CalculatorSoap getSoap() {
        Calculator service = new Calculator();
        return service.getCalculatorSoap();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Add")
    @ResponsePayload
    public AddResponse add(@RequestPayload Add request) {
        int a = request.getIntA();
        int b = request.getIntB();

        int result = getSoap().add(a, b);

        AddResponse response = new AddResponse();
        response.setAddResult(result);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Subtract")
    @ResponsePayload
    public SubtractResponse subtract(@RequestPayload Subtract request) {
        int a = request.getIntA();
        int b = request.getIntB();

        int result = getSoap().subtract(a, b);

        SubtractResponse response = new SubtractResponse();
        response.setSubtractResult(result);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Multiply")
    @ResponsePayload
    public MultiplyResponse multiply(@RequestPayload Multiply request) {
        int a = request.getIntA();
        int b = request.getIntB();

        int result = getSoap().multiply(a, b);

        MultiplyResponse response = new MultiplyResponse();
        response.setMultiplyResult(result);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Divide")
    @ResponsePayload
    public DivideResponse divide(@RequestPayload Divide request) {
        int a = request.getIntA();
        int b = request.getIntB();

        int result = getSoap().divide(a, b);

        DivideResponse response = new DivideResponse();
        response.setDivideResult(result);

        return response;
    }

}