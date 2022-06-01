import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MemoryService {
    private String mathExpression;

    public void insertIntoM(Statement statement) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String insertation = "INSERT INTO memory(M)" +
                                "VALUES ()";
        statement.executeUpdate(insertation);
    }

    public String input() {
        System.out.println("Enter math expression to be calculated: ");
        mathExpression = "";
        Scanner scanner = new Scanner(System.in);
        mathExpression = scanner.next();
        return mathExpression;
    }
}
