package io.github.meowkita.wikiapi.api;

import io.github.meowkita.wikiapi.load.LoadEngine;
import io.github.meowkita.wikiapi.load.MinifiedWikipediaLoadEngine;
import io.github.meowkita.wikiapi.load.WikipediaLoadEngine;
import io.github.meowkita.wikiapi.page.Page;
import io.github.meowkita.wikiapi.search.SearchEngine;
import io.github.meowkita.wikiapi.search.WikipediaSearchEngine;

import java.util.List;

/**
 * API for interacting with wikipedia.
 * Provides methods to search and load pages.
 */
public class WikipediaApi implements Api {

    private final SearchEngine searchEngine = new WikipediaSearchEngine();
    private final LoadEngine loadEngine = new WikipediaLoadEngine();
    private final LoadEngine minifiedLoadEngine = new MinifiedWikipediaLoadEngine();

    /**
     * @param query a query for which a page needs to be found
     * @return returns a {@link List} which contains the first 10 found
     * page titles to load
     */
    @Override
    public List<String> search(String query) {
        return searchEngine.search(query);
    }

    /**
     * @param title the title of the page to be loaded
     * @return returns a {@link Page} with only the first block of the Wikipedia
     * page with general information
     */
    @Override
    public Page loadMinifiedPage(String title) {
        return minifiedLoadEngine.load(title);
    }

    /**
     * @param title the title of the page to be loaded
     * @return returns a {@link Page} with the full body of the Wikipedia page
     */
    @Override
    public Page loadExtendedPage(String title) {
        return loadEngine.load(title);
    }

}
