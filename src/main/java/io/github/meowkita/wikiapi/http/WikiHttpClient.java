package io.github.meowkita.wikiapi.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Wrapper over {@link OkHttpClient} for executing queries and simply constructing them
 */
public class WikiHttpClient {

    private final OkHttpClient client = new OkHttpClient();

    /**
     * @param url the url to use to make the request
     * @return returns a stringified response body
     */
    public String request(String url) {
        Request request = buildRequest(url);

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Used for simple {@link Request} creation
     *
     * @param url the url to use to make the request
     * @return returns a {@link Request}
     */
    private Request buildRequest(String url) {
        return new Request.Builder().url(url).build();
    }

}
