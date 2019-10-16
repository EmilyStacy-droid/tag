package org.improving.tag.items;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class UniqueItemConverter implements AttributeConverter<UniqueItems, String> {
   // private static final String SEPARATOR = ",";
    @Override
    public String convertToDatabaseColumn(UniqueItems uniqueItem) {
      return uniqueItem.getName();
    }

    @Override
    public UniqueItems convertToEntityAttribute(String dataBaseString) {
        System.out.println(dataBaseString);
            var input=  Arrays.stream(UniqueItems.values())
                   .filter(item -> item.getName().equals(dataBaseString))
                   .findFirst()
                   .orElse(null);
        System.out.println("input: " + input);
        return input;
    }
}
