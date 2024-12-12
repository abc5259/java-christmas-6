package christmas.converter;

import christmas.domain.Date;

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        int date = new StringToIntConverter().convert(source);
        return new Date(date);
    }
}
