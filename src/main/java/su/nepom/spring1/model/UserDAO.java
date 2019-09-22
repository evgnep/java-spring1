package su.nepom.spring1.model;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();

    void add(User user);

    void delete(int id);

    void update(User user);

    User getById(int id);
}
