package hu.aut.bme.springlab;

import java.util.Optional;

public record CountryData(String country, String region, long population, long area, Optional<String> continent) {
}
