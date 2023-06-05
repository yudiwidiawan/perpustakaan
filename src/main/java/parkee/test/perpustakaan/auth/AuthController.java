package parkee.test.perpustakaan.auth;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import parkee.test.perpustakaan.jwt.JwtUtils;
import parkee.test.perpustakaan.user.JpaUserDetailsService;
import parkee.test.perpustakaan.user.Role;
import parkee.test.perpustakaan.user.User;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Authentication APIs")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JpaUserDetailsService jpaUserDetailsService;
    private final AuthService authService;
    private final JwtUtils jwtUtils;

    @Value("${default.admin.firstname}")
    private String adminFirstname;
    @Value("${default.admin.lastname}")
    private String adminLastname;
    @Value("${default.admin.username}")
    private String adminUsername;
    @Value("${default.admin.password}")
    private String adminPassword;

    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticate(@RequestBody AuthRequest request, HttpServletResponse response) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword(), new ArrayList<>()));
            final UserDetails user = jpaUserDetailsService.loadUserByUsername(request.getEmail());
            if (user != null) {
                String jwt = jwtUtils.generateToken(user);
                return new ResponseEntity<>(Map.of("token", jwt), HttpStatus.OK);
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).body("" + e.getMessage());
        }
        return null;
    }

    @PostConstruct
    public void createAdmin() {
        User user = new User();
        user.setFirstname(adminFirstname);
        user.setLastname(adminLastname);
        user.setEmail(adminUsername);
        user.setPassword(adminPassword);
        user.setRole(Role.ROLE_ADMIN);
        authService.addAdmin(user);
    }
    
}
