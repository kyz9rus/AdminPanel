package ru.trainee.adminpanel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.trainee.adminpanel.data.model.User;
import ru.trainee.adminpanel.data.repository.UserRepository;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Test
    public void redirectToLoginTest() throws Exception {
        this.mockMvc.perform(get("/admin"))
                .andDo(print())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void redirectToLoginTest2() throws Exception {
        this.mockMvc.perform(get("/api/admin/addBanner"))
                .andDo(print())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @WithUserDetails("Danya")
    @Test
    public void getAuthorityTest2() throws Exception {
        userRepository.save(new User("Danya", "$2a$10$7YDSJT6rsDN6Yc1CacLejetQCeFo8VH7sGMJfNE57gSUAbW5LmOwe"));

        this.mockMvc.perform(get("/admin"))
                .andDo(print())
                .andExpect(authenticated());
    }
}
