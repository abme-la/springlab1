package hu.aut.bme.springlab;

public class CountryMapper {
    public CountryData mapToCountryData(String line) {
        var columns = line.split(",");
        return new CountryData(columns[0].trim(), columns[0].trim(), Long.parseLong(columns[2].trim()), Long.parseLong(columns[3].trim()));
    }
}
