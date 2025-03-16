package restUtils;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reportings.ExtentReportManager;

public class RestUtils {

    private static RequestSpecification getRequestSpecifications(String endPoint, Object requestPayload, Map<String, String> headers) {
        return RestAssured.given()
                .baseUri(endPoint)
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(requestPayload);
    }

    private static void printRequestLogInReports(RequestSpecification requestSpecification){
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("End Point is "+ queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is " +queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are "+ queryableRequestSpecification.getHeaders());
        ExtentReportManager.logInfoDetails("Request Body is "+ queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReport(Response response){
        ExtentReportManager.logInfoDetails("Response status code is "+ response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response body is "+ response.getBody());
        ExtentReportManager.logInfoDetails("Response header are "+ response.getHeaders());
    }

    public static Response performPost(String endPoint, Map<String,Object> requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecifications(endPoint, requestPayload, headers);
        Response response= requestSpecification.post();
        printRequestLogInReports(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response performPost(String endPoint, String requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecifications(endPoint, requestPayload, headers);
        Response response = requestSpecification.post();
        printRequestLogInReports(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

}
