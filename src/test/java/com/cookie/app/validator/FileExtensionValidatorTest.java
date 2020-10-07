package com.cookie.app.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileExtensionValidatorTest {
  Validator<String> validator = new FileExtensionValidator();
  @Test
  public void valid_extension_expect_passed(){
    validator.validate("test.csv");
  }

  @Test
  public void invalid_extension_expect_exception(){
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      validator.validate("test.abcd");
    });
  }
}
