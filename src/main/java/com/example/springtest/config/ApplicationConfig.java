package com.example.springtest.config;

import com.example.springtest.service.TestService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.xml.ws.Endpoint;

//https://dzone.com/articles/soap-web-services-with-apache-cxf-and-spring-boot тут есть описания по конфигу

@Configuration
public class ApplicationConfig {

    @Bean
    public ServletRegistrationBean<CXFServlet> dispatcherServlet() {
        return new ServletRegistrationBean<CXFServlet>(new CXFServlet(), "/soap-api/*");
    }


    @Bean
    @Primary
    public DispatcherServletPath dispatcherServletPathProvider() {
        return () -> "";
    }
//вывод  реквеста/респонса в консоль
    @Bean(name=Bus.DEFAULT_BUS_ID)
    public SpringBus springBus(LoggingFeature loggingFeature) {

        SpringBus cxfBus = new  SpringBus();
        cxfBus.getFeatures().add(loggingFeature);

        return cxfBus;
    }

    @Bean
    public LoggingFeature loggingFeature() {

        LoggingFeature loggingFeature = new LoggingFeature();
        loggingFeature.setPrettyLogging(true);

        return loggingFeature;
    }
//определение Endpoint
    @Bean
    public Endpoint endpoint(Bus bus, TestService accountServiceEndpoint) {

        EndpointImpl endpoint = new EndpointImpl(bus, accountServiceEndpoint);
        endpoint.publish("/service/accounts");

        return endpoint;
    }
}
