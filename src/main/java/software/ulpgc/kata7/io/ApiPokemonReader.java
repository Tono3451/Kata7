package software.ulpgc.kata7.io;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

import static org.jsoup.Connection.Method.GET;

public class ApiPokemonReader implements PokemonReader{
    @Override
    public String read(String pokemon) {
        try {
            return apiCall("https://pokeapi.co/api/v2/pokemon/" + pokemon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String apiCall(String url) throws IOException {
        Connection.Response response = Jsoup.connect(url)
                .ignoreContentType(true)
                .header("accept", "text/*")
                .method(GET)
                .execute();
        return response.body();
    }
}
