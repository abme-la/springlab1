package hu.aut.bme.springlab;

import java.util.Optional;

import hu.aut.bme.springlab.CountryData.Continent;
import static hu.aut.bme.springlab.CountryData.Continent.*;

public class CountryMapper {
        public CountryData mapToCountryData(String line) {
                var columns = line.split(",");
                return new CountryData(columns[0].trim(), columns[1].trim(), Long.parseLong(columns[2].trim()),
                                Long.parseLong(columns[3].trim()), findContinent(columns[1]));
        }

        private Optional<Continent> findContinent(String region) {
                return switch (region) {
                        case String s when s.toLowerCase().contains("europe") -> Optional.of(EUROPE);
                        case String s when s.toLowerCase().contains("africa") -> Optional.of(AFRICA);
                        case String s when s.toLowerCase().contains("near east") -> Optional.of(ASIA);
                        case String s when s.toLowerCase().contains("oceania") -> Optional.of(OCEANIA);
                        case String s when s.toLowerCase().contains("amer") -> Optional.of(AMERICA);
                        case String s when s.toLowerCase().contains("baltics") -> Optional.of(EUROPE);
                        case String s when s.toLowerCase().contains("c.w.") -> Optional.of(ASIA);
                        default -> Optional.empty();
                };
        }
}
