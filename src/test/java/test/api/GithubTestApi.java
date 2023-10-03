package test.api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GithubTestApi {
	
  @Test
  public void shouldReturnTheListOfRepositoriesInGitHubOrganization() {
	  
      //Eder-Sant-ana
	  //bearer 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
	  
      given().headers("Accept", "application/vnd.github+json", 
    		  "Authorization", "Bearer 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",
    		  "X-GitHub-Api-Version", "2022-11-28")
      
      .when().get("https://api.github.com/orgs/Eder-Sant-ana/repos")
      .then()
      .log().all()
      .statusCode(200);
      
  }
}
