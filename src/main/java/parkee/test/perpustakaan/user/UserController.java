package parkee.test.perpustakaan.user;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import parkee.test.perpustakaan.domain.common.query.SearchRequest;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User", description = "User management APIs")
public class UserController {

    private final UserService userService;
    
    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping(value = "/search")
    public Page<User> search(@RequestBody SearchRequest request) {
        return userService.searchUser(request);
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping(value = "/add")
    public User add(@RequestBody UserRequest request) {
        return userService.add(request);
    }
}
