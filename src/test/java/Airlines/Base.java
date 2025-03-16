package Airlines;

import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class Base {

    public static Map<String, Object> dataFromJsonFile;


    static {

        String env =System.getProperty("env")== null ? "dev": System.getProperty("env");
        try {
            dataFromJsonFile = JsonUtils.getJsonDataAsMap("airlines/"+env+"/airlinesApiData.json");
        } catch (IOException e) {
            System.out.println("File is not available");
        }

    }

}
