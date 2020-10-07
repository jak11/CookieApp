package com.cookie.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cookie.app.dao.CookieDao;
import com.cookie.app.utils.Dataloader;
import com.cookie.app.utils.DateTimeUtil;
import com.cookie.app.validator.DateValidator;
import com.cookie.app.validator.Validator;

public class ActiveCookieByFrequency implements ActiveCookieService{
  private final Validator<String> dateStringValidator;
  private final CookieDao cookieDao;
  public ActiveCookieByFrequency(){
    dateStringValidator = new DateValidator();
    cookieDao = new CookieDao();
  }

  @Override
  public List<String> getActiveCookie(String date) throws ParseException {
    dateStringValidator.validate(date);
    SimpleDateFormat simpleDateFormat = DateTimeUtil.getDateTimeFormatterForInput();
    return cookieDao.getFrequentCookiesByDate(simpleDateFormat.parse(date));
  }
}
