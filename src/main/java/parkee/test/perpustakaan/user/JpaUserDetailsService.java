package parkee.test.perpustakaan.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Repository
public class JpaUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email).map(UserSecurity::new).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }

    

    
}
