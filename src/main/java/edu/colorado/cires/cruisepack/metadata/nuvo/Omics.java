package edu.colorado.cires.cruisepack.metadata.nuvo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
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
  private final Person omicsPoc;
  private final Map<String, Object> otherFields;

  private Omics(
      String ncbiAccession,
      List<String> samplingTypes,
      List<String> analysesTypes,
      String omicsComment,
      Person omicsPoc,
      Map<String, Object> otherFields
  ) {
    this.ncbiAccession = ncbiAccession;
    this.samplingTypes = samplingTypes;
    this.analysesTypes = analysesTypes;
    this.omicsComment = omicsComment;
    this.omicsPoc = omicsPoc;
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

  public Person getOmicsPoc() {
    return omicsPoc;
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
        && Objects.equals(omicsPoc, omics.omicsPoc) && Objects.equals(otherFields, omics.otherFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ncbiAccession, samplingTypes, analysesTypes, omicsComment, omicsPoc, otherFields);
  }

  @Override
  public String toString() {
    return "Omics{" +
        "ncbiAccession='" + ncbiAccession + '\'' +
        ", samplingTypes=" + samplingTypes +
        ", analysesTypes=" + analysesTypes +
        ", omicsComment='" + omicsComment + '\'' +
        ", omicsPoc=" + omicsPoc +
        ", otherFields=" + otherFields +
        '}';
  }

  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Builder {

    private String ncbiAccession;
    private List<String> samplingTypes = Collections.emptyList();
    private List<String> analysesTypes = Collections.emptyList();
    private String omicsComment;
    private Person omicsPoc;
    private Map<String, Object> otherFields = new TreeMap<>();

    private Builder() {

    }

    private Builder(Omics src) {
      ncbiAccession = src.ncbiAccession;
      samplingTypes = src.samplingTypes;
      analysesTypes = src.analysesTypes;
      omicsComment = src.omicsComment;
      omicsPoc = src.omicsPoc;
      otherFields = new TreeMap<>(src.otherFields);
    }

    @JsonProperty("NCBI_accession")
    public Builder withNcbiAccession(String ncbiAccession) {
      this.ncbiAccession = ncbiAccession;
      return this;
    }

    public Builder withSamplingTypes(List<String> samplingTypes) {
      if (samplingTypes == null) {
        this.samplingTypes = Collections.emptyList();
      } else {
        this.samplingTypes = Collections.unmodifiableList(new ArrayList<>(samplingTypes));
      }
      return this;
    }

    public Builder withAnalysesTypes(List<String> analysesTypes) {
      if (analysesTypes == null) {
        this.analysesTypes = Collections.emptyList();
      } else {
        this.analysesTypes = Collections.unmodifiableList(new ArrayList<>(analysesTypes));
      }
      return this;
    }

    public Builder withOmicsComment(String omicsComment) {
      this.omicsComment = omicsComment;
      return this;
    }

    public Builder withOmicsPoc(Person omicsPoc) {
      this.omicsPoc = omicsPoc;
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
          otherFields
      );
    }
  }
}
