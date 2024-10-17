package softuni.exam.models.dto.xml;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookSeedXmlDto implements Serializable {

    @XmlElement
    @Size(min = 3, max = 40)
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
