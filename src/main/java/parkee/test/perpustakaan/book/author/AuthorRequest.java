package parkee.test.perpustakaan.book.author;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import parkee.test.perpustakaan.validation.UniqueField;

@Getter
@Setter
@NoArgsConstructor
public class AuthorRequest {
    @NotBlank
    @UniqueField(name = "name", entity = Author.class)
    private String name;
    @NotBlank
    private String origin;
}
