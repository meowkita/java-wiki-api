package io.github.meowkita.wikiapi.http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WikiHttpClientTest {

    private final WikiHttpClient client = new WikiHttpClient();

    @Test
    void shouldThrowAnException_on_IncorrectUrl() {
        assertThrows(IllegalArgumentException.class, () -> client.request("htp://dsdasd.com"));
    }

    @Test
    void shouldThrowAnException_on_Timeout() {
        assertThrows(RuntimeException.class, () -> client.request("https://somefakeurl.xyza"));
    }

}