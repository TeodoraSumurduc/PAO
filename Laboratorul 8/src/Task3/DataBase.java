package Task3;

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

    public void delete(String type) {
        String deleteSQL = """
                DELETE FROM calculatorResults
                WHERE lower(operation_type) = lower(?)
                """;
        try (Connection connection = DriverManager.getConnection(url, user, ps);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, type);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


}
