package parkee.test.perpustakaan.book.publisher;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import parkee.test.perpustakaan.validation.UniqueField;

@Getter
@Setter
@NoArgsConstructor
public class PublisherRequest {
    @NotBlank
    @UniqueField(name = "name", entity = Publisher.class)
    private String name;
    @NotBlank
    private String address;
}
