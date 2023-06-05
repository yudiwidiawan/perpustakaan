package parkee.test.perpustakaan.user;


// import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
// import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "_user")
@RequiredArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    public String getPassword() {
        return password;
    }
    
    
}
