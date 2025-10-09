package org.api.jpa_test.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {

    private final static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <Origin, Destination> Destination parseObject(Origin origin, Class<Destination> destinationClass) {
        return mapper.map(origin, destinationClass);
    }

    public static <Origin, Destination> List<Destination> parseListObjects(List<Origin> origin, Class<Destination> destinationClass) {

        List<Destination> destinationObjects = new ArrayList<>();

        for (Object object : origin) {
            destinationObjects.add(mapper.map(object, destinationClass));
        }

        return destinationObjects;
    }
}
