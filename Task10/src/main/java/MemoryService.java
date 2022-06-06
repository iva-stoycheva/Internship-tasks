import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.sql.*;
import java.util.Scanner;

public class MemoryService {
    static final String DB_URL = "jdbc:mysql://localhost:3306/memory_infodb?useSSL=false&allowPublicKeyRetrieval=true" +
            "&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "123456";
    String mathExpression;

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

    public void insertIntoMplus(String mathExp) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        double Mplus;
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
                    Mplus = expression2.evaluate();
                    String insertion2 = "INSERT INTO memory(Mplus)" +
                            "VALUES (?)";
                    String insertion3 = "INSERT INTO memory(M)" +
                            "VALUES (?)";
                    PreparedStatement prest2 = connection.prepareStatement(insertion2);
                    PreparedStatement prest3 = connection.prepareStatement(insertion3);
                    prest2.setDouble(1, Mplus);
                    prest3.setDouble(1, rs.getDouble(1) + expression2.evaluate());
                    prest2.executeUpdate();
                    prest3.executeUpdate();
                }
            }
        }
    }

    public void insertIntoMminus(String mathExp) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        double Mminus;
        if (mathExp.substring(mathExp.lastIndexOf("=") + 1).equals("M-")) {
            String onlyOperatorsAndOperands3 = mathExp.substring(0, mathExp.indexOf("="));
            Expression expression3 = new ExpressionBuilder(onlyOperatorsAndOperands3).build();
            Mminus = expression3.evaluate();
            String insertion4 = "INSERT INTO memory(Mminus)" +
                    "VALUES (?)";
            String insertion5 = "INSERT INTO memory(M)" +
                    "VALUES (?)";
            String selection = "SELECT M FROM memory ORDER BY M DESC LIMIT 1";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(selection);
            PreparedStatement prest4 = connection.prepareStatement(insertion4);
            PreparedStatement prest5 = connection.prepareStatement(insertion5);
            prest4.setDouble(1, Mminus);
            prest4.executeUpdate();
            while (rs.next()) {
                prest5.setDouble(1, rs.getDouble(1) - expression3.evaluate());
                prest5.executeUpdate();
            }
        }
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
    }
}
