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
@JsonDeserialize(builder = Person.Builder.class)
public class Person {

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(Person src) {
    return new Builder(src);
  }

  private final String name;
  private final String organization;
  private final String position;
  private final String street;
  private final String city;
  private final String state;
  private final String zip;
  private final String phone;
  private final String email;
  private final String country;
  private final String uuid;
  private final String orcid;
  private final Map<String, Object> otherFields;

  private Person(
      String name,
      String organization,
      String position,
      String street,
      String city,
      String state,
      String zip,
      String phone,
      String email,
      String country,
      String uuid,
      String orcid,
      Map<String, Object> otherFields
  ) {
    this.name = name;
    this.organization = organization;
    this.position = position;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.phone = phone;
    this.email = email;
    this.country = country;
    this.uuid = uuid;
    this.orcid = orcid;
    this.otherFields = Collections.unmodifiableMap(otherFields);
  }

  public String getName() {
    return name;
  }

  public String getOrganization() {
    return organization;
  }

  public String getPosition() {
    return position;
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

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getCountry() {
    return country;
  }

  public String getUuid() {
    return uuid;
  }

  public String getOrcid() {
    return orcid;
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
    Person person = (Person) o;
    return Objects.equals(name, person.name) && Objects.equals(organization, person.organization) && Objects.equals(
        position, person.position) && Objects.equals(street, person.street) && Objects.equals(city, person.city)
        && Objects.equals(state, person.state) && Objects.equals(zip, person.zip) && Objects.equals(phone, person.phone)
        && Objects.equals(email, person.email) && Objects.equals(country, person.country) && Objects.equals(uuid,
        person.uuid) && Objects.equals(orcid, person.orcid) && Objects.equals(otherFields, person.otherFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, organization, position, street, city, state, zip, phone, email, country, uuid, orcid, otherFields);
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", organization='" + organization + '\'' +
        ", position='" + position + '\'' +
        ", street='" + street + '\'' +
        ", city='" + city + '\'' +
        ", state='" + state + '\'' +
        ", zip='" + zip + '\'' +
        ", phone='" + phone + '\'' +
        ", email='" + email + '\'' +
        ", country='" + country + '\'' +
        ", uuid='" + uuid + '\'' +
        ", orcid='" + orcid + '\'' +
        ", otherFields=" + otherFields +
        '}';
  }

  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Builder {

    private String name;
    private String organization;
    private String position;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    private String country;
    private String uuid;
    private String orcid;
    private Map<String, Object> otherFields = new TreeMap<>();

    private Builder() {

    }

    private Builder(Person src) {
      name = src.name;
      organization = src.organization;
      position = src.position;
      street = src.street;
      city = src.city;
      state = src.state;
      zip = src.zip;
      phone = src.phone;
      email = src.email;
      country = src.country;
      uuid = src.uuid;
      orcid = src.orcid;
      otherFields = new TreeMap<>(src.otherFields);
    }

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder withPosition(String position) {
      this.position = position;
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

    public Builder withPhone(String phone) {
      this.phone = phone;
      return this;
    }

    public Builder withEmail(String email) {
      this.email = email;
      return this;
    }

    public Builder withCountry(String country) {
      this.country = country;
      return this;
    }

    public Builder withUuid(String uuid) {
      this.uuid = uuid;
      return this;
    }

    public Builder withOrcid(String orcid) {
      this.orcid = orcid;
      return this;
    }

    @Deprecated
    @JsonAnySetter
    private Builder withOtherField(String name, Object value) {
      this.otherFields.put(name, value);
      return this;
    }

    public Person build() {
      return new Person(
          name,
          organization,
          position,
          street,
          city,
          state,
          zip,
          phone,
          email,
          country,
          uuid,
          orcid,
          otherFields
      );
    }
  }
}
