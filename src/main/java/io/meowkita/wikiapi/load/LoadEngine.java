package io.meowkita.wikiapi.load;

import io.meowkita.wikiapi.page.Page;

public interface LoadEngine {

    Page load(String title);

}
