package parkee.test.perpustakaan.book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorBookRequest {
    private Long id;
    private String name;
    private String origin;
}
