package com.library.app.springbootlibrary.config;

import com.library.app.springbootlibrary.entity.Book;
import com.library.app.springbootlibrary.entity.Message;
import com.library.app.springbootlibrary.entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {
    private String allowedOrigin = "http://localhost:3000";

    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedActions = {HttpMethod.POST, HttpMethod.PATCH, HttpMethod.PUT, HttpMethod.DELETE};

        config.exposeIdsFor(Book.class, Review.class, Message.class);

        disableHttpMethods(Book.class, config, unsupportedActions);
        disableHttpMethods(Review.class, config, unsupportedActions);
        disableHttpMethods(Message.class, config, unsupportedActions);

        /* Configure CORS Mapping */
        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(allowedOrigin);
    }

    private void disableHttpMethods(Class bookClass, RepositoryRestConfiguration config, HttpMethod[] unsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(bookClass)
                .withItemExposure(((metadata, httpMethods) -> httpMethods.disable(unsupportedActions)))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedActions));
    }
}
