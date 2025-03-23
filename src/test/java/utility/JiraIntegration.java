package utility;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class JiraIntegration {

    private static final String JIRA_URL = ConfigReader.getProperty("jiraUrl");
    private static final String JIRA_EMAIL = ConfigReader.getProperty("jiraEmail");
    private static final String JIRA_API_TOKEN = ConfigReader.getProperty("jiraApiToken");
    private static final String PROJECT_KEY = ConfigReader.getProperty("jiraKey");
    private static final String JIRA_CREATE_ISSUE_ENDPOINT = "/rest/api/3/issue";

    public static void createJiraIssue(String scenarioName, String description) {
        String auth = JIRA_EMAIL + ":" + JIRA_API_TOKEN;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = createHttpPost(encodedAuth, scenarioName, description);
            CloseableHttpResponse response = client.execute(post);

            if (response.getStatusLine().getStatusCode() == 201) {
                System.out.println("Scenario added to Jira: " + scenarioName);

            } else {
                String errorMessage = EntityUtils.toString(response.getEntity());
                System.out.println("Error Code: " + response.getStatusLine().getStatusCode());
                System.out.println("Error Message: " + errorMessage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static HttpPost createHttpPost(String encodedAuth, String scenarioName, String description) {
        HttpPost post = new HttpPost(JIRA_URL + JIRA_CREATE_ISSUE_ENDPOINT);
        post.setHeader("Authorization", "Basic " + encodedAuth);
        post.setHeader("Content-Type", "application/json");

        String adfDescription = "{ \"version\": 1, \"type\": \"doc\", \"content\": [ { \"type\": \"paragraph\", " +
                "\"content\": [ { \"type\": \"text\", \"text\": \"" + description + "\" } ] } ] }";

        String json = "{ \"fields\": { " +
                "\"project\": { \"key\": \"" + PROJECT_KEY + "\" }, " +
                "\"summary\": \"" + scenarioName + "\", " +
                "\"description\": " + adfDescription + ", " +
                "\"issuetype\": { \"name\": \"Task\" } } }";
        post.setEntity(new StringEntity(json, StandardCharsets.UTF_8));
        return post;
    }
}