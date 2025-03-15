package restUtils;

import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestUtils {

    public static  Response performPost(String endPoint, Object requestPayload , Map<String,String> headers){
        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(requestPayload)
                .when()
                .post()
                .then().log().all()
                .extract().response();
    }

}
