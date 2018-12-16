package ru.trainee.adminpanel;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.trainee.adminpanel.data.model.User;
import ru.trainee.adminpanel.data.repository.UserRepository;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DatabaseUserTableTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void T1_checkAddUser(){
        User user = new User("Danya", "password");
        User resultUser = userRepository.save(user);

        System.out.println(resultUser);

        assertThat(resultUser, equalTo(user));
    }

    @Test
    public void T2_checkFyndById (){
        User user = new User("Danya");
        Optional<User> resultUser = userRepository.findById(user.getLogin());

        System.out.println(resultUser);

        assertThat(resultUser.isPresent(), is(true));
    }

}

