package Task1;

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

    public void createTable() {
        String createTable = """
                CREATE TABLE IF NOT EXISTS calculatorResults (
                    id INT auto_increment primary key,
                    operation_type VARCHAR(20) NOT NULL,
                    left_operand DOUBLE NOT NULL,
                    right_operand DOUBLE NOT NULL,
                    operation CHAR(1) NOT NULL,
                    operation_result DOUBLE NOT NULL
                )
                """;
        try (Connection connection = DriverManager.getConnection(url, user, ps);
             Statement statement = connection.createStatement()) {
            statement.execute(createTable);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertDataBase(String[] operations) {
        String insertOperationRecord = """
                INSERT INTO calculatorResults(operation_type, left_operand, right_operand, operation, operation_result)
                VALUES (?, ?, ?, ?, ?)
                """;
        try (Connection connection = DriverManager.getConnection(url, user, ps);
             PreparedStatement preparedStatement = connection.prepareStatement(insertOperationRecord)) {
            for (List<Object> op : operations) {
                preparedStatement.setString(1, (String) op.get(0)); // operation_type
                preparedStatement.setDouble(2, (Double) op.get(1)); // left_operand
                preparedStatement.setDouble(3, (Double) op.get(2)); // right_operand
                preparedStatement.setString(4, String.valueOf(op.get(3))); // operation
                preparedStatement.setDouble(5, (Double) op.get(4)); // operation_result
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


}
