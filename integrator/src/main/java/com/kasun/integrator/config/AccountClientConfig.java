package com.kasun.integrator.config;

import com.kasun.integrator.client.*;
import com.kasun.integrator.wsdl.GetTotalAccountBalanceResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class AccountClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.kasun.integrator.wsdl");
        return jaxb2Marshaller;
    }

    @Bean
    public AccountClient countryClient(Jaxb2Marshaller marshaller) {
        AccountClient client = new AccountClient();
        client.setDefaultUri("http://localhost:8080/soapWS");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public GetAccountBalanceClient getAccountBalanceClient(Jaxb2Marshaller marshaller) {
        GetAccountBalanceClient client = new GetAccountBalanceClient();
        client.setDefaultUri("http://localhost:8080/soapWS");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public FundTransferOwnClient fundTransferOwnClient(Jaxb2Marshaller marshaller) {
        FundTransferOwnClient client = new FundTransferOwnClient();
        client.setDefaultUri("http://localhost:8080/soapWS");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public FundTransferOtherClient fundTransferOtherClient(Jaxb2Marshaller marshaller) {
        FundTransferOtherClient client = new FundTransferOtherClient();
        client.setDefaultUri("http://localhost:8080/soapWS");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public GetTotalAccountBalanceClient getTotalAccountBalanceClient(Jaxb2Marshaller marshaller) {
        GetTotalAccountBalanceClient client = new GetTotalAccountBalanceClient();
        client.setDefaultUri("http://localhost:8080/soapWS");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
