package DataBaseTest;

import java.sql.*;

public class DBT2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("select firstname, lastname, age, city" +
                    " from person where city is not null");
            ResultSetMetaData metaData = result.getMetaData();

            // this loop iterate through the header of the table
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i);
                System.out.print(columnName + " - ");
            }
            System.out.println();

            // this while loop iterate thr ough each row of the table
            while (result.next()) {

                // this for loop iterate through the column of a table
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String value = result.getString(metaData.getColumnName(i));
                    System.out.print(value + " | ");
                }
                System.out.println();

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
