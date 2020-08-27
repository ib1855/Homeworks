package dao;

import accounts.UserProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserProfileDao implements DAO<UserProfile, String> {

    private final SessionFactory sessionFactory;

    public UserProfileDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void create(UserProfile userProfile) {
        try (final Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(userProfile);
            session.getTransaction().commit();
        }
    }

    @Override
    public UserProfile read(String login) {
        try (final Session session = sessionFactory.openSession()){
            session.beginTransaction();
            UserProfile result = session.get(UserProfile.class, login);
            if (result != null){
                return result;
            }
            else {
                return null;
            }
        }
    }

    @Override
    public void update(UserProfile userProfile) {

    }

    @Override
    public void delete(UserProfile userProfile) {

    }
}
