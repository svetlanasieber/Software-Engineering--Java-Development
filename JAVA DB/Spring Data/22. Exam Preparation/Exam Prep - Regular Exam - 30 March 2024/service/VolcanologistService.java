package softuni.exam.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;


public interface VolcanologistService {

    boolean areImported();

    String readVolcanologistsFromFile() throws IOException;

	String importVolcanologists() throws IOException, JAXBException;

}
