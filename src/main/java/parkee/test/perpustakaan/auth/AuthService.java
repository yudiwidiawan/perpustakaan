package parkee.test.perpustakaan.auth;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import parkee.test.perpustakaan.user.Role;
import parkee.test.perpustakaan.user.User;
import parkee.test.perpustakaan.user.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;

    public Optional<User> getAdmin() {
        return repository.findByRole(Role.ROLE_ADMIN);
    }

    public Optional<User> addUser(RegisterRequest user) {
        User newUser = new User();
        newUser.setFirstname(user.getFirstname());
        newUser.setLastname(user.getLastname());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        newUser.setRole(Role.ROLE_USER);
        return Optional.of(repository.save(newUser));
    }
    public Optional<User> addAdmin(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return Optional.of(repository.save(user));
    }

    
}
