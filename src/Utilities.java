import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utilities {
    public static Connection getConnection() {

        String dbURL = "jdbc:mysql://localhost:3306/car_rental";
        String username = "root";
        String password = "12345";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException ex) {
            System.out.println("Connection failed: " + ex.getMessage());
        }

        return connection;
    }

}
