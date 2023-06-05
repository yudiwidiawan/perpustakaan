package parkee.test.perpustakaan.book.author;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import parkee.test.perpustakaan.domain.common.query.SearchRequest;

@RestController
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
@Tag(name = "Author", description = "Author management APIs")
@SecurityRequirement(name = "bearerAuth")
@Validated
public class AuthorController {
    private final AuthorService authorService;
    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping(value = "/search")
    public Page<Author> search(@RequestBody SearchRequest request) {
        return authorService.searchAuthor(request);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Author add(@Valid @RequestBody AuthorRequest request) throws Exception {
        return authorService.add(request);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Author edit(@Valid @RequestBody AuthorRequest request, @RequestParam Long id) throws Exception {
        return authorService.edit(request, id);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestParam Long id) throws Exception {
        if (authorService.delete(id)) {
            return ResponseEntity.ok("Author deleted!");
        }
        return new ResponseEntity<>("Author failed to delete!", HttpStatus.BAD_REQUEST);
    }
}
