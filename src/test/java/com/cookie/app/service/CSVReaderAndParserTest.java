package com.cookie.app.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cookie.app.entities.CookieCounter;
import com.cookie.app.utils.DateTimeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CSVReaderAndParserTest {
  CSVReaderAndParser csvReaderAndParser;

  @BeforeEach
  public void init(){
    csvReaderAndParser = new CSVReaderAndParser();
  }

  @Test
  public void valid_file_expect_counters() throws Exception{
    Map<Date, List<CookieCounter>> counterMap =  csvReaderAndParser.readAndParseFile("src/test/resources/test.csv");
    Assertions.assertEquals(1, counterMap.size());
    Assertions.assertEquals(2, counterMap.get(DateTimeUtil.getDateTimeFormatterForInput().parse("2018-12-09")).size());
  }

  @Test
  public void invalid_file_extension_expect_exception() throws Exception{
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      csvReaderAndParser.readAndParseFile("src/test/resources/test");
    });
  }

  @Test
  public void without_header_expect_exception() throws Exception{
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      csvReaderAndParser.readAndParseFile("src/test/resources/withoutheader.csv");
    });
  }
}
