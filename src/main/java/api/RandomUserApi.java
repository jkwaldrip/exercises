package api;

import api.data.PrimaryAddress;
import api.data.User;
import api.json.Result;
import com.google.gson.Gson;
import api.json.RandomUserJson;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RandomUserApi {

    private static final String url = "https://randomuser.me/api/";

    public static User getRandomUser() throws IOException {
        // Create HTTP client
        CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .build();

        // Get random user
        HttpGet getUser = new HttpGet(url);
        HttpResponse response = httpClient.execute(getUser);

        Gson gson = new Gson();

        RandomUserJson randomUserJson = gson.fromJson(
                getContent(response),
                RandomUserJson.class
        );

        Result result = randomUserJson.getResults().get(0);

        PrimaryAddress address = new PrimaryAddress()
                .withStreet(result.getLocation().getStreet())
                .withCity(result.getLocation().getCity())
                .withState(result.getLocation().getState())
                .withZipCode(result.getLocation().getPostcode())
                .withTimeZone(result.getLocation().getTimezone());

        return new User()
                .withFirstName(result.getName().getFirst())
                .withLastName(result.getName().getLast())
                .withPrimaryAddress(address)
                .withEmail(result.getEmail())
                .withGender(result.getGender())
                .withBirthDate(result.getDob().getDate());
    }

    // Return the content of an HTTP Response
    public static String getContent(HttpResponse response) throws IOException {
        return IOUtils.toString(
                response.getEntity().getContent(),
                StandardCharsets.UTF_8
        );
    }
}
