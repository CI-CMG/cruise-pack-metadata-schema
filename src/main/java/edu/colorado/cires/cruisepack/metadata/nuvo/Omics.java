package edu.colorado.cires.cruisepack.metadata.nuvo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonDeserialize(builder = Omics.Builder.class)
public class Omics {

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(Omics src) {
    return new Builder(src);
  }

  private final String ncbiAccession;
  private final List<String> samplingTypes;
  private final List<String> analysesTypes;
  private final String omicsComment;
  private final OmicsPoc omicsPoc;
  private final String trackingPath;
  private final Map<String, Object> otherFields;

  private Omics(
      String ncbiAccession,
      List<String> samplingTypes,
      List<String> analysesTypes,
      String omicsComment,
      OmicsPoc omicsPoc,
      String trackingPath,
      Map<String, Object> otherFields
  ) {
    this.ncbiAccession = ncbiAccession;
    this.samplingTypes = samplingTypes;
    this.analysesTypes = analysesTypes;
    this.omicsComment = omicsComment;
    this.omicsPoc = omicsPoc;
    this.trackingPath = trackingPath;
    this.otherFields = Collections.unmodifiableMap(otherFields);
  }


  @JsonProperty("NCBI_accession")
  public String getNcbiAccession() {
    return ncbiAccession;
  }

  public List<String> getSamplingTypes() {
    return samplingTypes;
  }

  public List<String> getAnalysesTypes() {
    return analysesTypes;
  }

  public String getOmicsComment() {
    return omicsComment;
  }

  public OmicsPoc getOmicsPoc() {
    return omicsPoc;
  }

  public String getTrackingPath() {
    return trackingPath;
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
    Omics omics = (Omics) o;
    return Objects.equals(ncbiAccession, omics.ncbiAccession) && Objects.equals(samplingTypes, omics.samplingTypes)
        && Objects.equals(analysesTypes, omics.analysesTypes) && Objects.equals(omicsComment, omics.omicsComment)
        && Objects.equals(omicsPoc, omics.omicsPoc) && Objects.equals(trackingPath, omics.trackingPath) && Objects.equals(
        otherFields, omics.otherFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ncbiAccession, samplingTypes, analysesTypes, omicsComment, omicsPoc, trackingPath, otherFields);
  }

  @Override
  public String toString() {
    return "Omics{" +
        "ncbiAccession='" + ncbiAccession + '\'' +
        ", samplingTypes=" + samplingTypes +
        ", analysesTypes=" + analysesTypes +
        ", omicsComment='" + omicsComment + '\'' +
        ", omicsPoc=" + omicsPoc +
        ", trackingPath='" + trackingPath + '\'' +
        ", otherFields=" + otherFields +
        '}';
  }

  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Builder {

    private String ncbiAccession;
    private List<String> samplingTypes;
    private List<String> analysesTypes;
    private String omicsComment;
    private OmicsPoc omicsPoc;
    private String trackingPath;
    private Map<String, Object> otherFields = new TreeMap<>();

    private Builder() {

    }

    private Builder(Omics src) {
      ncbiAccession = src.ncbiAccession;
      samplingTypes = src.samplingTypes;
      analysesTypes = src.analysesTypes;
      omicsComment = src.omicsComment;
      omicsPoc = src.omicsPoc;
      trackingPath = src.trackingPath;
      otherFields = new TreeMap<>(src.otherFields);
    }

    @JsonProperty("NCBI_accession")
    public Builder withNcbiAccession(String ncbiAccession) {
      this.ncbiAccession = ncbiAccession;
      return this;
    }

    public Builder withSamplingTypes(List<String> samplingTypes) {
      if (samplingTypes == null) {
        this.samplingTypes = null;
      } else {
        this.samplingTypes = Collections.unmodifiableList(new ArrayList<>(samplingTypes));
      }
      return this;
    }

    public Builder withAnalysesTypes(List<String> analysesTypes) {
      if (analysesTypes == null) {
        this.analysesTypes = null;
      } else {
        this.analysesTypes = Collections.unmodifiableList(new ArrayList<>(analysesTypes));
      }
      return this;
    }

    public Builder withOmicsComment(String omicsComment) {
      this.omicsComment = omicsComment;
      return this;
    }

    public Builder withOmicsPoc(OmicsPoc omicsPoc) {
      this.omicsPoc = omicsPoc;
      return this;
    }

    public Builder withTrackingPath(String trackingPath) {
      this.trackingPath = trackingPath;
      return this;
    }

    @Deprecated
    @JsonAnySetter
    private Builder withOtherField(String name, Object value) {
      this.otherFields.put(name, value);
      return this;
    }

    public Omics build() {
      return new Omics(
          ncbiAccession,
          samplingTypes,
          analysesTypes,
          omicsComment,
          omicsPoc,
          trackingPath,
          otherFields
      );
    }
  }
}
