package softuni.exam.models.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "borrowing_records")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordSeedRootDto implements Serializable {

    @XmlElement(name = "borrowing_record")
    private List<BorrowingRecordSeedDto> borrowingRecordSeedDtoList;

    public List<BorrowingRecordSeedDto> getBorrowingRecordSeedDtoList() {
        return borrowingRecordSeedDtoList;
    }

    public void setBorrowingRecordSeedDtoList(List<BorrowingRecordSeedDto> borrowingRecordSeedDtoList) {
        this.borrowingRecordSeedDtoList = borrowingRecordSeedDtoList;
    }
}
