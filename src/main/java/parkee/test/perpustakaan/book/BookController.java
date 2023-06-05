package parkee.test.perpustakaan.book;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import parkee.test.perpustakaan.book.author.Author;
import parkee.test.perpustakaan.domain.common.query.SearchRequest;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
@Tag(name = "Book", description = "Book management APIs")
@SecurityRequirement(name = "bearerAuth")
@Validated
public class BookController {
    private final BookService bookService;
    
    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping(value = "/search")
    public Page<Book> search(@RequestBody SearchRequest request) {
        return bookService.searchBook(request);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book add(@Valid @RequestBody BookRequest request) throws Exception {
        return bookService.add(request);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book edit(@Valid @RequestBody BookRequest request, @RequestParam Long id) throws Exception {
        return bookService.edit(request, id);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestParam Long id) throws Exception {
        if (bookService.delete(id)) {
            return ResponseEntity.ok("Book deleted!");
        }
        return new ResponseEntity<>("Book failed to delete!", HttpStatus.BAD_REQUEST);
    }
    
    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping(value = "/{bookId}/author")
    public Book setAuthor(@PathVariable(value = "bookId") Long bookId, @RequestBody Author request) throws Exception {
        return bookService.setAuthorBook(bookId, request);
    }
    
    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping(value = "/publisher/add")
    public BookPublisher addPublisher(@RequestBody BookPublisher request) throws Exception {
        return bookService.addPublisherBook(request);
    }
    
    @PreAuthorize(value = "hasRole('ADMIN')")
    @DeleteMapping(value = "/publisher/{publisherBookId}/delete")
    public ResponseEntity<Object> deletePublisher(@PathVariable(value = "publisherBookId") Long publisherBookId) throws Exception {
        if (bookService.deletePublisherBook(publisherBookId)) {
            return ResponseEntity.ok("Book's publisher deleted!");
        }
        return new ResponseEntity<>("Book's publisher failed to delete!", HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping(value = "/{bookId}/borrow")
    public BookBorrowers addBorrower(@PathVariable(value = "bookId") Long bookId, @RequestBody BookBorrowers request) throws Exception {
        request.setStatus("BORROWED");
        return bookService.borrowBook(request);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping(value = "/{bookBorrowId}/return")
    public BookBorrowers returnBook(@PathVariable(value = "bookBorrowId") Long bookBorrowId) throws Exception {
        return bookService.returnBook(bookBorrowId);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping(value = "/borrow-statuses")
    public List<BookBorrowers> borrowStatuses() throws Exception {
        return bookService.getListBookBorrowers();
    }
}
