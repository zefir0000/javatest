import io.restassured.response.ValidatableResponse;
import models.DictionaryOut;
import org.junit.jupiter.api.Test;
import services.ProductsService;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class test {

    @Test
    public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {

        DictionaryOut getdic = ProductsService.getdic(2);


    }

}
