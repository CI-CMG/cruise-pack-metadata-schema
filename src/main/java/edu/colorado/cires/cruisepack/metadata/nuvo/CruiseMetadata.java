package edu.colorado.cires.cruisepack.metadata.nuvo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonDeserialize(builder = CruiseMetadata.Builder.class)
public class CruiseMetadata {

  public static Builder builder(CruiseMetadata data) {
    return new Builder(data);
  }

  public static Builder builder() {
    return new Builder();
  }

  private final boolean neverPublic;
  private final String cruiseId;
  private final String segmentId;
  private final String packageId;
  private final String masterReleaseDate;
  private final String ship;
  private final String shipUuid;
  private final String departurePort;
  private final String departureDate;
  private final String arrivalPort;
  private final String arrivalDate;
  private final String seaArea;
  private final String cruiseTitle;
  private final String cruisePurpose;
  private final String cruiseDescription;
  private final List<Organization> sources;
  private final List<Organization> funders;
  private final List<Person> scientists;
  private final List<String> projects;
  private final Omics omics;
  private final MetadataAuthor metadataAuthor;
  private final List<Instrument> instruments;
  private final Map<String, PackageInstrument> packageInstruments;
  private final Map<String, Object> otherFields;

  private CruiseMetadata(
      boolean neverPublic,
      String cruiseId,
      String segmentId,
      String packageId,
      String masterReleaseDate,
      String ship,
      String shipUuid,
      String departurePort,
      String departureDate,
      String arrivalPort,
      String arrivalDate,
      String seaArea,
      String cruiseTitle,
      String cruisePurpose,
      String cruiseDescription,
      List<Organization> sources,
      List<Organization> funders,
      List<Person> scientists,
      List<String> projects,
      Omics omics,
      MetadataAuthor metadataAuthor,
      List<Instrument> instruments,
      Map<String, PackageInstrument> packageInstruments,
      Map<String, Object> otherFields
  ) {
    this.neverPublic = neverPublic;
    this.cruiseId = cruiseId;
    this.segmentId = segmentId;
    this.packageId = packageId;
    this.masterReleaseDate = masterReleaseDate;
    this.ship = ship;
    this.shipUuid = shipUuid;
    this.departurePort = departurePort;
    this.departureDate = departureDate;
    this.arrivalPort = arrivalPort;
    this.arrivalDate = arrivalDate;
    this.seaArea = seaArea;
    this.cruiseTitle = cruiseTitle;
    this.cruisePurpose = cruisePurpose;
    this.cruiseDescription = cruiseDescription;
    this.sources = sources;
    this.funders = funders;
    this.scientists = scientists;
    this.projects = projects;
    this.omics = omics;
    this.metadataAuthor = metadataAuthor;
    this.instruments = instruments;
    this.packageInstruments = packageInstruments;
    this.otherFields = Collections.unmodifiableMap(otherFields);
  }

  public boolean isNeverPublic() {
    return neverPublic;
  }

  public String getCruiseId() {
    return cruiseId;
  }

  public String getSegmentId() {
    return segmentId;
  }

  public String getPackageId() {
    return packageId;
  }

  public String getMasterReleaseDate() {
    return masterReleaseDate;
  }

  public String getShip() {
    return ship;
  }

  public String getShipUuid() {
    return shipUuid;
  }

  public String getDeparturePort() {
    return departurePort;
  }

  public String getDepartureDate() {
    return departureDate;
  }

  public String getArrivalPort() {
    return arrivalPort;
  }

  public String getArrivalDate() {
    return arrivalDate;
  }

  public String getSeaArea() {
    return seaArea;
  }

  public String getCruiseTitle() {
    return cruiseTitle;
  }

  public String getCruisePurpose() {
    return cruisePurpose;
  }

  public String getCruiseDescription() {
    return cruiseDescription;
  }

  public List<Organization> getSources() {
    return sources;
  }

  public List<Organization> getFunders() {
    return funders;
  }

  public List<Person> getScientists() {
    return scientists;
  }

  public List<String> getProjects() {
    return projects;
  }

  public Omics getOmics() {
    return omics;
  }

  public MetadataAuthor getMetadataAuthor() {
    return metadataAuthor;
  }

  public List<Instrument> getInstruments() {
    return instruments;
  }

  public Map<String, PackageInstrument> getPackageInstruments() {
    return packageInstruments;
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
    CruiseMetadata that = (CruiseMetadata) o;
    return neverPublic == that.neverPublic && Objects.equals(cruiseId, that.cruiseId) && Objects.equals(segmentId, that.segmentId)
        && Objects.equals(packageId, that.packageId) && Objects.equals(masterReleaseDate, that.masterReleaseDate)
        && Objects.equals(ship, that.ship) && Objects.equals(shipUuid, that.shipUuid) && Objects.equals(departurePort,
        that.departurePort) && Objects.equals(departureDate, that.departureDate) && Objects.equals(arrivalPort, that.arrivalPort)
        && Objects.equals(arrivalDate, that.arrivalDate) && Objects.equals(seaArea, that.seaArea) && Objects.equals(
        cruiseTitle, that.cruiseTitle) && Objects.equals(cruisePurpose, that.cruisePurpose) && Objects.equals(cruiseDescription,
        that.cruiseDescription) && Objects.equals(sources, that.sources) && Objects.equals(funders, that.funders)
        && Objects.equals(scientists, that.scientists) && Objects.equals(projects, that.projects) && Objects.equals(omics,
        that.omics) && Objects.equals(metadataAuthor, that.metadataAuthor) && Objects.equals(instruments, that.instruments)
        && Objects.equals(packageInstruments, that.packageInstruments) && Objects.equals(otherFields, that.otherFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(neverPublic, cruiseId, segmentId, packageId, masterReleaseDate, ship, shipUuid, departurePort, departureDate, arrivalPort,
        arrivalDate, seaArea, cruiseTitle, cruisePurpose, cruiseDescription, sources, funders, scientists, projects, omics, metadataAuthor,
        instruments,
        packageInstruments, otherFields);
  }

  @Override
  public String toString() {
    return "CruiseMetadata{" +
        "neverPublic=" + neverPublic +
        ", cruiseId='" + cruiseId + '\'' +
        ", segmentId='" + segmentId + '\'' +
        ", packageId='" + packageId + '\'' +
        ", masterReleaseDate='" + masterReleaseDate + '\'' +
        ", ship='" + ship + '\'' +
        ", shipUuid='" + shipUuid + '\'' +
        ", departurePort='" + departurePort + '\'' +
        ", departureDate='" + departureDate + '\'' +
        ", arrivalPort='" + arrivalPort + '\'' +
        ", arrivalDate='" + arrivalDate + '\'' +
        ", seaArea='" + seaArea + '\'' +
        ", cruiseTitle='" + cruiseTitle + '\'' +
        ", cruisePurpose='" + cruisePurpose + '\'' +
        ", cruiseDescription='" + cruiseDescription + '\'' +
        ", sources=" + sources +
        ", funders=" + funders +
        ", scientists=" + scientists +
        ", projects=" + projects +
        ", omics=" + omics +
        ", metadataAuthor=" + metadataAuthor +
        ", instruments=" + instruments +
        ", packageInstruments=" + packageInstruments +
        ", otherFields=" + otherFields +
        '}';
  }

  public static class Builder {

    private Boolean neverPublic;
    private String cruiseId;
    private String segmentId;
    private String packageId;
    private String masterReleaseDate;
    private String ship;
    private String shipUuid;
    private String departurePort;
    private String departureDate;
    private String arrivalPort;
    private String arrivalDate;
    private String seaArea;
    private String cruiseTitle;
    private String cruisePurpose;
    private String cruiseDescription;
    private List<Organization> sources;
    private List<Organization> funders;
    private List<Person> scientists;
    private List<String> projects;
    private Omics omics;
    private MetadataAuthor metadataAuthor;
    private List<Instrument> instruments;
    private Map<String, PackageInstrument> packageInstruments;
    private Map<String, Object> otherFields = new TreeMap<>();

    private Builder() {

    }

    private Builder(CruiseMetadata src) {
      neverPublic = src.neverPublic;
      cruiseId = src.getCruiseId();
      segmentId = src.getSegmentId();
      packageId = src.getPackageId();
      masterReleaseDate = src.getMasterReleaseDate();
      ship = src.getShip();
      shipUuid = src.getShipUuid();
      departurePort = src.getDeparturePort();
      departureDate = src.getDepartureDate();
      arrivalPort = src.getArrivalPort();
      arrivalDate = src.getArrivalDate();
      seaArea = src.getSeaArea();
      cruiseTitle = src.getCruiseTitle();
      cruisePurpose = src.getCruisePurpose();
      cruiseDescription = src.getCruiseDescription();
      sources = src.getSources();
      funders = src.getFunders();
      scientists = src.getScientists();
      projects = src.getProjects();
      omics = src.getOmics();
      metadataAuthor = src.getMetadataAuthor();
      instruments = src.getInstruments();
      packageInstruments = src.getPackageInstruments();
      otherFields = new TreeMap<>(src.getOtherFields());
    }

    public Builder withNeverPublic(Boolean neverPublic) {
      this.neverPublic = neverPublic;
      return this;
    }

    public Builder withCruiseId(String cruiseId) {
      this.cruiseId = cruiseId;
      return this;
    }

    public Builder withSegmentId(String segmentId) {
      this.segmentId = segmentId;
      return this;
    }

    public Builder withPackageId(String packageId) {
      this.packageId = packageId;
      return this;
    }

    public Builder withMasterReleaseDate(String masterReleaseDate) {
      this.masterReleaseDate = masterReleaseDate;
      return this;
    }

    public Builder withShip(String ship) {
      this.ship = ship;
      return this;
    }

    public Builder withShipUuid(String shipUuid) {
      this.shipUuid = shipUuid;
      return this;
    }

    public Builder withDeparturePort(String departurePort) {
      this.departurePort = departurePort;
      return this;
    }

    public Builder withDepartureDate(String departureDate) {
      this.departureDate = departureDate;
      return this;
    }

    public Builder withArrivalPort(String arrivalPort) {
      this.arrivalPort = arrivalPort;
      return this;
    }

    public Builder withArrivalDate(String arrivalDate) {
      this.arrivalDate = arrivalDate;
      return this;
    }

    public Builder withSeaArea(String seaArea) {
      this.seaArea = seaArea;
      return this;
    }

    public Builder withCruiseTitle(String cruiseTitle) {
      this.cruiseTitle = cruiseTitle;
      return this;
    }

    public Builder withCruisePurpose(String cruisePurpose) {
      this.cruisePurpose = cruisePurpose;
      return this;
    }

    public Builder withCruiseDescription(String cruiseDescription) {
      this.cruiseDescription = cruiseDescription;
      return this;
    }

    public Builder withSources(List<Organization> sources) {
      if (sources == null) {
        this.sources = null;
      } else {
        this.sources = Collections.unmodifiableList(new ArrayList<>(sources));
      }
      return this;
    }

    public Builder withFunders(List<Organization> funders) {
      if (funders == null) {
        this.funders = null;
      } else {
        this.funders = Collections.unmodifiableList(new ArrayList<>(funders));
      }
      return this;
    }

    public Builder withScientists(List<Person> scientists) {
      if (scientists == null) {
        this.scientists = null;
      } else {
        this.scientists = Collections.unmodifiableList(new ArrayList<>(scientists));
      }
      return this;
    }

    public Builder withProjects(List<String> projects) {
      if (projects == null) {
        this.projects = null;
      } else {
        this.projects = Collections.unmodifiableList(new ArrayList<>(projects));
      }
      return this;
    }

    public Builder withOmics(Omics omics) {
      this.omics = omics;
      return this;
    }

    public Builder withMetadataAuthor(MetadataAuthor metadataAuthor) {
      this.metadataAuthor = metadataAuthor;
      return this;
    }

    public Builder withInstruments(List<Instrument> instruments) {
      if (instruments == null) {
        this.instruments = null;
      } else {
        this.instruments = Collections.unmodifiableList(new ArrayList<>(instruments));
      }
      return this;
    }

    public Builder withPackageInstruments(Map<String, PackageInstrument> packageInstruments) {
      if (packageInstruments == null) {
        this.packageInstruments = null;
      } else {
        this.packageInstruments = Collections.unmodifiableMap(new LinkedHashMap<>(packageInstruments));
      }
      return this;
    }

    @Deprecated
    @JsonAnySetter
    private Builder withOtherField(String name, Object value) {
      this.otherFields.put(name, value);
      return this;
    }

    public CruiseMetadata build() {
      return new CruiseMetadata(
          neverPublic == null ? false : neverPublic,
          cruiseId,
          segmentId,
          packageId,
          masterReleaseDate,
          ship,
          shipUuid,
          departurePort,
          departureDate,
          arrivalPort,
          arrivalDate,
          seaArea,
          cruiseTitle,
          cruisePurpose,
          cruiseDescription,
          sources,
          funders,
          scientists,
          projects,
          omics,
          metadataAuthor,
          instruments,
          packageInstruments,
          otherFields);
    }
  }


}
