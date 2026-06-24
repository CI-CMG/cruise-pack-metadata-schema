package edu.colorado.cires.cruisepack.metadata.nuvo;


import com.fasterxml.jackson.annotation.JsonInclude;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.MapperFeature;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.cfg.DateTimeFeature;
import tools.jackson.databind.json.JsonMapper;

public final class CruisePackMetadataObjectMapperFactory {

  private CruisePackMetadataObjectMapperFactory() {

  }

  public static JsonMapper createObjectMapper() {
    return JsonMapper.builder()
        .disable(MapperFeature.DEFAULT_VIEW_INCLUSION)
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        .disable(DateTimeFeature.WRITE_DATES_AS_TIMESTAMPS)
        .changeDefaultPropertyInclusion(incl -> incl
            .withValueInclusion(JsonInclude.Include.NON_EMPTY)
            .withContentInclusion(JsonInclude.Include.NON_EMPTY)
        )
        .propertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
        .build();
  }

}
