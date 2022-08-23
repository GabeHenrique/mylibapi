package com.mylib;

import org.modelmapper.ModelMapper;

public class ObjectUtils {

    private static final ModelMapper mapper = new ModelMapper();

    private ObjectUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <R> R convert(Object source, Class<R> typeDestination) {
        return mapper.map(source, typeDestination);
    }

}
