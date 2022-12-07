package io.meowkita.wikiapi.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WikiHttpClient {

    private final OkHttpClient client = new OkHttpClient();

    public String request(String url) {
        Request request = buildRequest(url);

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Request buildRequest(String url) {
        return new Request.Builder().url(url).build();
    }

}
