package parkee.test.perpustakaan.recipient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import parkee.test.perpustakaan.domain.common.query.SearchRequest;
import parkee.test.perpustakaan.domain.common.query.SearchSpecification;

@Service
@RequiredArgsConstructor
public class RecipientService {
    private final RecipientRepository recipientRepository;

    public Page<Recipient> searchRecipient(SearchRequest request) {
        SearchSpecification<Recipient> specification = new SearchSpecification<>(request);
        Pageable pageable = SearchSpecification.getPageable(request.getPage(), request.getSize());
        return recipientRepository.findAll(specification, pageable);
    }

    public Recipient add(RecipientRequest request) {
        Recipient recipient = new Recipient();
        recipient.setFirstName(request.getFirstName());
        recipient.setMiddleName(request.getMiddleName());
        recipient.setLastName(request.getLastName());
        recipient.setGender(request.getGender());
        recipient.setBirthDate(request.getBirthDate());
        recipient.setStreet(request.getStreet());
        recipient.setSubDistrict(request.getSubDistrict());
        recipient.setDistrict(request.getDistrict());
        recipient.setCity(request.getStreet());
        recipient.setProvince(request.getProvince());
        recipient.setCountry(request.getCountry());
        recipient.setPhoneNumber(request.getPhoneNumber());
        recipient.setEmail(request.getEmail());
        return recipientRepository.save(recipient);
    }

}
