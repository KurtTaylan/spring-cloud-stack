package com.etereration.sc.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
public class SCServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SCServiceApplication.class, args);
    }
 
    
    @Bean
    public AlwaysSampler defaultSampler() {
      return new AlwaysSampler();
    }
    @HystrixCommand
    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }
    @HystrixCommand
    @RequestMapping("/message")
    public String messsage() {
        return "Hello World";
    }
}