package services;


import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import models.DictionaryOut;

import static config.SpecificationRepository.asd;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class ProductsService {

    private static final String DIC = "/Dictionaries/{id}";


    public static DictionaryOut getdic(int id) {
        return Raw.getProducts(id)
                .as(DictionaryOut.class);
    }

    public static class Raw {
        static ExtractableResponse getProducts(long id) {
            return requestSpecification.spec(asd)
                    .when()
                    .get(DIC, id)
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .extract();
        }
    }
}
