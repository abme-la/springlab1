package hu.aut.bme.springlab;

import java.util.Optional;

public record CountryData(String country, String region, long population, long area, Optional<Continent> continent) {
        public static enum Continent {
                EUROPE, AFRICA, ASIA, OCEANIA, AMERICA, AUSTRALIA, ANTARCTICA
        }
}
