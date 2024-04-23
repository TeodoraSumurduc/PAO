package Task4;

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

    public void deleteDuplicates() {
        String deleteSQL = """
                DELETE cr1
                FROM calculatorResults cr1,
                     calculatorResults cr2
                WHERE cr1.id > cr2.id
                  AND cr1.operation_type = cr2.operation_type
                  AND cr1.left_operand = cr2.left_operand
                  AND cr1.right_operand = cr2.right_operand
                  AND cr1.operation = cr2.operation
                  AND cr1.operation_result = cr2.operation_result
                """;
        try (Connection connection = DriverManager.getConnection(url, user, ps);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
