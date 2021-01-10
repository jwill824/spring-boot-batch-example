
package io.thingstead.simple.transaction.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String date;
  private String recordedAt;
  private String scheduledFor;
  private String amount;
  private String activity;
  private String pending;
  private String rawDescription;
  private String description;
  private String categoryFolder;
  private String category;
  private String streetAddress;
  private String city;
  private String state;
  private String zip;
  private String latitude;
  private String longitude;
  private String memo;

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(final String date) {
    this.date = date;
  }

  public String getRecordedAt() {
    return recordedAt;
  }

  public void setRecordedAt(final String recordedAt) {
    this.recordedAt = recordedAt;
  }

  public String getScheduledFor() {
    return scheduledFor;
  }

  public void setScheduledFor(final String scheduledFor) {
    this.scheduledFor = scheduledFor;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(final String amount) {
    this.amount = amount;
  }

  public String getActivity() {
    return activity;
  }

  public void setActivity(final String activity) {
    this.activity = activity;
  }

  public String getPending() {
    return pending;
  }

  public void setPending(final String pending) {
    this.pending = pending;
  }

  public String getRawDescription() {
    return rawDescription;
  }

  public void setRawDescription(final String rawDescription) {
    this.rawDescription = rawDescription;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public String getCategoryFolder() {
    return categoryFolder;
  }

  public void setCategoryFolder(final String categoryFolder) {
    this.categoryFolder = categoryFolder;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(final String category) {
    this.category = category;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(final String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public String getCity() {
    return city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(final String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(final String zip) {
    this.zip = zip;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(final String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(final String longitude) {
    this.longitude = longitude;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(final String memo) {
    this.memo = memo;
  }
}
