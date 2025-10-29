package edu.colorado.cires.cruisepack.metadata.nuvo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonDeserialize(builder = PackageInstrument.Builder.class)
public class PackageInstrument {

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(PackageInstrument src) {
    return new Builder(src);
  }

  private final Instrument instrument;
  private final String typeName;
  private final List<String> extensions;
  private final Map<String, Object> otherFields;


  private PackageInstrument(
      Instrument instrument,
      String typeName,
      List<String> extensions,
      Map<String, Object> otherFields
  ) {
    this.instrument = instrument;
    this.typeName = typeName;
    this.extensions = extensions;
    this.otherFields = Collections.unmodifiableMap(otherFields);
  }

  @JsonUnwrapped
  public Instrument getInstrument() {
    return instrument;
  }

  public String getTypeName() {
    return typeName;
  }

  public List<String> getExtensions() {
    return extensions;
  }

  @Deprecated
  @JsonAnyGetter
  public Map<String, Object> getOtherFields() {
    return otherFields;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PackageInstrument that = (PackageInstrument) o;
    return Objects.equals(instrument, that.instrument) && Objects.equals(typeName, that.typeName) && Objects.equals(
        extensions, that.extensions) && Objects.equals(otherFields, that.otherFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instrument, typeName, extensions, otherFields);
  }

  @Override
  public String toString() {
    return "PackageInstrument{" +
        "instrument=" + instrument +
        ", typeName='" + typeName + '\'' +
        ", extensions=" + extensions +
        ", otherFields=" + otherFields +
        '}';
  }

  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Builder {

    private Instrument instrument;
    private String typeName;
    private List<String> extensions;
    private Map<String, Object> otherFields = new TreeMap<>();

    private Builder() {

    }

    private Builder(PackageInstrument src) {
      instrument = src.instrument;
      typeName = src.typeName;
      extensions = src.extensions;
      otherFields = new TreeMap<>(src.otherFields);
    }

    @JsonUnwrapped
    public Builder withInstrument(Instrument instrument) {
      this.instrument = instrument;
      return this;
    }

    public Builder withTypeName(String typeName) {
      this.typeName = typeName;
      return this;
    }

    public Builder withExtensions(List<String> extensions) {
      if (extensions == null) {
        this.extensions = null;
      } else {
        this.extensions = Collections.unmodifiableList(new ArrayList<>(extensions));
      }
      return this;
    }

    @Deprecated
    @JsonAnySetter
    private Builder withOtherField(String name, Object value) {
      this.otherFields.put(name, value);
      return this;
    }

    public PackageInstrument build() {
      return new PackageInstrument(
          instrument,
          typeName,
          extensions,
          otherFields
      );
    }
  }

}
