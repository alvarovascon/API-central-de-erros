package com.central.main.suite;

import static org.assertj.core.api.Assertions.assertThat;

import com.central.main.entity.User;
import com.central.main.repository.UserRepository;
import com.central.main.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@ActiveProfiles("test")
public class UserServiceTest {
    private static final String EMAIL = "admin@admin.com";

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void whenSave() {
        User user = this.getUser();
        User result = this.userService.save(user);
//        this.(result);
    }

//    @Test
//    public void testFindByEmail(User email) throws Exception {
//        assertThat(userService).isNotNull();
//        assertThat(email.getEmail(), Matchers.equalTo("admin@admin.com"));
//
//    }


    private User getUser() {
        User user = new User();
        user.setEmail("admin@admin.com");
        return user;
    }

}
