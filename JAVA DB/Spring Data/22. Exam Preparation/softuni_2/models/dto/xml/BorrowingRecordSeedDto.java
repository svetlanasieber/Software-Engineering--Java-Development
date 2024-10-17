package softuni.exam.models.dto.xml;

import softuni.exam.util.LocalDateAdapter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;

@XmlRootElement(name = "borrowing_record")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordSeedDto implements Serializable {

    @XmlElement(name = "borrow_date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @NotNull
    private LocalDate borrowDate;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement(name = "return_date")
    @NotNull
    private LocalDate returnDate;

    @XmlElement(name = "book")
    private BookSeedXmlDto bookSeedXmlDto;

    @XmlElement(name = "member")
    private MemberSeedXmlDto memberSeedXmlDto;

    @XmlElement
    @Size(min = 3, max = 100)
    private String remarks;

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BookSeedXmlDto getBookSeedXmlDto() {
        return bookSeedXmlDto;
    }

    public void setBookSeedXmlDto(BookSeedXmlDto bookSeedXmlDto) {
        this.bookSeedXmlDto = bookSeedXmlDto;
    }

    public MemberSeedXmlDto getMemberSeedXmlDto() {
        return memberSeedXmlDto;
    }

    public void setMemberSeedXmlDto(MemberSeedXmlDto memberSeedXmlDto) {
        this.memberSeedXmlDto = memberSeedXmlDto;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
