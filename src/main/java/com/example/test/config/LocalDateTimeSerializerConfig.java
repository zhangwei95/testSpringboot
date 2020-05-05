package com.example.test.config;

import com.example.test.util.DateUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.LocalDateTime;

@Configuration
public class LocalDateTimeSerializerConfig {
    @org.springframework.beans.factory.annotation.Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
    private String pattern;


    public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
        public LocalDateTimeDeserializer() {
        }
        @Override
        public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return DateUtils.timestamp2LocalDateTime(p.getValueAsLong());
        }
    }

}
