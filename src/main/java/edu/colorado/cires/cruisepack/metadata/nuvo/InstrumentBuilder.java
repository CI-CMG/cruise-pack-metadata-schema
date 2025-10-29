package edu.colorado.cires.cruisepack.metadata.nuvo;

import java.time.LocalDate;

interface InstrumentBuilder {
  InstrumentBuilder withUuid(String uuid);

  InstrumentBuilder withType(String type);

  InstrumentBuilder withInstrument(String instrument);

  InstrumentBuilder withShortName(String shortName);

  InstrumentBuilder withReleaseDate(LocalDate releaseDate);

  InstrumentBuilder withRestricted(Boolean restricted);

  InstrumentBuilder withStatus(String status);

  InstrumentBuilder withDataComment(String dataComment);

  InstrumentBuilder withDirName(String dirName);

  InstrumentBuilder withBagName(String bagName);
}
