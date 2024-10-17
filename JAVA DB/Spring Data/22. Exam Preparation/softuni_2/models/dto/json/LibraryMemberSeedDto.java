package softuni.exam.models.dto.json;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class LibraryMemberSeedDto implements Serializable {
    @Size(min = 2, max = 30)
    @NotNull
    private String firstName;
    @Size(min = 2, max = 30)
    private String lastName;
    @Size(min = 2, max = 40)
    private String address;
    @Size(min = 2, max = 20)
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
