package com.cookie.app.validator;

import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.List;

import com.cookie.app.utils.CookieAppConstants;

public class FileHeaderValidator implements Validator<String[]>{
  @Override
  public void validate(String[] csvHeaders) {
    if(csvHeaders == null){
      throw new IllegalArgumentException("File headers are missing");
    }

    List<String> headers = Arrays.asList(csvHeaders);
    if(!(headers.size() == CookieAppConstants.COOKIE_FILE_VALID_HEADERS.size()
        && CookieAppConstants.COOKIE_FILE_VALID_HEADERS.containsAll(headers))){
      throw new IllegalArgumentException("File doesn't have valid headers or headers are missing. Supported headers "+ CookieAppConstants.COOKIE_FILE_VALID_HEADERS);
    }
  }
}
