package helper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class JSONParser {

    public static ObjectMapper mapper;
    private static ObjectMapper prettyMapper;
    private static DefaultPrettyPrinter prettyPrinter;

    static {
        mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        // dates will be serialized to ISO-8601 formatted string
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        // nulls or Nones will be skipped in serialized string
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // deserialization will fail if new property (not defined in class) occurs in json
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        // deserialization will not fail if model property is missing (you should have assertion for each filed)
        mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);

        prettyPrinter = new DefaultPrettyPrinter();
        DefaultIndenter indenter = new DefaultIndenter("  ", DefaultIndenter.SYS_LF);
        prettyPrinter.indentObjectsWith(indenter);
        prettyPrinter.indentArraysWith(indenter);

        prettyMapper = mapper.copy();
        prettyMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
    }

    public static String toJSON(Object any) {
        try {
            return mapper.writeValueAsString(any);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Cannot create JSON from object.", e);
        }
    }

    public static <T> T fromJSON(String json, Class<T> cls) {
        try {
            return mapper.readValue(json, cls);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot create object of class: " + cls.getName() + " from JSON", e);
        }
    }


    public static String toPrettyJSON(String any) throws IOException {
        // Include.ALWAYS is here in order to have nulls in response log
        Object anyValue = prettyMapper.readValue(any, Object.class);
        return prettyMapper.writer(prettyPrinter).writeValueAsString(anyValue);
    }

}
