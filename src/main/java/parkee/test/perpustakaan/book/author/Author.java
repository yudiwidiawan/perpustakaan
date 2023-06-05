package parkee.test.perpustakaan.book.author;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import parkee.test.perpustakaan.book.Book;

@Getter
@Setter
@Entity
public class Author {
    @Id
    @GeneratedValue
    @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
    @Schema(name = "name", example = "string", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(name = "origin", example = "string", requiredMode = Schema.RequiredMode.REQUIRED)
    private String origin;

    @OneToMany(mappedBy = "author")
    @Schema(name = "Author Books", hidden = true)
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        this.books.add(book);
    }
}
