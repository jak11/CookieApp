package com.cookie.app.validator;

import com.cookie.app.utils.CookieAppConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

public class FileHeaderValidatorTest {
  Validator<String[]> validator = new FileHeaderValidator();
  @Test
  public void valid_headers_expect_passed(){
    validator.validate(expectedHeaders());
  }

  @Test
  public void invalid_header_expect_exception(){
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      validator.validate(new String[]{"test.abcd"});
    });
  }

  @Test
  public void null_header_expect_exception(){
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      validator.validate(null);
    });
  }

  private String[] expectedHeaders(){
    String[] itemsArray = new String[CookieAppConstants.SUPPORTED_FILE_EXTENSIONS.size()];
    return CookieAppConstants.COOKIE_FILE_VALID_HEADERS.toArray(itemsArray);
  }
}
