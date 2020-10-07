package com.cookie.app.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cookie.app.utils.DateTimeUtil;

public class DateValidator implements Validator<String> {
  @Override
  public void validate(String date) {
    if(date == null){
      throw new IllegalArgumentException("Date can not be null");
    }

    SimpleDateFormat simpleDateFormat = DateTimeUtil.getDateTimeFormatterForInput();
    try {
      simpleDateFormat.parse(date);
    } catch (ParseException e) {
      throw new IllegalArgumentException("Date is in incorrect format excpeted format" + simpleDateFormat);
    }
  }
}
