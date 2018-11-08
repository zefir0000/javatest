import models.Currencies;
import org.junit.jupiter.api.Test;
import services.CurrenciesService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {

    private static final int NUMBER_OF_CURRENCIES = 8;

    @Test
    void test_getCurrencies_shouldSucceed() {

        List<Currencies> currencies = CurrenciesService.getCurrencies();
        int size = currencies.size();
        assertEquals(NUMBER_OF_CURRENCIES, size);
    }

}
