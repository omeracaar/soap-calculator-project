package com.omeracar.soap_calculator.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

@EnableWs
@Configuration
public class WebServiceConfig {

    //soap requestleri karşılıyor
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServletRegistration(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet=new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet,"/ws/*");//localhost:8080/ws/
    }

    //calculator.wsdl i dışarıya açıyor
    @Bean(name = "calculator") //localhost:8080/ws/calculator.wsdl
    public SimpleWsdl11Definition calculatorWsdl() {
        return new SimpleWsdl11Definition(new ClassPathResource("calculator.wsdl"));
    }
}

