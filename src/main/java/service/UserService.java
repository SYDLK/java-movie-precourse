package service;

import domain.User;

import java.util.List;

public interface UserService {
    void join(User user);
    User findUser(Long id);
    List<User> findUsers();
    void deleteUser(Long id);


}
