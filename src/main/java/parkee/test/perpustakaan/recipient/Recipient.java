package parkee.test.perpustakaan.recipient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import parkee.test.perpustakaan.audit.Auditable;
import parkee.test.perpustakaan.book.BookBorrowers;
import parkee.test.perpustakaan.domain.common.Gender;

@Entity
@Getter
@Setter
public class Recipient extends Auditable<String> {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date birthDate;
    private Long homeNumber;
    private Long phoneNumber;
    @Email
    private String email;
    private String street;
    private String subDistrict;
    private String district;
    private String city;
    private String province;
    private String country;

    @Schema(name = "books", hidden = true)
    @OneToMany(mappedBy = "recipient")
    List<BookBorrowers> books = new ArrayList<>();
}
