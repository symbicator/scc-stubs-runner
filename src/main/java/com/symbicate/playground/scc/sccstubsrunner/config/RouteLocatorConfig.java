package com.symbicate.playground.scc.sccstubsrunner.config;

import java.util.Arrays;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {

    @Bean
    public RouteLocator stubRunnerRouteLocator(RouteLocatorBuilder builder, StubRunnerProperties stubRunnerProperties) {
        final Builder routes = builder.routes();
        Arrays.stream(stubRunnerProperties.getIds())
                .map(id -> id.substring(id.lastIndexOf(':') + 1))
                .forEach(stubRunnerPort -> routes.route(r -> r
                        .path('/' + stubRunnerPort + "/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:" + stubRunnerPort)
                        .id("stubRunner" + stubRunnerPort)
                ));
        return routes.build();
    }
}
