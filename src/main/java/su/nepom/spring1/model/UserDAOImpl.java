package su.nepom.spring1.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDAOImpl implements UserDAO {
    private static AtomicInteger nextId = new AtomicInteger();
    private final List<User> users = new ArrayList<>();

    {
        add(new User(0, "Evgeniy"));
        add(new User(0, "Elena"));
    }

    @Override
    public List<User> allUsers() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public void add(User user) {
        user.setId(nextId.getAndIncrement());
        users.add(user);
    }

    @Override
    public void delete(User user) {
        users.removeIf(u -> u.getId() == user.getId());
    }

    @Override
    public void update(User user) {
        for (int i = 0, alast = users.size(); i < alast; ++i)
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user);
                break;
            }
    }

    @Override
    public User getById(int id) {
        for (var u : users)
            if (u.getId() == id)
                return u;
        return null;
    }
}
