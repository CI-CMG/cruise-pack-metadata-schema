package edu.colorado.cires.cruisepack.metadata.nuvo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonDeserialize(builder = Organization.Builder.class)
public class Organization {

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(Organization src) {
    return new Builder(src);
  }

  private final String name;
  private final String street;
  private final String city;
  private final String state;
  private final String zip;
  private final String country;
  private final String email;
  private final String phone;
  private final String uuid;
  private final Map<String, Object> otherFields;

  private Organization(
      String name,
      String street,
      String city,
      String state,
      String zip,
      String country,
      String email,
      String phone,
      String uuid,
      Map<String, Object> otherFields
  ) {
    this.name = name;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.country = country;
    this.email = email;
    this.phone = phone;
    this.uuid = uuid;
    this.otherFields = Collections.unmodifiableMap(otherFields);
  }

  public String getName() {
    return name;
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getZip() {
    return zip;
  }

  public String getCountry() {
    return country;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getUuid() {
    return uuid;
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
    Organization that = (Organization) o;
    return Objects.equals(name, that.name) && Objects.equals(street, that.street) && Objects.equals(city, that.city)
        && Objects.equals(state, that.state) && Objects.equals(zip, that.zip) && Objects.equals(country, that.country)
        && Objects.equals(email, that.email) && Objects.equals(phone, that.phone) && Objects.equals(uuid, that.uuid)
        && Objects.equals(otherFields, that.otherFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, street, city, state, zip, country, email, phone, uuid, otherFields);
  }

  @Override
  public String toString() {
    return "Organization{" +
        "name='" + name + '\'' +
        ", street='" + street + '\'' +
        ", city='" + city + '\'' +
        ", state='" + state + '\'' +
        ", zip='" + zip + '\'' +
        ", country='" + country + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", uuid='" + uuid + '\'' +
        ", otherFields=" + otherFields +
        '}';
  }

  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Builder {

    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String email;
    private String phone;
    private String uuid;
    private Map<String, Object> otherFields = new TreeMap<>();

    private Builder() {

    }

    private Builder(Organization src) {
      name = src.name;
      street = src.street;
      city = src.city;
      state = src.state;
      zip = src.zip;
      country = src.country;
      email = src.email;
      phone = src.phone;
      uuid = src.uuid;
      otherFields = new TreeMap<>(src.otherFields);
    }

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withStreet(String street) {
      this.street = street;
      return this;
    }

    public Builder withCity(String city) {
      this.city = city;
      return this;
    }

    public Builder withState(String state) {
      this.state = state;
      return this;
    }

    public Builder withZip(String zip) {
      this.zip = zip;
      return this;
    }

    public Builder withCountry(String country) {
      this.country = country;
      return this;
    }

    public Builder withEmail(String email) {
      this.email = email;
      return this;
    }

    public Builder withPhone(String phone) {
      this.phone = phone;
      return this;
    }

    public Builder withUuid(String uuid) {
      this.uuid = uuid;
      return this;
    }

    @Deprecated
    @JsonAnySetter
    private Builder withOtherField(String name, Object value) {
      this.otherFields.put(name, value);
      return this;
    }

    public Organization build() {
      return new Organization(
          name,
          street,
          city,
          state,
          zip,
          country,
          email,
          phone,
          uuid,
          otherFields
      );
    }
  }
}
