package com.sohan.reactive.application.config;

import com.sohan.reactive.application.service.RouterHandlers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class ReactiveConfig {

    @Bean
    public RouterFunction<?> routerFunction(RouterHandlers routerHandlers) {
        return RouterFunctions
                .route(RequestPredicates.GET("/resource/router/employee/"), routerHandlers::getAll)
                .andRoute(RequestPredicates.GET("/resource/router/employee/{id}"), routerHandlers::getId)
                .andRoute(RequestPredicates.GET("/resource/router/employee/{id}/events"), routerHandlers::getEvents);
    }
}
