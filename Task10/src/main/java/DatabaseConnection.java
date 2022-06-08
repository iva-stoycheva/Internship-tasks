import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    static {
        String URL = "jdbc:h2:~/memory";
        String USER = "root";
        String PASSWORD = "123456";
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return connection;
    }
}
