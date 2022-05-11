package com.mylib;

import org.modelmapper.ModelMapper;

public class ObjectUtils {

  private ObjectUtils() {
    throw new IllegalStateException("Utility class");
  }

  private static final ModelMapper mapper = new ModelMapper();

  public static <R> R convert(Object source, Class<R> typeDestination) {
    return mapper.map(source, typeDestination);
  }

  public static <R> void convert(Object source, R destination) {
    mapper.map(source, destination);
  }
}
