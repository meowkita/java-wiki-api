package io.github.meowkita.wikiapi.load;

import io.github.meowkita.wikiapi.http.WikiHttpClient;
import io.github.meowkita.wikiapi.page.Page;
import org.json.JSONObject;

public class WikipediaLoadEngine implements LoadEngine {

    private final WikiHttpClient client = new WikiHttpClient();

    /**
     * @param title a title of a page to be loaded
     * @return returns a {@link Page} with the full body of the Wikipedia page
     */
    @Override
    public Page load(String title) {
        String url = makeUrl(title);
        String response = client.request(url);
        return parse(response);
    }

    /**
     * @param response a json string with a page info
     * @return returns a parsed {@link Page}
     */
    private Page parse(String response) {
        JSONObject responseJson = new JSONObject(response);
        JSONObject pagesJson = responseJson
                .getJSONObject("query")
                .getJSONObject("pages");

        String pageId = pagesJson.keys().next();

        JSONObject pageJson = pagesJson.getJSONObject(pageId);

        String title = pageJson.getString("title");
        String body = pageJson.getString("extract");

        String formattedBody = body.replaceAll("\n\n\n", "\n\n ---");

        return new Page(title, formattedBody);
    }

    /**
     * @param title a title to be placed in url
     * @return returns a constructed url with a query
     */
    protected String makeUrl(String title) {
        String normalizedTitle = title.replaceAll(" ", "%20");

        return String.format("https://en.wikipedia.org/w/api.php?" +
                "format=json&" +
                "action=query&" +
                "prop=extracts&" +
                "explaintext&" +
                "exsectionformat=plain&" +
                "titles=%s", normalizedTitle);
    }

}
