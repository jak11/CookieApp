package com.cookie.app.utils;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateTimeUtil {
  private DateTimeUtil() {
  }
  public static SimpleDateFormat getDateTimeFormatterForInput(){
    /*SimpleDateFormat format = new SimpleDateFormat(
        "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");*/
    SimpleDateFormat format = new SimpleDateFormat(
        "yyyy-MM-dd");
    format.setTimeZone(TimeZone.getTimeZone("UTC"));
    return format;
  }
}
