package io.meowkita.wikiapi.load;

public class MinifiedWikipediaLoadEngine extends WikipediaLoadEngine {

    @Override
    protected String makeUrl(String title) {
        return super.makeUrl(title) + "&exintro";
    }

}
