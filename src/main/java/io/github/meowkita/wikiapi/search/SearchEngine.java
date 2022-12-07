package io.github.meowkita.wikiapi.search;

import java.util.List;

public interface SearchEngine {

    List<String> search(String query);

}
