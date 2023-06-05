package parkee.test.perpustakaan.book.publisher;

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
@RequestMapping("/api/v1/publisher")
@RequiredArgsConstructor
@Tag(name = "Publisher", description = "Publisher management APIs")
@SecurityRequirement(name = "bearerAuth")
@Validated
public class PublisherController {

    private final PublisherService publisherService;
    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping(value = "/search")
    public Page<Publisher> search(@RequestBody SearchRequest request) {
        return publisherService.searchPublisher(request);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Publisher add(@Valid @RequestBody PublisherRequest request) throws Exception {
        return publisherService.add(request);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Publisher edit(@Valid @RequestBody PublisherRequest request, @RequestParam Long id) throws Exception {
        return publisherService.edit(request, id);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestParam Long id) throws Exception {
        if (publisherService.delete(id)) {
            return ResponseEntity.ok("Publisher deleted!");
        }
        return new ResponseEntity<>("Publisher failed to delete!", HttpStatus.BAD_REQUEST);
    }
}
