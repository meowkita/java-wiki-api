package io.github.meowkita.wikiapi.search;

import io.github.meowkita.wikiapi.http.WikiHttpClient;
import org.json.JSONArray;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WikipediaSearchEngine implements SearchEngine {

    private final WikiHttpClient client = new WikiHttpClient();

    /**
     * @param query a query of a page to be found
     * @return returns a {@link List} which contains the first 10 found
     * page titles to load
     */
    @Override
    public List<String> search(String query) {
        String url = makeUrl(query);
        String response = client.request(url);
        return parseTitles(response);
    }

    /**
     * @param response a json string with a search results
     * @return returns a parsed {@link List} of titles
     */
    private List<String> parseTitles(String response) {
        JSONArray responseJson = new JSONArray(response);
        JSONArray titlesJson = responseJson.getJSONArray(1);

        return IntStream
                .range(0, titlesJson.length())
                .mapToObj(titlesJson::getString)
                .collect(Collectors.toList());
    }

    /**
     * @param query a query for which a page needs to be found
     * @return returns a constructed url with a query
     */
    private String makeUrl(String query) {
        String normalizedQuery = query.replaceAll(" ", "%20");

        return String.format("https://en.wikipedia.org/w/api.php?" +
                "action=opensearch&" +
                "format=json&" +
                "search=%s", normalizedQuery);
    }

}
