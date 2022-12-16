package io.github.meowkita.wikiapi.load;

import io.github.meowkita.wikiapi.page.Page;

public class MinifiedWikipediaLoadEngine extends WikipediaLoadEngine {

    /**
     * @param title a title of a page to be loaded
     * @return returns a {@link Page} with only the first block of the Wikipedia
     * page with general information
     */
    @Override
    protected String makeUrl(String title) {
        return super.makeUrl(title) + "&exintro";
    }

}
