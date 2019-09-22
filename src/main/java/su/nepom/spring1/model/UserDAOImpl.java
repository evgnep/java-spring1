package su.nepom.spring1.model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<User> allUsers() {
        var s = sessionFactory.getCurrentSession();
        return s.createQuery("from User").list();
    }

    @Override
    @Transactional
    public void add(User user) {
        var s = sessionFactory.getCurrentSession();
        s.persist(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        var s = sessionFactory.getCurrentSession();
        var q = s.createQuery("delete " + User.class.getName() + " where id = :id").setParameter("id", id);
        q.executeUpdate();
    }

    @Override
    @Transactional
    public void update(User user) {
        var s = sessionFactory.getCurrentSession();
        s.update(user);
    }

    @Override
    @Transactional
    public User getById(int id) {
        var s = sessionFactory.getCurrentSession();
        return s.get(User.class, id);
    }
}
