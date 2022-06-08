import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.sql.*;
import java.util.Scanner;
public class MemoryService {
    public static final String URL = "jdbc:h2:~/memory";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public String mathExpression;

    public static Connection connection;
    public static Statement statement;

    static {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String input() {
        System.out.println("Enter math expression to be calculated: ");
        mathExpression = "";
        Scanner scanner = new Scanner(System.in);
        mathExpression = scanner.next();
        return mathExpression;
    }

    public void insertIntoM(String mathExp) throws SQLException{
        double M;
        String onlyOperatorsAndOperands = mathExp.substring(0, mathExp.indexOf("="));
        Expression expression = new ExpressionBuilder(onlyOperatorsAndOperands).build();
        if (mathExp.substring(mathExp.lastIndexOf("=") + 1).equals("M")) {
            M = expression.evaluate();
            String insertion = "INSERT INTO memory(M)" +
                    "VALUES (?)";
            PreparedStatement prest = connection.prepareStatement(insertion);
            prest.setDouble(1, M);
            prest.executeUpdate();
        }
    }

    public void insertResultFromCalculationsMplus(String mathExp) throws SQLException{
        String leftSide = mathExp.substring(0, mathExp.indexOf("="));
        String rightSide = mathExp.substring(mathExp.indexOf("="));
        if (leftSide.contains("M")) {
            String replacement = "";
            String selection = "SELECT M FROM memory";
            ResultSet rs = statement.executeQuery(selection);
            if (rs.next()) {
                replacement = mathExp.replace("M", rs.getString(1));
            }
            if (rightSide.contains("M+")) {
                String onlyOperatorsAndOperands2 = replacement.substring(0, replacement.indexOf("="));
                Expression expression2 = new ExpressionBuilder(onlyOperatorsAndOperands2).build();
                String insertion2 = "INSERT INTO memory(M)" +
                        "VALUES (?)";
                PreparedStatement prest2 = connection.prepareStatement(insertion2);
                prest2.setDouble(1, rs.getDouble(1) + expression2.evaluate());
                prest2.executeUpdate();
            }
        }
    }

    public void insertResultFromCalculationsMminus(String mathExp) throws SQLException{
        String rightSide = mathExp.substring(mathExp.indexOf("="));
        if (rightSide.contains("M-")) {
            String onlyOperatorsAndOperands3 = mathExp.substring(0, mathExp.indexOf("="));
            Expression expression3 = new ExpressionBuilder(onlyOperatorsAndOperands3).build();
            String selection = "SELECT M FROM memory ORDER BY id DESC LIMIT 1";
            String insertion3 = "INSERT INTO memory(M)" +
                    "VALUES (?)";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(selection);
            PreparedStatement prest3 = connection.prepareStatement(insertion3);
            while (rs.next()) {
                prest3.setDouble(1, rs.getDouble(1) - expression3.evaluate());
                prest3.executeUpdate();
            }
        }
    }

    public void selectMemoryResult() throws SQLException{
        double result;
        String selection = "SELECT M FROM memory ORDER BY id DESC LIMIT 1";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(selection);
        while (rs.next()) {
           result = rs.getDouble(1);
           System.out.println(result);
        }
        connection.close();
    }
}
