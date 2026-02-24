package hu.aut.bme.springlab;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static hu.aut.bme.springlab.CountryData.Continent.*;

public class CountryMapperTest {
        @Test
        public void testWithRealCountryData() {
                var input = "Hungary, Europe, 12321, 12312321";
                var countryData = new CountryMapper().mapToCountryData(input);
                assertEquals("Hungary", countryData.country());
                assertEquals("Europe", countryData.region());
                assertEquals(12321, countryData.population());
                assertEquals(12312321, countryData.area());
                assertEquals(Optional.of(EUROPE), countryData.continent());
        }

        @Test
        public void testWithBogusCountryData() {
                var input = "Neverland, Nowhere, 50, 0";
                var countryData = new CountryMapper().mapToCountryData(input);
                assertEquals("Neverland", countryData.country());
                assertEquals("Nowhere", countryData.region());
                assertEquals(50, countryData.population());
                assertEquals(0, countryData.area());
                assertEquals(Optional.empty(), countryData.continent());
        }
}
