import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WeatherApi {

    @Test
    public void testWeatherApi() {
        // Set the base URL of the API
        RestAssured.baseURI = "https://www.visualcrossing.com/";

        // Send a GET request to the weather endpoint
        Response response = given()
            .queryParam("city", "Chennai")
            .queryParam("apiKey", "S4YGC8JP7KQUCC54J4ZZ4KZQC")
        .when()
            .get("/weather");

        // Verify the response status code
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200, "Unexpected status code");

        // Verify the weather data or perform other assertions on the response
        String weather = response.jsonPath().getString("weather.main");
        assertEquals(weather, "Cloudy", "Unexpected weather condition");
    }
}