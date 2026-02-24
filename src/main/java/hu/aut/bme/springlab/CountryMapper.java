package hu.aut.bme.springlab;

import java.util.Optional;

public class CountryMapper {
    public CountryData mapToCountryData(String line) {
        var columns = line.split(",");
        return new CountryData(columns[0].trim(), columns[1].trim(), Long.parseLong(columns[2].trim()), Long.parseLong(columns[3].trim()), findContinent(columns[1]));
    }

    private Optional<String> findContinent(String region) {
        return switch (region) {
            case String s when s.toLowerCase().contains("europe")-> Optional.of("Europe");
            case String s when s.toLowerCase().contains("africa")-> Optional.of("Africa");
            case String s when s.toLowerCase().contains("near east")-> Optional.of("Asia");
            case String s when s.toLowerCase().contains("oceania")-> Optional.of("Oceania");
            case String s when s.toLowerCase().contains("amer")-> Optional.of("America");
            case String s when s.toLowerCase().contains("baltics")-> Optional.of("Europe");
            case String s when s.toLowerCase().contains("c.w.")-> Optional.of("Asia");
            default -> Optional.empty();
        };
    }
}
