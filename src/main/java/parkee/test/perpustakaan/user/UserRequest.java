package parkee.test.perpustakaan.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
