package com.cookie.app.service;

import java.util.List;

public interface ActiveCookieService {
  List<String> getActiveCookie(String date) throws Exception;
}
