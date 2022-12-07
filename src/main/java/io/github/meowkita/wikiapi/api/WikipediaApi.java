package io.github.meowkita.wikiapi.api;

import io.github.meowkita.wikiapi.load.LoadEngine;
import io.github.meowkita.wikiapi.load.MinifiedWikipediaLoadEngine;
import io.github.meowkita.wikiapi.load.WikipediaLoadEngine;
import io.github.meowkita.wikiapi.page.Page;
import io.github.meowkita.wikiapi.search.SearchEngine;
import io.github.meowkita.wikiapi.search.WikipediaSearchEngine;

import java.util.List;

public class WikipediaApi implements Api {

    private final SearchEngine searchEngine = new WikipediaSearchEngine();
    private final LoadEngine loadEngine = new WikipediaLoadEngine();
    private final LoadEngine minifiedLoadEngine = new MinifiedWikipediaLoadEngine();

    @Override
    public List<String> search(String query) {
        return searchEngine.search(query);
    }

    @Override
    public Page loadMinifiedPage(String title) {
        return minifiedLoadEngine.load(title);
    }

    @Override
    public Page loadExtendedPage(String title) {
        return loadEngine.load(title);
    }

}
