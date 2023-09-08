package i18n;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.stream.Stream;

public class LocalizationServiceImplTest {
    LocalizationServiceImpl loc;

    @BeforeEach
    public void beforeEach() {
        loc = new LocalizationServiceImpl();
    }

    @AfterEach
    public void afterEach() {
        loc = null;
    }

    public static Stream<Arguments> localeTest() {
        return Stream.of(Arguments.of("Добро пожаловать", Country.RUSSIA),
                Arguments.of("Welcome", Country.BRAZIL));
    }

    @ParameterizedTest
    @MethodSource
    public void localeTest(String expected, Country country) {
        String result = loc.locale(country);
        Assertions.assertEquals(expected, result);
    }
}
