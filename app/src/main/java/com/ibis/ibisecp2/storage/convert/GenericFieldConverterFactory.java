package com.ibis.ibisecp2.storage.convert;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import nl.qbusict.cupboard.Cupboard;
import nl.qbusict.cupboard.convert.FieldConverter;
import nl.qbusict.cupboard.convert.FieldConverterFactory;

/**
 * Created by comp on 21.03.17.
 */

public class GenericFieldConverterFactory implements FieldConverterFactory {
    @Override
    public FieldConverter<?> create(Cupboard cupboard, Type type) {

        if (type instanceof ParameterizedType) {
            final ParameterizedType parameterizedType = (ParameterizedType) type;
            return new JsonParametrizedTypeConverter(parameterizedType);
        }

        return null;
    }
}
