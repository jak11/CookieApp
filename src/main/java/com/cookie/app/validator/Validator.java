package com.cookie.app.validator;

public interface Validator<T> {
  void validate(T t);
}
