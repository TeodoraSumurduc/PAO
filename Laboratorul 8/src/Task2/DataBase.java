package Task2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private final String url;
    private final String user;
    private final String ps;

    public DataBase(String url, String user, String ps) {
        this.url = url;
        this.user = user;
        this.ps = ps;
    }

    public List<String> print() {
        String selectSQL = """
                SELECT
                  id,
                  operation_type,
                  left_operand,
                  right_operand,
                  operation,
                  operation_result
                FROM calculatorResults
                """;
        List<String> results = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, ps);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            System.out.println("\nFrom database:\n");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String operationType = resultSet.getString("operation_type");
                double leftOperand = resultSet.getDouble("left_operand");
                double rightOperand = resultSet.getDouble("right_operand");
                char operation = resultSet.getString("operation").charAt(0);
                double result = resultSet.getDouble("operation_result");

                String resultStr = id + " | " + operationType + " | " + leftOperand + " | " + rightOperand + " | " + operation + " | " + result;
                System.out.println(resultStr);
                results.add(resultStr);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return results;
    }




}
