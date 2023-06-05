package parkee.test.perpustakaan.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookRequest {
    private String title;
    private String isbn;
    private String summary;
}
