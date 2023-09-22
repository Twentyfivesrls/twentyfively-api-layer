package com.twentyfive.twentyfivelyapilayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.twentyfive.authorizationcontroller", "com.twentyfive.twentyfivelyapilayer"})
@SpringBootApplication
@EnableFeignClients
public class TwentyfivelyApiLayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwentyfivelyApiLayerApplication.class, args);
    }

}
