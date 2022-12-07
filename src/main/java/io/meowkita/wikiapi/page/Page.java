package io.meowkita.wikiapi.page;

public class Page {

    private final String title;
    private final String body;

    public Page(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

}
