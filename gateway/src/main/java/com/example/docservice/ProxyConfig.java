package com.example.docservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
class ProxyConfig {
    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("document-service_route",
                        route -> route.path("/document-service/**")
                                .and()
                                .method(HttpMethod.GET)
                                .filters(filter -> filter.stripPrefix(1)
                                )
                                .uri("lb://document-service"))
                .route("document-service_route",
                        route -> route.path("/document-service/**")
                                .and()
                                .method(HttpMethod.POST)
                                .filters(filter -> filter.stripPrefix(1)
                                )
                                .uri("lb://document-service"))
                .route("kafka-module_route",
                        route -> route.path("/kafka-module/**")
                                .and()
                                .method(HttpMethod.POST)
                                .filters(filter -> filter.stripPrefix(1)
                                )
                                .uri("lb://kafka-module"))
                .route("kafka-module_route",
                        route -> route.path("/kafka-module/**")
                                .and()
                                .method(HttpMethod.GET)
                                .filters(filter -> filter.stripPrefix(1)
                                )
                                .uri("lb://kafka-module"))
                .build();
    }
}