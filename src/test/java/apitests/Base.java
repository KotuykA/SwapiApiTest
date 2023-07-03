package apitests;

import io.restassured.RestAssured;
import org.junit.Before;

import static configuration.Endpoints.SWAPI_URL;

public abstract class Base {

    @Before
    public void restAssuredSetup() {
        RestAssured.baseURI = SWAPI_URL;
    }

}
