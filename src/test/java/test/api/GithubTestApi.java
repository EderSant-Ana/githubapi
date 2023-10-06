package test.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import org.testng.annotations.Test;
import io.github.cdimascio.dotenv.Dotenv;


public class GithubTestApi {

	public static final String URL = "https://api.github.com/orgs/";
	public static final Dotenv dotenv = Dotenv.load();
	public static final String TOKEN = dotenv.get("BEARERTOKEN");
	public static final String ORGANIZATION = dotenv.get("ORGANIZATION");

	@Test
	public void shouldReturnTheListOfRepositoriesInGitHubOrganization() {

		given().headers("Accept", "application/vnd.github+json", "Authorization",
				String.format("Bearer %s", TOKEN), 
				"X-GitHub-Api-Version", "2022-11-28")
		.when()
				.get(URL + ORGANIZATION + "/repos")
		.then()
			.log().all()
			.statusCode(200)
			.body("size()", greaterThan(0));

	}
}
