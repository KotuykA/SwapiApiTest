package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssuredService {
    public static <T> T sendGetRequest(String pathParams, Class<T> responseClassToMap) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log()
                .everything()
                .get(pathParams)
                .then()
                .log()
                .everything()
                .extract()
                .as(responseClassToMap);
    }

    public static <T> T sendGetRequestWithSearch(String pathParams, String queryValue, Class<T> responseClassToMap) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log()
                .everything()
                .queryParam("search", queryValue)
                .get(pathParams)
                .then()
                .log()
                .everything()
                .extract()
                .as(responseClassToMap);
    }
}
