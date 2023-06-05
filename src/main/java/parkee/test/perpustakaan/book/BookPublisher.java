package parkee.test.perpustakaan.book;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import parkee.test.perpustakaan.book.publisher.Publisher;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class BookPublisher {
    @Id
    @GeneratedValue
    @Schema(hidden =  true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    Publisher publisher;
}
