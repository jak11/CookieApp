package com.cookie.app.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.cookie.app.entities.CookieCounter;

public interface ReaderAndParser {
  /**
   * Method parses the prvided file and generate the Cookie count per day.
   * @param filename
   * @return
   * @throws Exception
   */
  Map<Date, List<CookieCounter>> readAndParseFile(String filename) throws Exception;
}
