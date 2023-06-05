package parkee.test.perpustakaan.book.publisher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import parkee.test.perpustakaan.domain.common.query.SearchRequest;
import parkee.test.perpustakaan.domain.common.query.SearchSpecification;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;
    public Page<Publisher> searchPublisher(SearchRequest request) {
        SearchSpecification<Publisher> specification = new SearchSpecification<>(request);
        Pageable pageable = SearchSpecification.getPageable(request.getPage(), request.getSize());
        return publisherRepository.findAll(specification, pageable);
    }

    public Publisher add(PublisherRequest request) {
        Publisher newPublisher = new Publisher();
        newPublisher.setName(request.getName());
        newPublisher.setAddress(request.getAddress());
        return publisherRepository.save(newPublisher);
    }

    public Publisher edit(PublisherRequest request, Long id) {
        Publisher publisher = publisherRepository.findById(id).get();
        publisher.setName(request.getName());
        publisher.setAddress(request.getAddress());
        return publisherRepository.save(publisher);
    }

    public Boolean delete(Long id) {
        try {
            Publisher publisher = publisherRepository.findById(id).get();
            publisherRepository.deleteById(publisher.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
