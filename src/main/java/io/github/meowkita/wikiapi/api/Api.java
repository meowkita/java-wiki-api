package io.github.meowkita.wikiapi.api;

import io.github.meowkita.wikiapi.page.Page;

import java.util.List;

public interface Api {

    List<String> search(String query);

    Page loadMinifiedPage(String title);

    Page loadExtendedPage(String title);

}
