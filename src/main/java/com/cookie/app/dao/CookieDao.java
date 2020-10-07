package com.cookie.app.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cookie.app.utils.Dataloader;

public class CookieDao {
  public List<String> getFrequentCookiesByDate(Date date) {
    return Dataloader.getFrequentCookiesByDate(date);
  }
}
