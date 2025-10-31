package edu.colorado.cires.cruisepack.metadata.nuvo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public final class CruisePackMetadataObjectMapperFactory {

  private CruisePackMetadataObjectMapperFactory() {

  }

  public static ObjectMapper createObjectMapper() {
    return JsonMapper.builder()
        .disable(MapperFeature.DEFAULT_VIEW_INCLUSION)
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .addModule(new Jdk8Module())
        .addModule(new JavaTimeModule())
        .defaultPropertyInclusion(JsonInclude.Value.construct(JsonInclude.Include.NON_NULL, JsonInclude.Include.NON_NULL))
        .defaultPropertyInclusion(JsonInclude.Value.construct(Include.NON_EMPTY, JsonInclude.Include.NON_EMPTY))
        .propertyNamingStrategy(PropertyNamingStrategies.SnakeCaseStrategy.INSTANCE)
        .build();
  }

}
