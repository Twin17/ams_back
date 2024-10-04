package com.ams.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;

@UtilityClass
public class JsonUtils {
    private static final String DATE_TIME_FORMAT = "dd-MM-yyyy hh:mm:ss.SSS";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(JsonParser.Feature.ALLOW_COMMENTS, true)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, false)
            .configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true)
            .registerModule(new JavaTimeModule())
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    public static String toJsonString(Object obj) {
        try {
            return OBJECT_MAPPER
                    .setDateFormat(new SimpleDateFormat(DATE_TIME_FORMAT))
                    .writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            return "Object to JsonString convertation eroor";
        }
    }

    public static LazyToStringWrapper lazyToJsonString(Object obj) {
        return new LazyToStringWrapper(() -> toJsonString(obj));
    }
}
