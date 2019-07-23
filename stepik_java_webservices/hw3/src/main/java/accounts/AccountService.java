package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.DBServiceImpl;
import dbService.dataSets.UsersDataSet;

import java.sql.SQLException;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {

//    private final Map<String, UserProfile> loginToProfile;
//    private final Map<String, UserProfile> sessionIdToProfile;
//
//    public AccountService() {
//        loginToProfile = new HashMap<>();
//        sessionIdToProfile = new HashMap<>();
//    }

    private final DBService dbService;

    public AccountService(DBService dbService){
        this.dbService = dbService;
    }

    public void addNewUser(String login, String password) {
//        loginToProfile.put(userProfile.getLogin(), userProfile);
        try {
            dbService.addUser(login, password);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public UsersDataSet getUserByLogin(String login)  {
//        return loginToProfile.get(login);
        try {
            return dbService.getUserByLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DBException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public UserProfile getUserBySessionId(String sessionId) {
//        return sessionIdToProfile.get(sessionId);
//    }
//
//    public void addSession(String sessionId, UserProfile userProfile) {
//        sessionIdToProfile.put(sessionId, userProfile);
//    }
//
//    public void deleteSession(String sessionId) {
//        sessionIdToProfile.remove(sessionId);
//    }
}
