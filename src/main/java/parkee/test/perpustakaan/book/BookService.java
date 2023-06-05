package parkee.test.perpustakaan.book;



import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import parkee.test.perpustakaan.book.author.Author;
import parkee.test.perpustakaan.domain.common.query.SearchRequest;
import parkee.test.perpustakaan.domain.common.query.SearchSpecification;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookPublisherRepository bookPublisherRepository;
    private final BookBorrowerRepository bookBorrowerRepository;
    public Page<Book> searchBook(SearchRequest request) {
        SearchSpecification<Book> specification = new SearchSpecification<>(request);
        Pageable pageable = SearchSpecification.getPageable(request.getPage(), request.getSize());
        return bookRepository.findAll(specification, pageable);
    }

    public Book add(BookRequest request) {
        Book newBook = new Book();
        newBook.setTitle(request.getTitle());
        newBook.setIsbn(request.getIsbn());
        newBook.setSummary(request.getSummary());
        return bookRepository.save(newBook);
    }

    public Book edit(BookRequest request, Long id) {
        Book book = bookRepository.findById(id).get();
        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setSummary(request.getSummary());
        return bookRepository.save(book);
    }

    public Boolean delete(Long id) {
        try {
            Book book = bookRepository.findById(id).get();
            bookRepository.deleteById(book.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Book setAuthorBook(Long bookId, Author request) {
        Book book = bookRepository.findById(bookId).map((bk) -> {
            bk.setAuthor(request);
            return bookRepository.save(bk);
        }).orElseThrow();
        return book;
    }

    public BookPublisher addPublisherBook(BookPublisher request) {
        return bookPublisherRepository.save(request);
    }

    public boolean deletePublisherBook(Long id) {
        try {
            bookPublisherRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public BookBorrowers borrowBook(BookBorrowers request) {
        return bookBorrowerRepository.save(request);
    }

    public BookBorrowers returnBook(Long id) {
        BookBorrowers bookBorrowers = bookBorrowerRepository.findById(id).get();
        bookBorrowers.setStatus("RETURNED");
        bookBorrowers.setDateReturned(new Date(System.currentTimeMillis()));
        return bookBorrowerRepository.save(bookBorrowers);
    }

    public List<BookBorrowers> getListBookBorrowers() {
        return bookBorrowerRepository.findAll();
    }
}
