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
import ru.trainee.adminpanel.data.model.ActionType;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.stringContainsInOrder;


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

        Action action = new Action(1L, user, ActionType.DELETE, "2018-12-16 00:00:00");
        actionRepository.save(action);

        System.out.println(action);

        List<Action> actionList = actionRepository.findAll();

        for (Action action1 : actionList)
            System.out.println(action1);

        int currentSize = actionList.size();

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

