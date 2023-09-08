package geo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import java.util.stream.Stream;

public class GeoServiceImplTest {

    GeoService geoService;

    @BeforeEach
    public void beforeEach() {
        geoService = new GeoServiceImpl();
    }

    @AfterEach
    public void afterEach() {
        geoService = null;
    }


    public static Stream<Arguments> byIpTest() {
        return Stream.of
                (Arguments.of("172.0.32.11", new Location("Moscow", Country.RUSSIA, "Lenina", 15)),
                        Arguments.of("127.0.0.1", new Location(null, null, null, 0)),
                        Arguments.of("172.", new Location("Moscow", Country.RUSSIA, null, 0)),
                        Arguments.of("96.", new Location("New York", Country.USA, null, 0)),
                        Arguments.of("96.44.183.149", new Location("New York", Country.USA, " 10th Avenue", 32)));
    }

    @ParameterizedTest
    @MethodSource
    public void byIpTest(String ip, Location expected) {
        Location result = geoService.byIp(ip);
        Assertions.assertEquals(expected.getCountry(), result.getCountry());
    }
}
