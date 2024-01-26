import java.sql.*;

public class CallableStatementExample {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
    static final String USER = "root";
    static final String PASSWORD = "root123";

    public static void main(String[] args) {
        try {
            // Call the stored procedure with different parameters
            callStoredProcedure(1);
            callStoredProcedure(2);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void callStoredProcedure(int userId) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Example: Call a stored procedure using CallableStatement with a parameter
            String callProcedure = "{CALL users(?)}";
            callableStatement = connection.prepareCall(callProcedure);
            
            // Set the parameter
            callableStatement.setInt(1, userId);
            
            // Execute the stored procedure
            boolean hasResults = callableStatement.execute();

            // Process the results
            if (hasResults) {
                resultSet = callableStatement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String email = resultSet.getString("email");

                    System.out.println("ID: " + id + ", Username: " + username + ", Email: " + email);
                }
            } else {
                System.out.println("No results returned from the stored procedure.");
            }

        } finally {
            // Close resources in the finally block
            try {
                if (resultSet != null) resultSet.close();
                if (callableStatement != null) callableStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
