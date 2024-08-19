package StepsDefinitions;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.Map;
import io.restassured.http.ContentType;
public class apiClient {
	 private static final String BASE_URL = "http://127.0.0.1:5000";

	    public Response postPredictTestResult(Map<String, Object> requestBody) {
	        return RestAssured.given()
	                          .contentType(ContentType.JSON)
	                          .body(requestBody)
	                          .post(BASE_URL + "/predictTestResult");
	    }

}
