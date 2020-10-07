package com.cookie.app.utils;

import java.util.Arrays;
import java.util.List;

public class CookieAppConstants {
  private CookieAppConstants() {
  }
  public static List<String> SUPPORTED_FILE_EXTENSIONS = Arrays.asList("csv");
  public static List<String> COOKIE_FILE_VALID_HEADERS = Arrays.asList("cookie","timestamp");
}
