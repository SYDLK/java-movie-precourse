package service;

import domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MemoryUserRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(new MemoryUserRepository());
    }

    @Test
    void join() {
        // given
        User user = new User(1L,"박기욱",100);

        // when
        userService.join(user);
        User find = userService.findUser(1L);


        // then
        assertThat(find.getName()).isEqualTo("박기욱");
        assertThat(find.getScore()).isEqualTo(100);
    }

    @Test
    void findUser() {
        // given
        User user0 = new User(2L,"박에드워드",100);


        // when
        userService.join(user0);


        // then
        assertThat(user0).isEqualTo(userService.findUser(1L));

    }

    @Test
    void findUsers() {
        // given
        userService.join(new User(3L,"박샤를로스2세",200));
        userService.join(new User(4L,"박차를로스4세",5000));


        // when
        List<User> users = userService.findUsers();

        // then
        assertThat(users).hasSize(2);
    }

    @Test
    void deleteUser() {
        //given
        userService.join(new User(5L, "박크스",300));

        //when
        userService.deleteUser(5L);
        User delete = userService.findUser(5L);

        //then
        assertThat(delete).isNull();
    }
}