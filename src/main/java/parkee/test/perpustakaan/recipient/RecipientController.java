package parkee.test.perpustakaan.recipient;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import parkee.test.perpustakaan.domain.common.query.SearchRequest;

@RestController
@RequestMapping("/api/v1/recipient")
@RequiredArgsConstructor
@Tag(name = "Recipient", description = "Recipient management APIs")
@SecurityRequirement(name = "bearerAuth")
@Validated
public class RecipientController {
    private final RecipientService recipientService;

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping(value = "/search")
    public Page<Recipient> search(@RequestBody SearchRequest request) {
        return recipientService.searchRecipient(request);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Recipient add(@Valid @RequestBody RecipientRequest request) throws Exception {
        return recipientService.add(request);
    }
}
