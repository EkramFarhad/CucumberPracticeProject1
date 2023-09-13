package DataBaseTest;

import java.sql.*;

public class DBT1 {
    public static void main(String[] args) {
        /* to build the connection with the database we need 3 thins, URL, username, password */
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        // we try to establish the connection to the database.

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("My test connection is created");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("select Firstname, lastName from person");

            result.next();
            String fName = result.getString("FirstName");
            String lName = result.getString("lastName");

            System.out.println(fName + " " + lName);

            result.next();
            fName = result.getString("FirstName");
            lName = result.getString("lastName");
            System.out.println(fName + " " + lName);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
