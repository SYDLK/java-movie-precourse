package repository;

import domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryUserRepository implements UserRepository {
    private static Map<Long, User> store = new HashMap<>();

    @Override
    public void save(User user){
        store.put(user.getId(), user);
    }

    @Override
    public User findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<User> findAll(){
        return new ArrayList<>(store.values());
    }
    @Override
    public void delete(Long id){
        store.remove(id);
    }
}
