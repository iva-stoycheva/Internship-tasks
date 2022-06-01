import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.sql.*;

public class Calculator {
    static final String DB_URL = "jdbc:mysql://localhost:3306/memory_infodb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "123456";

    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        double M, Mplus, Mminus;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement myStatement = connection.createStatement();
            MemoryService memoryService = new MemoryService();
            String mathExp1 = memoryService.input();
            String onlyOperatorsAndOperands = mathExp1.substring(0, mathExp1.indexOf("="));
            Expression expression = new ExpressionBuilder(onlyOperatorsAndOperands).build();
            if (mathExp1.substring(mathExp1.lastIndexOf("=") + 1).equals("M")) {
                M = expression.evaluate();
                String insertion = "INSERT INTO memory(M)" +
                        "VALUES (?)";
                PreparedStatement prest = connection.prepareStatement(insertion);
                prest.setDouble(1, M);
                prest.executeUpdate();
            }

            String mathExp2 = memoryService.input();
            for(int i=0; i < mathExp2.length(); i++) {
                if (mathExp2.charAt(i) == 'M') {
                    String replacement="";
                    String insertion = "SELECT M FROM memory";
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery(insertion);
                    while (rs.next()) {
                        replacement = mathExp2.replace("M", rs.getString(1));
                    }
                    if (mathExp2.substring(mathExp2.lastIndexOf("=") + 1).equals("M+")) {
                        String onlyOperatorsAndOperands2 = replacement.substring(0, replacement.indexOf("="));
                        Expression expression2 = new ExpressionBuilder(onlyOperatorsAndOperands2).build();
                        Mplus = expression2.evaluate();
                        String insertion2 = "INSERT INTO memory(Mplus)" +
                                "VALUES (?)";
                        PreparedStatement prest = connection.prepareStatement(insertion2);
                        prest.setDouble(1, Mplus);
                        prest.executeUpdate();
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
