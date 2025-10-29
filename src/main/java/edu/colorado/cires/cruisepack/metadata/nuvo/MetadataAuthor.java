package edu.colorado.cires.cruisepack.metadata.nuvo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonDeserialize(builder = MetadataAuthor.Builder.class)
public class MetadataAuthor {

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(MetadataAuthor src) {
    return new Builder(src);
  }

  private final String name;
  private final String uuid;
  private final String phone;
  private final String email;
  private final Map<String, Object> otherFields;

  private MetadataAuthor(String name, String uuid, String phone, String email, Map<String, Object> otherFields) {
    this.name = name;
    this.uuid = uuid;
    this.phone = phone;
    this.email = email;
    this.otherFields = Collections.unmodifiableMap(otherFields);
  }

  public String getName() {
    return name;
  }

  public String getUuid() {
    return uuid;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
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
    MetadataAuthor that = (MetadataAuthor) o;
    return Objects.equals(name, that.name) && Objects.equals(uuid, that.uuid) && Objects.equals(phone, that.phone)
        && Objects.equals(email, that.email) && Objects.equals(otherFields, that.otherFields);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, uuid, phone, email, otherFields);
  }

  @Override
  public String toString() {
    return "MetadataAuthor{" +
        "name='" + name + '\'' +
        ", uuid='" + uuid + '\'' +
        ", phone='" + phone + '\'' +
        ", email='" + email + '\'' +
        ", otherFields=" + otherFields +
        '}';
  }

  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class Builder {

    private String name;
    private String uuid;
    private String phone;
    private String email;
    private Map<String, Object> otherFields = new TreeMap<>();

    private Builder() {

    }

    private Builder(MetadataAuthor src) {
      name = src.name;
      uuid = src.uuid;
      phone = src.phone;
      email = src.email;
      otherFields = new TreeMap<>(src.otherFields);
    }

    public Builder withName(String name) {
      this.name = name;
      return this;
    }

    public Builder withUuid(String uuid) {
      this.uuid = uuid;
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

    @Deprecated
    @JsonAnySetter
    private Builder withOtherField(String name, Object value) {
      this.otherFields.put(name, value);
      return this;
    }

    public MetadataAuthor build() {
      return new MetadataAuthor(name, uuid, phone, email, otherFields);
    }
  }
}
