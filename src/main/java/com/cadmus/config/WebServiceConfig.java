package com.cadmus.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
@EnableJpaRepositories
public class WebServiceConfig {
    
    
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }
    
    @Bean(name = "books")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(schema);
        definition.setLocationUri("/ws");
        definition.setPortTypeName("bookPort");
        definition.setTargetNamespace("http://www.webservicesoap.org/camadus");
        return definition;
    }
    
    @Bean
    public XsdSchema schema() {
        return new SimpleXsdSchema(new ClassPathResource("books.xsd"));
    }
}