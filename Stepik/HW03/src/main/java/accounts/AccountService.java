package accounts;

import dao.UserProfileDao;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private final Map<String, UserProfile> loginToProfile;
    private final Map<String, UserProfile> sessionIdToProfile;
    private final SessionFactory sessionFactory;

    public AccountService(SessionFactory sessionFactory) {
        loginToProfile = new HashMap<>();
        sessionIdToProfile = new HashMap<>();
        this.sessionFactory = sessionFactory;
    }

    public void addNewUser(UserProfile userProfile) {
        //loginToProfile.put(userProfile.getLogin(), userProfile);
        UserProfileDao userProfileDao = new UserProfileDao(sessionFactory);
        userProfileDao.create(userProfile);

    }

    public UserProfile getUserByLogin(String login) {
        UserProfileDao userProfileDao = new UserProfileDao(sessionFactory);
        UserProfile up = userProfileDao.read(login);
        if (up != null){
            return up;
        }
        else {
            System.out.println("ЮЗЕР НЕ НАЙДЕН");
            return null;
        }
    }

    public UserProfile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }

}
