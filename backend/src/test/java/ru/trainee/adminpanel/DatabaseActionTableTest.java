package ru.trainee.adminpanel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.trainee.adminpanel.data.model.Action;
import ru.trainee.adminpanel.data.model.User;
import ru.trainee.adminpanel.data.repository.ActionRepository;
import ru.trainee.adminpanel.data.repository.UserRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class DatabaseActionTableTest {

    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void AddOperationTest() throws Exception {
        int initialSize = actionRepository.findAll().size();

        User user = createUser();

        Action action = new Action(1L, user, "DELETE", "2018-12-16 00:00:00");
        actionRepository.save(action);

        int currentSize = actionRepository.findAll().size();

        assertThat(currentSize, is(initialSize + 1));
    }

    @Test
    public void FindAllOperationTest() throws Exception {
        assertThat(actionRepository.findAll().size(), is(1));
    }


    public User createUser() throws Exception {
        System.out.println("Creating user...");
        return userRepository.save(new User("Danya", "password"));
    }

}

