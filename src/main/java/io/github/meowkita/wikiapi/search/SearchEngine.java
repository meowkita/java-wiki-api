package io.github.meowkita.wikiapi.search;

import java.util.List;

public interface SearchEngine {

    /**
     * @param query a query of a page to be found
     * @return returns a {@link List} which contains the first 10 found
     * page titles to load
     */
    List<String> search(String query);

}
