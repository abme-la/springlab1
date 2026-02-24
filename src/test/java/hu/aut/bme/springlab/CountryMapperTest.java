package hu.aut.bme.springlab;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 public class CountryMapperTest {
        @Test
        public void testMapCountryData() {
            var input = "Hungary, Europe, 12321, 12312321";
            var countryData = new CountryMapper().mapToCountryData(input);
            assertEquals("Hungary", countryData.country());
            assertEquals("Europe", countryData.region());
            assertEquals(12321, countryData.population());
            assertEquals(12312321, countryData.area());
        }
    }