import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.sql.*;
import java.util.Scanner;

public class MemoryService {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/memory_infodb?useSSL=false&allowPublicKeyRetrieval=true" +
            "&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public String mathExpression;

    public String input() {
        System.out.println("Enter math expression to be calculated: ");
        mathExpression = "";
        Scanner scanner = new Scanner(System.in);
        mathExpression = scanner.next();
        return mathExpression;
    }

    public void insertIntoM(String mathExp) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
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
        connection.close();
    }

    public void insertResultFromCalculations(String mathExp) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        for (int i = 0; i < mathExp.length(); i++) {
            if (mathExp.charAt(i) == 'M') {
                String replacement = "";
                String selection = "SELECT M FROM memory";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(selection);
                if (rs.next()) {
                    replacement = mathExp.replace("M", rs.getString(1));
                }
                if (mathExp.substring(mathExp.lastIndexOf("=") + 1).equals("M+")) {
                    String onlyOperatorsAndOperands2 = replacement.substring(0, replacement.indexOf("="));
                    Expression expression2 = new ExpressionBuilder(onlyOperatorsAndOperands2).build();

                    String insertion3 = "INSERT INTO memory(M)" +
                            "VALUES (?)";
                    PreparedStatement prest3 = connection.prepareStatement(insertion3);
                    prest3.setDouble(1, rs.getDouble(1) + expression2.evaluate());
                    prest3.executeUpdate();
                }
                else if (mathExp.substring(mathExp.lastIndexOf("=") + 1).equals("M-")) {
                    String onlyOperatorsAndOperands3 = mathExp.substring(0, mathExp.indexOf("="));
                    Expression expression3 = new ExpressionBuilder(onlyOperatorsAndOperands3).build();
                    String insertion5 = "INSERT INTO memory(M)" +
                            "VALUES (?)";
                    String selection2 = "SELECT M FROM memory ORDER BY M DESC LIMIT 1";
                    ResultSet resultSet = st.executeQuery(selection2);
                    PreparedStatement prest5 = connection.prepareStatement(insertion5);
                    while (resultSet.next()) {
                        prest5.setDouble(1, resultSet.getDouble(1) - expression3.evaluate());
                        prest5.executeUpdate();
                    }
                }
            }
        }
        connection.close();
    }

    public void selectMemoryResult() throws SQLException, ClassNotFoundException{
        double result;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
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
