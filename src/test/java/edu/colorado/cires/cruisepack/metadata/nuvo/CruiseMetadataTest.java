package edu.colorado.cires.cruisepack.metadata.nuvo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class CruiseMetadataTest {

  private final ObjectMapper objectMapper = CruisePackMetadataObjectMapperFactory.createObjectMapper();

  @Test
  public void testSerdesCruise() throws IOException {
    Path input = Paths.get("src/test/resources/EX1907_MAIN-metadata.json");
    Path output = Paths.get("target/EX1907_MAIN-metadata.json");
    Files.createDirectories(output.getParent());
    Files.deleteIfExists(output);

    CruiseMetadata cruiseMetadata = objectMapper.readValue(input.toFile(), CruiseMetadata.class);
    assertTrue(cruiseMetadata.isRestricted());
    assertEquals("EX1907", cruiseMetadata.getCruiseId());
    assertEquals("MAIN", cruiseMetadata.getSegmentId());
    assertEquals("EX1907_MAIN", cruiseMetadata.getPackageId());
    assertEquals("2025-10-01", cruiseMetadata.getMasterReleaseDate().toString());
    assertEquals("Amy Gale", cruiseMetadata.getShip());
    assertEquals("3dd829c5-7783-4075-a760-4f3aa3857482", cruiseMetadata.getShipUuid());
    assertEquals("Aaiun, EH", cruiseMetadata.getDeparturePort());
    assertEquals("2025-10-01", cruiseMetadata.getDepartureDate().toString());
    assertEquals("Aalborg, DK", cruiseMetadata.getArrivalPort());
    assertEquals("2025-10-01", cruiseMetadata.getArrivalDate().toString());
    assertEquals("Aegean Sea", cruiseMetadata.getSeaArea());
    assertEquals("Three Hour Cruise", cruiseMetadata.getCruiseTitle());
    assertEquals("Fishin", cruiseMetadata.getCruisePurpose());
    assertEquals("Five passengers set sail that day for a three hour tour", cruiseMetadata.getCruiseDescription());

    assertEquals(1, cruiseMetadata.getSources().size());
    Organization source = cruiseMetadata.getSources().get(0);
    assertEquals("AFSC", source.getName());
    assertEquals("7600 Sand Point Way N.E., Building 4", source.getStreet());
    assertEquals("Seattle", source.getCity());
    assertEquals("WA", source.getState());
    assertEquals("98115", source.getZip());
    assertEquals("USA", source.getCountry());
    assertEquals("206-526-4000", source.getPhone());
    assertNull(source.getEmail());
    assertEquals("01082b23-154c-4c2d-bef7-5e35315d41e0", source.getUuid());
    assertTrue((Boolean) source.getOtherFields().get("use"));

    assertEquals(1, cruiseMetadata.getFunders().size());
    Organization funder = cruiseMetadata.getFunders().get(0);
    assertEquals("OER", funder.getName());
    assertEquals("SSMC3, 1315 East-West Highway, 10th Floor", funder.getStreet());
    assertEquals("Silver Spring", funder.getCity());
    assertEquals("MD", funder.getState());
    assertEquals("20910", funder.getZip());
    assertEquals("USA", funder.getCountry());
    assertEquals("ncddcmetadata@noaa.gov", funder.getEmail());
    assertEquals("301-734-1000", funder.getPhone());
    assertEquals("08D95C427FB128479945893256DADE37", funder.getUuid());
    assertTrue((Boolean) funder.getOtherFields().get("use"));

    assertEquals(1, cruiseMetadata.getScientists().size());
    Person scientist = cruiseMetadata.getScientists().get(0);
    assertEquals("Chuck Anderson", scientist.getName());
    assertEquals("NCEI", scientist.getOrganization());
    assertEquals("Fisheries Acoustics Data Manager", scientist.getPosition());
    assertEquals("325 S. Broadway", scientist.getStreet());
    assertEquals("Boulder", scientist.getCity());
    assertEquals("CO", scientist.getState());
    assertEquals("80305", scientist.getZip());
    assertEquals("USA", scientist.getCountry());
    assertEquals("charles.anderson@noaa.gov", scientist.getEmail());
    assertEquals("303-497-4742", scientist.getPhone());
    assertEquals("7273deab-88c3-4b1d-9b80-0ee5fbc42a21", scientist.getUuid());
    assertTrue((Boolean) scientist.getOtherFields().get("use"));

    assertEquals(Collections.singletonList("OASIS"), cruiseMetadata.getProjects());

    Omics omics = cruiseMetadata.getOmics();
    assertEquals(Arrays.asList(
        "Water",
        "Soil/Sediment",
        "Organic Tissue"
    ), omics.getSamplingTypes());
    assertEquals(Arrays.asList(
        "Barcoding",
        "Genomics",
        "Transcriptomics",
        "Proteomics",
        "Metabolomics",
        "Epigenetics",
        "Other",
        "Metabarcoding",
        "Metagenomics",
        "Metatranscriptomics",
        "Metaproteomics",
        "Metametabolomics",
        "Microbiome"
    ), omics.getAnalysesTypes());
    assertEquals("More info", omics.getOmicsComment());
    assertEquals("11111", omics.getNcbiAccession());
    assertTrue(omics.getOtherFields().isEmpty());

    Person omicsPoc = omics.getOmicsPoc();
    assertEquals("Anne Trehu", omicsPoc.getName());
    assertEquals("fcac5cf3-18fe-4047-8819-b996a6fa90cd", omicsPoc.getUuid());
    assertEquals("541-737-2655", omicsPoc.getPhone());
    assertEquals("trehu@coas.oregonstate.edu", omicsPoc.getEmail());
    assertTrue(omicsPoc.getOtherFields().isEmpty());

    Person metadataAuthor = cruiseMetadata.getMetadataAuthor();
    assertEquals("Anne Trehu", metadataAuthor.getName());
    assertEquals("fcac5cf3-18fe-4047-8819-b996a6fa90cd", metadataAuthor.getUuid());
    assertEquals("541-737-2655", metadataAuthor.getPhone());
    assertEquals("trehu@coas.oregonstate.edu", metadataAuthor.getEmail());
    assertTrue(metadataAuthor.getOtherFields().isEmpty());

    assertEquals(2, cruiseMetadata.getInstruments().size());
    Instrument em122 = cruiseMetadata.getInstruments().get(0);
    assertEquals("9da1f3f0-9ec8-11e1-a8b0-0800200c9a66", em122.getUuid());
    assertEquals("Multibeam Bathymetry", em122.getType());
    assertEquals("Kongsberg EM122", em122.getInstrument());
    assertEquals("EM122", em122.getShortName());
    assertEquals("2025-10-01", em122.getReleaseDate().toString());
    assertNull(em122.getRestricted());
    assertEquals("Raw", em122.getStatus());
    assertEquals("Bathy", em122.getDataComment());
    assertEquals("EM122", em122.getDirName());
    assertEquals("EX1907_MAIN_MB-BATHY", em122.getBagName());
    assertTrue(em122.getOtherFields().isEmpty());

    Instrument ancillary = cruiseMetadata.getInstruments().get(1);
    assertEquals("9da1f3f0-9ec8-11e1-a8b0-0800200c9a66", ancillary.getUuid());
    assertEquals("Ancillary Data", ancillary.getType());
    assertEquals("Multibeam Bathymetry Ancillary", ancillary.getInstrument());
    assertEquals("MB", ancillary.getShortName());
    assertEquals("2025-10-01", ancillary.getReleaseDate().toString());
    assertFalse(ancillary.getRestricted());
    assertEquals("Raw", ancillary.getStatus());
    assertEquals("Ancillary Bathy", ancillary.getDataComment());
    assertEquals("MB", ancillary.getDirName());
    assertEquals("EX1907_MAIN_ANCILLARY", ancillary.getBagName());
    assertTrue(ancillary.getOtherFields().isEmpty());

    assertTrue(cruiseMetadata.getPackageInstruments().isEmpty());
    assertTrue(cruiseMetadata.getOtherFields().isEmpty());

    objectMapper.writeValue(output.toFile(), cruiseMetadata);

    JsonNode expected = objectMapper.readTree(input.toFile());
    JsonNode written = objectMapper.readTree(output.toFile());
    assertEquals(expected, written);

  }

  @Test
  public void testSerdesDataset() throws IOException {
    Path input = Paths.get("src/test/resources/EX1907_MAIN_MB-BATHY_EM122-metadata.json");
    Path output = Paths.get("target/EX1907_MAIN_MB-BATHY_EM122-metadata.json");
    Files.createDirectories(output.getParent());
    Files.deleteIfExists(output);

    ObjectMapper objectMapper = CruisePackMetadataObjectMapperFactory.createObjectMapper();
    CruiseMetadata cruiseMetadata = objectMapper.readValue(input.toFile(), CruiseMetadata.class);
    assertFalse(cruiseMetadata.isRestricted());
    assertEquals("EX1907", cruiseMetadata.getCruiseId());
    assertEquals("MAIN", cruiseMetadata.getSegmentId());
    assertEquals("EX1907_MAIN", cruiseMetadata.getPackageId());
    assertEquals("2025-10-01", cruiseMetadata.getMasterReleaseDate().toString());
    assertEquals("Amy Gale", cruiseMetadata.getShip());
    assertEquals("3dd829c5-7783-4075-a760-4f3aa3857482", cruiseMetadata.getShipUuid());
    assertEquals("Aaiun, EH", cruiseMetadata.getDeparturePort());
    assertEquals("2025-10-01", cruiseMetadata.getDepartureDate().toString());
    assertEquals("Aalborg, DK", cruiseMetadata.getArrivalPort());
    assertEquals("2025-10-01", cruiseMetadata.getArrivalDate().toString());
    assertEquals("Aegean Sea", cruiseMetadata.getSeaArea());
    assertEquals("Three Hour Cruise", cruiseMetadata.getCruiseTitle());
    assertEquals("Fishin", cruiseMetadata.getCruisePurpose());
    assertEquals("Five passengers set sail that day for a three hour tour", cruiseMetadata.getCruiseDescription());

    assertEquals(1, cruiseMetadata.getSources().size());
    Organization source = cruiseMetadata.getSources().get(0);
    assertEquals("AFSC", source.getName());
    assertEquals("7600 Sand Point Way N.E., Building 4", source.getStreet());
    assertEquals("Seattle", source.getCity());
    assertEquals("WA", source.getState());
    assertEquals("98115", source.getZip());
    assertEquals("USA", source.getCountry());
    assertEquals("206-526-4000", source.getPhone());
    assertNull(source.getEmail());
    assertEquals("01082b23-154c-4c2d-bef7-5e35315d41e0", source.getUuid());
    assertTrue((Boolean) source.getOtherFields().get("use"));

    assertEquals(1, cruiseMetadata.getFunders().size());
    Organization funder = cruiseMetadata.getFunders().get(0);
    assertEquals("OER", funder.getName());
    assertEquals("SSMC3, 1315 East-West Highway, 10th Floor", funder.getStreet());
    assertEquals("Silver Spring", funder.getCity());
    assertEquals("MD", funder.getState());
    assertEquals("20910", funder.getZip());
    assertEquals("USA", funder.getCountry());
    assertEquals("ncddcmetadata@noaa.gov", funder.getEmail());
    assertEquals("301-734-1000", funder.getPhone());
    assertEquals("08D95C427FB128479945893256DADE37", funder.getUuid());
    assertTrue((Boolean) funder.getOtherFields().get("use"));

    assertEquals(1, cruiseMetadata.getScientists().size());
    Person scientist = cruiseMetadata.getScientists().get(0);
    assertEquals("Chuck Anderson", scientist.getName());
    assertEquals("NCEI", scientist.getOrganization());
    assertEquals("Fisheries Acoustics Data Manager", scientist.getPosition());
    assertEquals("325 S. Broadway", scientist.getStreet());
    assertEquals("Boulder", scientist.getCity());
    assertEquals("CO", scientist.getState());
    assertEquals("80305", scientist.getZip());
    assertEquals("USA", scientist.getCountry());
    assertEquals("charles.anderson@noaa.gov", scientist.getEmail());
    assertEquals("303-497-4742", scientist.getPhone());
    assertEquals("7273deab-88c3-4b1d-9b80-0ee5fbc42a21", scientist.getUuid());
    assertTrue((Boolean) scientist.getOtherFields().get("use"));

    assertTrue(cruiseMetadata.getProjects().isEmpty());

    Omics omics = cruiseMetadata.getOmics();
    assertEquals(Arrays.asList(
        "Water",
        "Soil/Sediment",
        "Organic Tissue"
    ), omics.getSamplingTypes());
    assertEquals(Arrays.asList(
        "Barcoding",
        "Genomics",
        "Transcriptomics",
        "Proteomics",
        "Metabolomics",
        "Epigenetics",
        "Other",
        "Metabarcoding",
        "Metagenomics",
        "Metatranscriptomics",
        "Metaproteomics",
        "Metametabolomics",
        "Microbiome"
    ), omics.getAnalysesTypes());
    assertEquals("More info", omics.getOmicsComment());
    assertEquals("11111", omics.getNcbiAccession());
    assertTrue(omics.getOtherFields().isEmpty());

    Person omicsPoc = omics.getOmicsPoc();
    assertEquals("Anne Trehu", omicsPoc.getName());
    assertEquals("fcac5cf3-18fe-4047-8819-b996a6fa90cd", omicsPoc.getUuid());
    assertEquals("541-737-2655", omicsPoc.getPhone());
    assertEquals("trehu@coas.oregonstate.edu", omicsPoc.getEmail());
    assertTrue(omicsPoc.getOtherFields().isEmpty());

    Person metadataAuthor = cruiseMetadata.getMetadataAuthor();
    assertEquals("Anne Trehu", metadataAuthor.getName());
    assertEquals("fcac5cf3-18fe-4047-8819-b996a6fa90cd", metadataAuthor.getUuid());
    assertEquals("541-737-2655", metadataAuthor.getPhone());
    assertEquals("trehu@coas.oregonstate.edu", metadataAuthor.getEmail());
    assertTrue(metadataAuthor.getOtherFields().isEmpty());

    assertEquals(2, cruiseMetadata.getInstruments().size());
    Instrument em122 = cruiseMetadata.getInstruments().get(0);
    assertEquals("9da1f3f0-9ec8-11e1-a8b0-0800200c9a66", em122.getUuid());
    assertEquals("Multibeam Bathymetry", em122.getType());
    assertEquals("Kongsberg EM122", em122.getInstrument());
    assertEquals("EM122", em122.getShortName());
    assertEquals("2025-10-01", em122.getReleaseDate().toString());
    assertNull(em122.getRestricted());
    assertEquals("Raw", em122.getStatus());
    assertEquals("Bathy", em122.getDataComment());
    assertEquals("EM122", em122.getDirName());
    assertEquals("EX1907_MAIN_MB-BATHY", em122.getBagName());
    assertTrue(em122.getOtherFields().isEmpty());

    Instrument ancillary = cruiseMetadata.getInstruments().get(1);
    assertEquals("9da1f3f0-9ec8-11e1-a8b0-0800200c9a66", ancillary.getUuid());
    assertEquals("Ancillary Data", ancillary.getType());
    assertEquals("Multibeam Bathymetry Ancillary", ancillary.getInstrument());
    assertEquals("MB", ancillary.getShortName());
    assertEquals("2025-10-01", ancillary.getReleaseDate().toString());
    assertNull(ancillary.getRestricted());
    assertEquals("Raw", ancillary.getStatus());
    assertEquals("Ancillary Bathy", ancillary.getDataComment());
    assertEquals("MB", ancillary.getDirName());
    assertEquals("EX1907_MAIN_ANCILLARY", ancillary.getBagName());
    assertTrue(ancillary.getOtherFields().isEmpty());

    Map<String, PackageInstrument> packageInstruments = cruiseMetadata.getPackageInstruments();
    assertEquals(1, packageInstruments.size());
    PackageInstrument packageInstrument = packageInstruments.get("EM122");

    assertEquals("9da1f3f0-9ec8-11e1-a8b0-0800200c9a66", packageInstrument.getInstrumentObject().getUuid());
    assertEquals("Multibeam Bathymetry", packageInstrument.getInstrumentObject().getType());
    assertEquals("Kongsberg EM122", packageInstrument.getInstrumentObject().getInstrument());
    assertEquals("EM122", packageInstrument.getInstrumentObject().getShortName());
    assertEquals("2025-10-01", packageInstrument.getInstrumentObject().getReleaseDate().toString());
    assertNull(packageInstrument.getInstrumentObject().getRestricted());
    assertEquals("Raw", packageInstrument.getInstrumentObject().getStatus());
    assertEquals("Bathy", packageInstrument.getInstrumentObject().getDataComment());
    assertEquals("EM122", packageInstrument.getInstrumentObject().getDirName());
    assertEquals("EX1907_MAIN_MB-BATHY", packageInstrument.getInstrumentObject().getBagName());

    assertEquals("9da1f3f0-9ec8-11e1-a8b0-0800200c9a66", packageInstrument.getUuid());
    assertEquals("Multibeam Bathymetry", packageInstrument.getType());
    assertEquals("Kongsberg EM122", packageInstrument.getInstrument());
    assertEquals("EM122", packageInstrument.getShortName());
    assertEquals("2025-10-01", packageInstrument.getReleaseDate().toString());
    assertNull(packageInstrument.getRestricted());
    assertEquals("Raw", packageInstrument.getStatus());
    assertEquals("Bathy", packageInstrument.getDataComment());
    assertEquals("EM122", packageInstrument.getDirName());
    assertEquals("EX1907_MAIN_MB-BATHY", packageInstrument.getBagName());

    assertEquals("MB-BATHY", packageInstrument.getTypeName());

    assertTrue(packageInstrument.isFlatten());
    assertEquals(Arrays.asList(
        "all",
        "kmall"
    ), packageInstrument.getExtensions());

    assertTrue(packageInstrument.getInstrumentObject().getOtherFields().isEmpty());
    assertEquals(1, packageInstrument.getOtherFields().size());
    assertEquals("bar", packageInstrument.getOtherFields().get("foo"));

    assertTrue(cruiseMetadata.getOtherFields().isEmpty());

    objectMapper.writeValue(output.toFile(), cruiseMetadata);

    JsonNode expected = objectMapper.readTree(input.toFile());
    ObjectNode written = (ObjectNode) objectMapper.readTree(output.toFile());
    assertFalse(written.get("restricted").asBoolean());
    written.remove("restricted");
    assertEquals(expected, written);

  }

  @Test
  public void testEmptyCollections() throws IOException {
    assertEquals("{\"restricted\":false}", objectMapper.writeValueAsString(CruiseMetadata.builder().build()));
  }

}