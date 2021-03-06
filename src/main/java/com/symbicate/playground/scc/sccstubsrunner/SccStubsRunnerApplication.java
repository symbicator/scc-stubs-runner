package com.symbicate.playground.scc.sccstubsrunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.contract.stubrunner.server.EnableStubRunnerServer;

@SpringBootApplication
@EnableStubRunnerServer
public class SccStubsRunnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SccStubsRunnerApplication.class);
    }
}
