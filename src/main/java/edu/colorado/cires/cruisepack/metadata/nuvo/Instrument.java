package edu.colorado.cires.cruisepack.metadata.nuvo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonDeserialize(builder = Instrument.Builder.class)
public class Instrument implements InstrumentGetters {

  public static Builder builder(Instrument data) {
    return new Builder(data);
  }

  public static Builder builder() {
    return new Builder();
  }

  private final String uuid;
  private final String type;
  private final String instrument;
  private final String shortName;
  private final LocalDate releaseDate;
  private Boolean restricted;
  private final String status;
  private final String dataComment;
  private final String dirName;
  private final String bagName;
  private final Map<String, Object> otherFields;

  private Instrument(
      String uuid,
      String type,
      String instrument,
      String shortName,
      LocalDate releaseDate,
      Boolean restricted,
      String status,
      String dataComment,
      String dirName,
      String bagName,
      Map<String, Object> otherFields
  ) {
    this.uuid = uuid;
    this.type = type;
    this.instrument = instrument;
    this.shortName = shortName;
    this.releaseDate = releaseDate;
    this.restricted = restricted;
    this.status = status;
    this.dataComment = dataComment;
    this.dirName = dirName;
    this.bagName = bagName;
    this.otherFields = Collections.unmodifiableMap(otherFields);
  }

  public String getUuid() {
    return uuid;
  }

  public String getType() {
    return type;
  }

  public String getInstrument() {
    return instrument;
  }

  public String getShortName() {
    return shortName;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public Boolean getRestricted() {
    return restricted;
  }

  public String getStatus() {
    return status;
  }

  public String getDataComment() {
    return dataComment;
  }

  public String getDirName() {
    return dirName;
  }

  public String getBagName() {
    return bagName;
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
    Instrument that = (Instrument) o;
    return Objects.equals(uuid, that.uuid) && Objects.equals(type, that.type) && Objects.equals(instrument,
        that.instrument) && Objects.equals(shortName, that.shortName) && Objects.equals(releaseDate, that.releaseDate)
        && Objects.equals(restricted, that.restricted) && Objects.equals(status, that.status) && Objects.equals(
        dataComment, that.dataComment) && Objects.equals(dirName, that.dirName) && Objects.equals(bagName, that.bagName)
        && Objects.equals(otherFields, that.otherFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, type, instrument, shortName, releaseDate, restricted, status, dataComment, dirName, bagName, otherFields);
  }

  @Override
  public String toString() {
    return "Instrument{" +
        "uuid='" + uuid + '\'' +
        ", type='" + type + '\'' +
        ", instrument='" + instrument + '\'' +
        ", shortName='" + shortName + '\'' +
        ", releaseDate=" + releaseDate +
        ", restricted=" + restricted +
        ", status='" + status + '\'' +
        ", dataComment='" + dataComment + '\'' +
        ", dirName='" + dirName + '\'' +
        ", bagName='" + bagName + '\'' +
        ", otherFields=" + otherFields +
        '}';
  }

  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Builder implements InstrumentBuilder {

    private String uuid;
    private String type;
    private String instrument;
    private String shortName;
    private LocalDate releaseDate;
    private Boolean restricted;
    private String status;
    private String dataComment;
    private String dirName;
    private String bagName;
    private Map<String, Object> otherFields = new TreeMap<>();

    private Builder() {

    }

    private Builder(Instrument src) {
      uuid = src.getUuid();
      type = src.getType();
      instrument = src.getInstrument();
      shortName = src.getShortName();
      releaseDate = src.getReleaseDate();
      restricted = src.getRestricted();
      status = src.getStatus();
      dataComment = src.getDataComment();
      dirName = src.getDirName();
      bagName = src.getBagName();
      otherFields = new TreeMap<>(src.getOtherFields());
    }

    public Builder withUuid(String uuid) {
      this.uuid = uuid;
      return this;
    }

    public Builder withType(String type) {
      this.type = type;
      return this;
    }

    public Builder withInstrument(String instrument) {
      this.instrument = instrument;
      return this;
    }

    public Builder withShortName(String shortName) {
      this.shortName = shortName;
      return this;
    }

    public Builder withReleaseDate(LocalDate releaseDate) {
      this.releaseDate = releaseDate;
      return this;
    }

    public Builder withRestricted(Boolean restricted) {
      this.restricted = restricted;
      return this;
    }

    public Builder withStatus(String status) {
      this.status = status;
      return this;
    }

    public Builder withDataComment(String dataComment) {
      this.dataComment = dataComment;
      return this;
    }

    public Builder withDirName(String dirName) {
      this.dirName = dirName;
      return this;
    }

    public Builder withBagName(String bagName) {
      this.bagName = bagName;
      return this;
    }

    @Deprecated
    @JsonAnySetter
    private Builder withOtherField(String name, Object value) {
      this.otherFields.put(name, value);
      return this;
    }

    public Instrument build() {
      return new Instrument(
          uuid,
          type,
          instrument,
          shortName,
          releaseDate,
          restricted,
          status,
          dataComment,
          dirName,
          bagName,
          otherFields
      );
    }
  }
}
