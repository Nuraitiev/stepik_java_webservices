package dbService;

import dbService.dataSets.UsersDataSet;

import java.sql.SQLException;

public interface DBService {
     UsersDataSet getUser(long id) throws DBException;

    long addUser(String login, String password) throws DBException;

     void cleanUp() throws DBException;

     void printConnectInfo();

     UsersDataSet getUserByLogin(String login) throws SQLException, DBException;
}
