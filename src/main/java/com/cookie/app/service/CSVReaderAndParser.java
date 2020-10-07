package com.cookie.app.service;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cookie.app.entities.CookieCounter;
import com.cookie.app.entities.InputRecord;
import com.cookie.app.utils.DateTimeUtil;
import com.cookie.app.validator.FileExtensionValidator;
import com.cookie.app.validator.FileHeaderValidator;
import com.cookie.app.validator.Validator;
import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CSVReaderAndParser implements ReaderAndParser {
  private static final Logger log = LoggerFactory.getLogger(CSVReaderAndParser.class);
  private Validator<String> fileExtensionValidator;
  private Validator<String[]> fileHeaderValidator;

  public CSVReaderAndParser() {
    this.fileExtensionValidator = new FileExtensionValidator();
    this.fileHeaderValidator = new FileHeaderValidator();
  }

  @Override
  public Map<Date, List<CookieCounter>> readAndParseFile(String filename) throws Exception {
    //validations
    fileExtensionValidator.validate(filename);
    CSVReader reader = new CSVReader(new FileReader(filename));
    String[] headers = reader.readNext();
    fileHeaderValidator.validate(headers);

    Map<Date, List<CookieCounter>> counterMap = new HashMap<>();
    SimpleDateFormat format = DateTimeUtil.getDateTimeFormatterForInput();

    String[] nextLine;
    while ((nextLine = reader.readNext()) != null) {
      if (nextLine.length == 2) {
        InputRecord inputRecord = null;
        try {
          inputRecord = new InputRecord(nextLine[0], format.parse(nextLine[1]));
          populateCounterMap(counterMap, inputRecord);
        } catch (ParseException e) {
          log.warn("Input record is invalid {}", inputRecord);
          continue;
        }

      }
    }
    return counterMap;
  }

  private void populateCounterMap(Map<Date, List<CookieCounter>> counterMap, InputRecord inputRecord) {
    CookieCounter cookieCounter = new CookieCounter(inputRecord.getCookie(), 1);
    if (!counterMap.containsKey(inputRecord.getTimestamp())) {
      List<CookieCounter> sortedSet = new ArrayList();
      sortedSet.add(cookieCounter);
      counterMap.put(inputRecord.getTimestamp(), sortedSet);
    } else {
      List<CookieCounter> cookieCounterPriorityQueue = counterMap.get(inputRecord.getTimestamp());
      if (cookieCounterPriorityQueue.contains(cookieCounter)) {
        int currentCounterIndex = cookieCounterPriorityQueue.indexOf(cookieCounter);
        CookieCounter currntCookieCounter = cookieCounterPriorityQueue.get(currentCounterIndex);
        currntCookieCounter.incrementCount(1);
      } else {
        cookieCounterPriorityQueue.add(cookieCounter);
      }
    }
  }
}
