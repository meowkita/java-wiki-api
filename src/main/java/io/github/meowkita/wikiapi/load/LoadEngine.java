package io.github.meowkita.wikiapi.load;

import io.github.meowkita.wikiapi.page.Page;

public interface LoadEngine {

    Page load(String title);

}
