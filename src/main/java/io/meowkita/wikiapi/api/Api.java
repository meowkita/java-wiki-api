package io.meowkita.wikiapi.api;

import io.meowkita.wikiapi.page.Page;

import java.util.List;

public interface Api {

    List<String> search(String query);

    Page loadMinifiedPage(String title);

    Page loadExtendedPage(String title);

}
