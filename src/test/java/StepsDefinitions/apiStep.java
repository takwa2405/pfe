package StepsDefinitions;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
public class apiStep {
	
	 apiClient apiclient = new apiClient();
	  
	    Response response;

	    @When("j'envoie les données à l'API predictTestResult")
	    public void sendPredictTestResult() {
	        Map<String, Object> requestBody = new HashMap<>();
	        requestBody.put("Username", "191MTB1025");
	        requestBody.put("Password", " arbrevert1234");
	        requestBody.put("Is Identifier Valid", "True");
	        requestBody.put("Is Password Correct", "True");
	        requestBody.put("Is Account Disabled", "False");
	        requestBody.put("Is Identifier Empty", "False");
	        requestBody.put("Is Password Empty", "False");
	        requestBody.put("Expected Result", "Pass");
	        requestBody.put("Rejection Reason", "none");

	        response = apiclient.postPredictTestResult(requestBody);
	        System.out.print(response);
	    }

	    @And("la réponse de l'API doit avoir le statut {int}")
	    public void verifyApiResponse(int expectedStatusCode) {
	        assertEquals(expectedStatusCode, response.getStatusCode());
	        System.out.print(response.getBody());
	    }

	  
	    @Then("je imprime la réponse de l'API")
	    public void printApiResponse() {
	        String responseBody = response.getBody().asString();
	        System.out.println("Réponse de l'API: " + responseBody);
	    }
}
