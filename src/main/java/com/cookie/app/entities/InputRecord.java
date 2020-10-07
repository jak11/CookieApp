package com.cookie.app.entities;

import java.util.Date;
import java.util.Objects;

public class InputRecord {
  private String cookie;
  private Date timestamp;

  public InputRecord(String cookie, Date timestamp) {
    this.cookie = cookie;
    this.timestamp = timestamp;
  }

  public String getCookie() {
    return cookie;
  }

  public void setCookie(String cookie) {
    this.cookie = cookie;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InputRecord that = (InputRecord)o;
    return Objects.equals(cookie, that.cookie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cookie);
  }

  @Override
  public String toString() {
    return "InputRecord{" +
        "cookie='" + cookie + '\'' +
        ", timestamp=" + timestamp +
        '}';
  }
}
