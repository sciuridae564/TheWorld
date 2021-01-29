package cn.sciuridae.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDateTime;

public final class JsonUtils {

    private JsonUtils() {
    }

    /**
     * 将对象转换成JSON字符串
     *
     * @param obj 对象
     * @return json字符串
     */
    public static String objectToJsonString(Object obj) throws JsonParseException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JavaTimeModule timeModule = new JavaTimeModule();
            timeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
            mapper.registerModule(timeModule);
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {

        }
        return null;
    }


}

