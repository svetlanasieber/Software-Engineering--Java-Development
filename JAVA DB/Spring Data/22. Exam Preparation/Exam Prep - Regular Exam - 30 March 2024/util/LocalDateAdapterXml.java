package softuni.exam.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Component
public class LocalDateAdapterXml extends XmlAdapter<String, LocalDate> {

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public String marshal(LocalDate dateTime) throws Exception {
        return dateTime.format(dateFormat);
    }

    @Override
    public LocalDate unmarshal(String dateTime) throws Exception {
        return LocalDate.parse(dateTime, dateFormat);
    }
}
