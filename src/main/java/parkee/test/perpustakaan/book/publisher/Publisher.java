package parkee.test.perpustakaan.book.publisher;

import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import parkee.test.perpustakaan.audit.Auditable;
import parkee.test.perpustakaan.book.BookPublisher;

@RequiredArgsConstructor
@Entity
@Getter
@Setter
public class Publisher extends Auditable<String> {
    @Id
    @GeneratedValue
    @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;
    @NotBlank
    @Schema(name = "name", example = "string", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @NotBlank
    @Schema(name = "address", example = "string", requiredMode = Schema.RequiredMode.REQUIRED)
    private String address;
    
    @Schema(name = "books", hidden = true)
    @OneToMany(mappedBy = "publisher")
    Set<BookPublisher> bookPublishers;
}
