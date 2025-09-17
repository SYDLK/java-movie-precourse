package repository;

import domain.User;

import java.util.List;

public interface UserRepository {
    void save(User user);
    User findById(Long id);
    List<User> findAll();
    void delete(Long id);
}
