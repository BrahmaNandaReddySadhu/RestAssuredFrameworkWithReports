package Airlines;

import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPI {

    public Response createAirline(Map<String,Object> createAirlinePayload){
        String endPoint= Base.dataFromJsonFile.get("createAirLineEndpoint").toString();
        Map<String,Object>  payload=Payloads.getCreateAirlinePayloadAsMap("sadhu","Brahma",111,true,"2025-01-01","2025-08-09","Breakfast");
        Response response = RestUtils.performPost(endPoint,payload,new HashMap<>());
        return response;
    }
}
