package edu.colorado.cires.cruisepack.metadata.nuvo;

import java.time.LocalDate;

interface InstrumentGetters {

  String getUuid();

  String getType();

  String getInstrument();

  String getShortName();

  LocalDate getReleaseDate();

  Boolean getRestricted();

  String getStatus();

  String getDataComment();

  String getDirName();

  String getBagName();
}
