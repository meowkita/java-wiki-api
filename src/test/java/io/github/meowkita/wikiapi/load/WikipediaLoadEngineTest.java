package io.github.meowkita.wikiapi.load;

import io.github.meowkita.wikiapi.page.Page;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WikipediaLoadEngineTest {

    private final WikipediaLoadEngine loadEngine = new WikipediaLoadEngine();

    @Test
    void shouldReturnCorrectPage() {
        Page page = loadEngine.load("Earth");
        assertEquals("Earth", page.getTitle());
    }

}