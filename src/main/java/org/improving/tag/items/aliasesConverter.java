package org.improving.tag.items;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class aliasesConverter implements AttributeConverter<ListOfStrings, String> {

    @Override
    public String convertToDatabaseColumn(ListOfStrings strings) {
        return strings.stream().forEach(s->s.split(","));
    }

    @Override
    public ListOfStrings convertToEntityAttribute(String s) {
        ListOfStrings strings = new ListOfStrings();
        return strings.addAll(Arrays.asList(s.replace(" ", "").split(",")));

    }
}
