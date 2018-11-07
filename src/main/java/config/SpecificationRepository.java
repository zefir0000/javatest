package config;
import helper.JSONParser;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import io.restassured.mapper.ObjectMapper;
import io.restassured.specification.RequestSpecification;

import org.apache.http.params.CoreConnectionPNames;

import static org.apache.http.params.CoreConnectionPNames.*;


public class SpecificationRepository {

    private static Filter requestLoggingFilter = new RequestLoggingFilter();
    private static Filter responseLoggingFilter = new ResponseLoggingFilter();
    private static RestAssuredConfig config = RestAssuredConfig
            .newConfig()
            .httpClient(HttpClientConfig.httpClientConfig()
                    .dontReuseHttpClientInstance()

            ).objectMapperConfig(ObjectMapperConfig.objectMapperConfig().jackson2ObjectMapperFactory((aClass, s) -> JSONParser.mapper));

    public static final RequestSpecification asd = specification()
            .setBaseUri(Asd.Api.apiUrl)
            .addHeader("x-user-identity",
                    Asd.Api.xUserIdentityType + ", " + Asd.Api.xUserIdentityName)
            .build();

    private static RequestSpecBuilder specification() {
        return new RequestSpecBuilder()
                .setContentType("application/json; charset=utf-8")
                .setAccept("application/json")
                .addFilter(requestLoggingFilter)
                .addFilter(responseLoggingFilter)
                .setConfig(config);
    }


}