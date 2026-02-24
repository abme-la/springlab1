package hu.aut.bme.springlab;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final String DATA_URL =
            "https://raw.githubusercontent.com/bnokoro/Data-Science/refs/heads/master/countries%20of%20the%20world.csv";

    static void main() throws Exception{
        String csvdata;
        try ( var client  = HttpClient.newHttpClient()){
            var request  = HttpRequest.newBuilder(new URI(DATA_URL)).build();
            csvdata = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            var mapper = new CountryMapper();
            csvdata.lines().skip(1).filter(line -> line.startsWith("\"")).map(mapper::mapToCountryData)
                    .toList();
            //System.out.println(csvdata);
        }
    }
}
