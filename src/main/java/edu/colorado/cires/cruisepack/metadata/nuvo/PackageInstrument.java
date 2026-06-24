package edu.colorado.cires.cruisepack.metadata.nuvo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonDeserialize(builder = PackageInstrument.Builder.class)
public class PackageInstrument implements InstrumentGetters {

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(PackageInstrument src) {
    return new Builder(src);
  }

  private final Instrument instrument;
  private final String typeName;
  private final List<String> extensions;
  private final boolean flatten;
  private final Map<String, Object> otherFields;


  private PackageInstrument(
      Instrument instrument,
      String typeName,
      List<String> extensions, boolean flatten,
      Map<String, Object> otherFields
  ) {
    this.instrument = instrument;
    this.typeName = typeName;
    this.extensions = extensions;
    this.flatten = flatten;
    this.otherFields = Collections.unmodifiableMap(otherFields);
  }

  // not using @JsonUnwrapped as it does wierd things with otherFields
  @JsonIgnore
  public Instrument getInstrumentObject() {
    return instrument;
  }

  public String getUuid() {
    return instrument.getUuid();
  }

  public String getType() {
    return instrument.getType();
  }

  public String getInstrument() {
    return instrument.getInstrument();
  }

  public String getShortName() {
    return instrument.getShortName();
  }

  public LocalDate getReleaseDate() {
    return instrument.getReleaseDate();
  }

  public Boolean getRestricted() {
    return instrument.getRestricted();
  }

  public String getStatus() {
    return instrument.getStatus();
  }

  public String getDataComment() {
    return instrument.getDataComment();
  }

  public String getDirName() {
    return instrument.getDirName();
  }

  public String getBagName() {
    return instrument.getBagName();
  }

  public String getTypeName() {
    return typeName;
  }

  public List<String> getExtensions() {
    return extensions;
  }

  public boolean isFlatten() {
    return flatten;
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
    return flatten == that.flatten && Objects.equals(instrument, that.instrument) && Objects.equals(typeName, that.typeName)
        && Objects.equals(extensions, that.extensions) && Objects.equals(otherFields, that.otherFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instrument, typeName, extensions, flatten, otherFields);
  }

  @Override
  public String toString() {
    return "PackageInstrument{" +
        "instrument=" + instrument +
        ", typeName='" + typeName + '\'' +
        ", extensions=" + extensions +
        ", flatten=" + flatten +
        ", otherFields=" + otherFields +
        '}';
  }

  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Builder implements InstrumentBuilder {

    private Instrument.Builder instrumentBuilder = Instrument.builder();
    private String typeName;
    private List<String> extensions = Collections.emptyList();
    private Boolean flatten;
    private Map<String, Object> otherFields = new TreeMap<>();

    private Builder() {

    }

    private Builder(PackageInstrument src) {
      instrumentBuilder = Instrument.builder(src.getInstrumentObject());
      typeName = src.typeName;
      extensions = src.extensions;
      otherFields = new TreeMap<>(src.otherFields);
    }

    // not using @JsonUnwrapped as it does wierd things with otherFields
    @JsonIgnore
    public Builder withInstrumentObject(Instrument instrument) {
      instrumentBuilder = Instrument.builder(instrument);
      return this;
    }

    @Override
    public Builder withUuid(String uuid) {
      instrumentBuilder.withUuid(uuid);
      return this;
    }

    @Override
    public Builder withType(String type) {
      instrumentBuilder.withType(type);
      return this;
    }

    @Override
    public Builder withInstrument(String instrument) {
      instrumentBuilder.withInstrument(instrument);
      return this;
    }

    @Override
    public Builder withShortName(String shortName) {
      instrumentBuilder.withShortName(shortName);
      return this;
    }

    @Override
    public Builder withReleaseDate(LocalDate releaseDate) {
      instrumentBuilder.withReleaseDate(releaseDate);
      return this;
    }

    @Override
    public Builder withRestricted(Boolean restricted) {
      instrumentBuilder.withRestricted(restricted);
      return this;
    }

    @Override
    public Builder withStatus(String status) {
      instrumentBuilder.withStatus(status);
      return this;
    }

    @Override
    public Builder withDataComment(String dataComment) {
      instrumentBuilder.withDataComment(dataComment);
      return this;
    }

    @Override
    public Builder withDirName(String dirName) {
      instrumentBuilder.withDirName(dirName);
      return this;
    }

    @Override
    public Builder withBagName(String bagName) {
      instrumentBuilder.withBagName(bagName);
      return this;
    }

    public Builder withTypeName(String typeName) {
      this.typeName = typeName;
      return this;
    }

    public Builder withExtensions(List<String> extensions) {
      if (extensions == null) {
        this.extensions = Collections.emptyList();
      } else {
        this.extensions = Collections.unmodifiableList(new ArrayList<>(extensions));
      }
      return this;
    }

    public Builder withFlatten(Boolean flatten) {
      this.flatten = flatten;
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
          instrumentBuilder.build(),
          typeName,
          extensions,
          flatten == null ? false : flatten,
          otherFields
      );
    }
  }

}
