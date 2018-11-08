package services;

import helper.JSONParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Currencies;

import java.util.List;

import static config.SpecificationRepository.requestSpecification;

public class CurrenciesService {

    private static final String CURRENCIES = "/currencies";


    public static List<Currencies> getCurrencies() {
        return Raw.getCurrencies()
                .jsonPath().getList("Currencies", Currencies.class);
    }

    public static class Raw {
        public static Response getCurrencies() {
            return RestAssured.given(requestSpecification)
                    .when()
                    .get(CURRENCIES)
                    .andReturn();
        }
    }
}
