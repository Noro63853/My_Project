package helper;

import com.google.gson.JsonParseException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataFileReader {
    private final ObjectMapper objectMapper = new ObjectMapper();
    public JsonNode getPOJOFile(String path){
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readValue(new File(path),JsonNode.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }

//    public List getListFromFile(String path){
//        List list = null;
//        try {
//            list = objectMapper.readValue(new File(path), new TypeReference<List<JsonNode>>(){});
//        } catch (JsonParseException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
}
