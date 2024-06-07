package org.example.validattion_api_session03;

import org.example.validattion_api_session03.common.ConvertAccount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ValidattionApiSession03Application {

    public static void main(String[] args) {
        SpringApplication.run(ValidattionApiSession03Application.class, args);
    }

    @Bean
    public ConvertAccount convertAccount(){
        return new ConvertAccount();
    }
}
