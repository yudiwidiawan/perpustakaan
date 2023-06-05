package parkee.test.perpustakaan.book.author;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import parkee.test.perpustakaan.domain.common.query.SearchRequest;
import parkee.test.perpustakaan.domain.common.query.SearchSpecification;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    public Page<Author> searchAuthor(SearchRequest request) {
        SearchSpecification<Author> specification = new SearchSpecification<>(request);
        Pageable pageable = SearchSpecification.getPageable(request.getPage(), request.getSize());
        return authorRepository.findAll(specification, pageable);
    }

    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public Author add(AuthorRequest request) {
        Author newAuthor = new Author();
        newAuthor.setName(request.getName());
        newAuthor.setOrigin(request.getOrigin());
        return authorRepository.save(newAuthor);
    }

    public Author edit(AuthorRequest request, Long id) {
        Author author = authorRepository.findById(id).get();
        author.setName(request.getName());
        author.setOrigin(request.getOrigin());
        return authorRepository.save(author);
    }

    public Boolean delete(Long id) {
        try {
            Author author = authorRepository.findById(id).get();
            authorRepository.deleteById(author.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
