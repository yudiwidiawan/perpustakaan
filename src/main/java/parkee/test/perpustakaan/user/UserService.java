package parkee.test.perpustakaan.user;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import parkee.test.perpustakaan.domain.common.query.SearchRequest;
import parkee.test.perpustakaan.domain.common.query.SearchSpecification;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public Page<User> searchUser(SearchRequest request) {
        SearchSpecification<User> specification = new SearchSpecification<>(request);
        Pageable pageable = SearchSpecification.getPageable(request.getPage(), request.getSize());
        return repository.findAll(specification, pageable);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User add(UserRequest request) {
        User newUser = new User();
        newUser.setFirstname(request.getFirstname());
        newUser.setLastname(request.getLastname());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        newUser.setRole(Role.ROLE_USER);
        return repository.save(newUser);
    }
    
}
