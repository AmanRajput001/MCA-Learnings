import java.sql.*;
import java.util.Scanner;

public class JDBCExample {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdb";
    static final String USER = "root";
    static final String PASSWORD = "root123";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Step 3: Check if the table exists, create it if not
            if (!tableExists(connection, "users")) {
                createTable(connection);
            }

            // Step 4: Get user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            // Step 5: Execute INSERT query
            statement = connection.createStatement();
            String insertQuery = "INSERT INTO users (username, email) VALUES ('" + username + "', '" + email + "')";
            int rowsAffected = statement.executeUpdate(insertQuery);

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }

            // Step 6: Display all data from the table
            displayUserData(connection);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 7: Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean tableExists(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null, tableName, new String[]{"TABLE"});
        return resultSet.next();
    }

    private static void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String createTableQuery = "CREATE TABLE users (id INT PRIMARY KEY AUTO_INCREMENT, "
                + "username VARCHAR(50), email VARCHAR(50))";
        statement.executeUpdate(createTableQuery);
        statement.close();
    }

    private static void displayUserData(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT id, username, email FROM users";
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // Display the results
        System.out.println("\nUser Data:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String email = resultSet.getString("email");

            System.out.println("ID: " + id + ", Username: " + username + ", Email: " + email);
        }

        resultSet.close();
        statement.close();
    }
}
