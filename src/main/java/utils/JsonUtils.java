package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {
    public static Map<String, Object> getJsonDataAsMap(String fileNamePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String completeJsonFilePath = System.getProperty("user.dir") + "/src/test/resources/" + fileNamePath;
        Map<String,Object> jsonAsMap=objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<Map<String, Object>>() {});
        return jsonAsMap;
    }
}
