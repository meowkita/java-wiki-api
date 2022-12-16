package io.github.meowkita.wikiapi.load;

import io.github.meowkita.wikiapi.page.Page;

public interface LoadEngine {

    /**
     * @param title a title of a page to be loaded
     * @return returns a loaded {@link Page} with a specified title
     */
    Page load(String title);

}
