package io.meowkita.wikiapi.search;

import io.meowkita.wikiapi.http.WikiHttpClient;
import org.json.JSONArray;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WikipediaSearchEngine implements SearchEngine {

    private final WikiHttpClient client = new WikiHttpClient();

    @Override
    public List<String> search(String query) {
        String url = makeUrl(query);
        String response = client.request(url);
        return parseTitles(response);
    }

    private List<String> parseTitles(String response) {
        JSONArray responseJson = new JSONArray(response);
        JSONArray titlesJson = responseJson.getJSONArray(1);

        return IntStream
                .range(0, titlesJson.length())
                .mapToObj(titlesJson::getString)
                .collect(Collectors.toList());
    }

    private String makeUrl(String query) {
        String normalizedQuery = query.replaceAll(" ", "%20");

        return String.format("https://en.wikipedia.org/w/api.php?" +
                "action=opensearch&" +
                "format=json&" +
                "search=%s", normalizedQuery);
    }

}
