package com.cookie.app.validator;

public class FileExtensionValidator implements Validator<String>{
  @Override
  public void validate(String filename) {
    if(!filename.endsWith(".csv")){
      throw new IllegalArgumentException("File extension not supported. CSV is only supported format");
    }
  }
}
