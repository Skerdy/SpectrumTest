// Copyright 2012 Square, Inc.
package com.squareup.timessquare;

import java.util.Date;

class MonthDescriptor {
  private final int month;
  private final int year;
  private final Date date;
  private String label;
  private String tripLabel;

  MonthDescriptor(int month, int year, Date date, String label, String tripLabel) {
    this.month = month;
    this.year = year;
    this.date = date;
    this.label = label;
    this.tripLabel = tripLabel;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

  public Date getDate() {
    return date;
  }

  public String getLabel() {
    return label;
  }

  public String getTripLabel() {
    return tripLabel;
  }

  void setLabel(String label) {
    this.label = label;
  }

  void setTripLabel(String tripLabel){
    this.tripLabel = tripLabel;
  }

  @Override public String toString() {
    return "MonthDescriptor{"
        + "label='"
        + label
        + '\''
            + ", tripLabel="
            +tripLabel
        + ", month="
        + month
        + ", year="
        + year
        + '}';
  }
}
