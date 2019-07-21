package utils;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    private static final Logger logger = Logger.getLogger(DbConnector.class);
    private static final String dbUrl = "jdbc:mysql://localhost:3306/shop";
    private static final String login = "root";
    private static final String password = "root";

    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(dbUrl, login, password);
        } catch (SQLException e) {
            logger.error("Problem with connection to DB : ", e);
        } catch (ClassNotFoundException e) {
            logger.error("Problem with connecting to DB driver : ", e);
        }
        return null;
    }
}
