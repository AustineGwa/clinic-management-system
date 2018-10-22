package sample.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by charloh on 10/17/2018.
 */
public class DbConnection {
    private static final  String CONN = "jdbc:sqlite:hms.sqlite";

    public static Connection getConnection()
            throws SQLException
    {
        try
        {
            Class.forName("org.sqlite.JDBC");

            return DriverManager.getConnection(CONN);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
