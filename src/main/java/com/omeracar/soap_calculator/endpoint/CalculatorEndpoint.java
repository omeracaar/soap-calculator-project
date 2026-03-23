package com.omeracar.soap_calculator.endpoint;

import com.omeracar.soap_calculator.client.CalculatorClient;
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
        int result = CalculatorClient.add(request.getIntA(), request.getIntB());
        AddResponse response = new AddResponse();
        response.setAddResult(result);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Subtract")
    @ResponsePayload
    public SubtractResponse subtract(@RequestPayload Subtract request) {
        int result = CalculatorClient.subtract(request.getIntA(), request.getIntB());
        SubtractResponse response = new SubtractResponse();
        response.setSubtractResult(result);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Multiply")
    @ResponsePayload
    public MultiplyResponse multiply(@RequestPayload Multiply request) {
        int result = CalculatorClient.multiply(request.getIntA(), request.getIntB());
        MultiplyResponse response = new MultiplyResponse();
        response.setMultiplyResult(result);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Divide")
    @ResponsePayload
    public DivideResponse divide(@RequestPayload Divide request) {
        int result = CalculatorClient.divide(request.getIntA(), request.getIntB());
        DivideResponse response = new DivideResponse();
        response.setDivideResult(result);
        return response;
    }

}