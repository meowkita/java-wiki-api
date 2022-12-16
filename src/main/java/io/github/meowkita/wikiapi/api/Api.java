package io.github.meowkita.wikiapi.api;

import io.github.meowkita.wikiapi.page.Page;

import java.util.List;

/**
 * API for interacting with wiki-* systems.
 * Provides methods to search and load pages.
 */
public interface Api {

    /**
     * @param query a query for which a page needs to be found
     * @return returns {@link List} which contains the first 10 found
     * page titles to load
     */
    List<String> search(String query);

    /**
     * @param title the title of the page to be loaded
     * @return returns a {@link Page} with only the first block of the Wikipedia
     * page with general information
     */
    Page loadMinifiedPage(String title);

    /**
     * @param title the title of the page to be loaded
     * @return returns a {@link Page} with the full body of the Wikipedia page
     */
    Page loadExtendedPage(String title);

}
