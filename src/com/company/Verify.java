package com.company;
import java.sql.*;

public class Verify {
    public static boolean authenticate(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdatabase", "root", "sqlOMNIVERSE24");

            //mysql command to select matching columns
            String prompt = "SELECT * FROM teacher WHERE username = ? AND pass_word = ?";
            preparedStatement = connection.prepareStatement(prompt);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            result = preparedStatement.executeQuery();

            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
