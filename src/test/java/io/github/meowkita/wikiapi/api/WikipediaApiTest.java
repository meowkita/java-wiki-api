package io.github.meowkita.wikiapi.api;

import io.github.meowkita.wikiapi.page.Page;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class WikipediaApiTest {

    private final WikipediaApi wikipediaApi = new WikipediaApi();

    @Test
    void shouldReturnEarthTitleAtFirstPosition_onQuery_Earth() {
        List<String> titles = wikipediaApi.search("Earth");
        String firstTitle = titles.get(0);

        assertEquals("Earth", firstTitle);
    }

    @Test
    void shouldNotReturnEarthTitleAtFirstPosition_onQuery_Earth() {
        List<String> titles = wikipediaApi.search("Earth 1");
        String firstTitle = titles.get(0);

        assertNotEquals("Earth", firstTitle);
    }

    @Test
    void shouldReturnEmptyList_onStrangeQuery() {
        List<String> titles = wikipediaApi.search("BJBybdbgay6789_da");

        assertEquals(0, titles.size());
    }

    @Test
    void shouldReturnExtendedPage() {
        Page page = wikipediaApi.loadExtendedPage("Earth");

        boolean hasLinksSection = page.getBody().toLowerCase(Locale.ROOT).contains("links");

        assertTrue(hasLinksSection);
    }

    @Test
    void shouldReturnMinifiedPage() {
        Page page = wikipediaApi.loadMinifiedPage("Earth");

        boolean hasLinksSection = page.getBody().toLowerCase(Locale.ROOT).contains("links");

        assertFalse(hasLinksSection);
    }

}