package parkee.test.perpustakaan.book;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import parkee.test.perpustakaan.recipient.Recipient;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class BookBorrowers {
    @Id
    @GeneratedValue
    @Schema(hidden = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    Recipient recipient;

    Date borrowStartDate;

    Date borrowEndDate;

    @Schema(name = "dateReturned", hidden = true)
    Date dateReturned;

    @Schema(name = "status", example = "BORROWED|RETURNED", requiredMode = Schema.RequiredMode.NOT_REQUIRED )
    String status;

}
