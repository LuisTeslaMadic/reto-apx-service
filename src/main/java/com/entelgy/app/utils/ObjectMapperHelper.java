package com.entelgy.app.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperHelper {

    private ObjectMapper objectMapper = new ObjectMapper();

    public String convertFromJsonToString(String json , String namePath) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(json);
        return jsonNode.path(namePath).toString();
    }

}
