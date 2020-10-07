package com.cookie.app.entities;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class CookieCounter {
  private String cookie;
  private AtomicInteger counter;

  public CookieCounter(String cookie, int count) {
    counter = new AtomicInteger(count);
    this.cookie = cookie;
  }
  public void incrementCount(int value){
    this.counter.addAndGet(value);
  }

  public AtomicInteger getCounter() {
    return counter;
  }

  public String getCookie() {
    return cookie;
  }

  public void setCookie(String cookie) {
    this.cookie = cookie;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CookieCounter that = (CookieCounter)o;
    return Objects.equals(cookie, that.cookie);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cookie);
  }

  @Override
  public String toString() {
    return "CookieCounter{" +
        "cookie='" + cookie + '\'' +
        ", counter=" + counter +
        '}';
  }
}
