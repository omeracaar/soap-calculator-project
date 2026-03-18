package com.omeracar.soap_calculator.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.omeracar.calculator.wsdl.Add;
import com.omeracar.calculator.wsdl.AddResponse;
import com.omeracar.calculator.wsdl.Subtract;
import com.omeracar.calculator.wsdl.SubtractResponse;
import com.omeracar.calculator.wsdl.Divide;
import com.omeracar.calculator.wsdl.DivideResponse;
import com.omeracar.calculator.wsdl.Multiply;
import com.omeracar.calculator.wsdl.MultiplyResponse;


@Endpoint
public class CalculatorEndpoint {

    //wsdl den geldi
    private static final String NAMESPACE_URI = "http://tempuri.org/";

    //wsdl deki element name i add olduğu için endpoint
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Add")
    @ResponsePayload
    public AddResponse addResponse(@RequestPayload Add addRequest){

        //request attığımız sayılar
        //bu metotlar hazir geldi
        int a=addRequest.getIntA();
        int b=addRequest.getIntB();

        AddResponse response=new AddResponse();
        response.setAddResult(a+b);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Subtract")
    @ResponsePayload
    public SubtractResponse subtractResponse(@RequestPayload Subtract subtractRequest){

        int a=subtractRequest.getIntA();
        int b=subtractRequest.getIntB();

        SubtractResponse response = new SubtractResponse();
        response.setSubtractResult(a - b);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Divide")
    @ResponsePayload
    public DivideResponse divideResponse(@RequestPayload Divide divideRequest){

        int a=divideRequest.getIntA();
        int b=divideRequest.getIntB();

        if (b==0){
            throw new ArithmeticException("You can't divide by 0");
        }

        DivideResponse response=new DivideResponse();
        response.setDivideResult(a/b);

        return response;
    }

}
