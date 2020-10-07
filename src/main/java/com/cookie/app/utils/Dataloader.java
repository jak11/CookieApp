package com.cookie.app.utils;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cookie.app.entities.CookieCountComparator;
import com.cookie.app.entities.CookieCounter;
import com.cookie.app.service.CSVReaderAndParser;
import com.cookie.app.service.ReaderAndParser;

public class Dataloader {

  private static Map<Date, List<String>> cookieMaxFrequncyMap = new HashMap<>();

  public static void loadCookieFrequencyByDate(String fileName) throws Exception {
    ReaderAndParser readerAndParser = new CSVReaderAndParser();
    Map<Date, List<CookieCounter>> allCookieCounterMap = readerAndParser.readAndParseFile(fileName);
    allCookieCounterMap.forEach((date, cookieCounters) -> {
      Collections.sort(cookieCounters, new CookieCountComparator());
      cookieMaxFrequncyMap.put(date, filterFrequentCookies(cookieCounters));
    });
  }

  private static List<String> filterFrequentCookies(List<CookieCounter> cookieCounters) {
    CookieCounter max = cookieCounters.get(0);
    return cookieCounters.stream().filter(cookieCounter -> cookieCounter.getCounter().get() == max.getCounter().get())
        .map(CookieCounter::getCookie)
        .collect(Collectors.toList());
  }

  public static List<String> getFrequentCookiesByDate(Date date) {
    return cookieMaxFrequncyMap.getOrDefault(date, new ArrayList<>());
  }
}
