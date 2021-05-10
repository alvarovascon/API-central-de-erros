package com.central.main.suite;

import com.central.main.entity.User;
import com.central.main.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"/user_service_test.sql"})
@ActiveProfiles("test")
public class UserServiceTest {
    private static final String EMAIL = "admin@admin.com";
    private static final String PASSWORD = "1234567";

    @Autowired
    private UserService userService;

    public UserServiceTest() {
    }

    private User getUser() {
        User user = new User();
        user.setEmail("admin@admin.com");
        user.setPassword("1234567");
        return user;
    }

    private void assertUser(User result) {
        Assert.assertThat(result.getId(), Matchers.notNullValue());
        Assert.assertThat(result.getEmail(), Matchers.equalTo(EMAIL));
        Assert.assertThat(result.getPassword(), Matchers.equalTo(PASSWORD));
    }

    @Test
    @Transactional
    public void whenSave() {
        User user = this.getUser();
        User result = this.userService.save(user);
        this.assertUser(result);
    }

    @Test
    @Transactional
    public void whenFindById() {
        Optional<User> result = this.userService.findById(AbstractTest.UserIds.ONE);
        Assert.assertThat(result.isPresent(), Matchers.equalTo(true));
        this.assertUser(result.get());
    }

    @Test
    @Transactional
    public void whenFindByEmail() {
        Optional<User> result = this.userService.findByEmail(AbstractTest.UserEmails.EMAIL_ONE);
        Assert.assertThat(result.isPresent(), Matchers.equalTo(true));
        this.assertUser(result.get());
    }

    @Test
    @Transactional
    public void whenFindAll() {
        List<User> result = this.userService.findAll();
        Assert.assertThat(result, Matchers.hasSize(5));
    }

}
