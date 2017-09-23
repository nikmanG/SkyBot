package ml.duncte123.skybot.utils.db;

import ml.duncte123.skybot.utils.AirUtils;
import ml.duncte123.skybot.utils.ResourceUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseUtil {

    /**
     * This will connect to the database for us and return the connection
     * @return The connection to the database
     */
    public static Connection getConnection() {
        try {
            String dbHost = AirUtils.config.getString("sql.host");
            String user = AirUtils.config.getString("sql.username");
            String pass = AirUtils.config.getString("sql.password");
            String dbName = AirUtils.config.getString("sql.database");

            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://"+ dbHost +"/"+ dbName, user , pass);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This will give the database name that we specified in the config
     * @return the database name
     */
    public static String getDbName() {
        return AirUtils.config.getString("sql.database");
    }

    /**
     * This will check if the database is connected
     * @return true if we are connected
     */
    public static boolean checkDbConn() {
        return getConnection() != null;
    }

    public static boolean hasSettings() {
        try {
            String dbHost = AirUtils.config.getString("sql.host");
            String user = AirUtils.config.getString("sql.username");
            String pass = AirUtils.config.getString("sql.password");
            String dbName = AirUtils.config.getString("sql.database");

            return !dbHost.isEmpty() && !user.isEmpty() && !pass.isEmpty() && !dbName.isEmpty();
        }
        catch (Exception e) {
            return false;
        }
    }
}
