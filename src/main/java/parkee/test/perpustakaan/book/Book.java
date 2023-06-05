package parkee.test.perpustakaan.book;


import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import parkee.test.perpustakaan.audit.Auditable;
import parkee.test.perpustakaan.book.author.Author;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class Book extends Auditable<String> {

    @Id
    @GeneratedValue
    @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
    @Schema(name = "title", example = "string", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;
    @Schema(name = "isbn", example = "string", requiredMode = Schema.RequiredMode.REQUIRED)
    private String isbn;
    @Schema(name = "summary", example = "string", requiredMode = Schema.RequiredMode.REQUIRED)
    private String summary;
    
    @ManyToOne
    @Schema(name = "author", hidden = true)
    private Author author;
    
    @OneToMany(mappedBy = "book")
    @Schema(name = "publishers", hidden = true)
    List<BookPublisher> bookPublishers = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    @Schema(name = "borrowers", hidden = true)
    List<BookBorrowers> bookBorrowers = new ArrayList<>();

}
