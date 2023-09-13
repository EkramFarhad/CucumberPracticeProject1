package DataBaseTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBT3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = " select * from person;";
            ResultSet resultset = statement.executeQuery(query);
            ResultSetMetaData resultSetDataMeta = resultset.getMetaData();

            List<Map<String, String>> ListFromResult = new ArrayList<>();

            while (resultset.next()) {
                Map<String, String> map = new LinkedHashMap<>();

                for (int i = 1; i <= resultSetDataMeta.getColumnCount(); i++) {

                    String key = resultSetDataMeta.getColumnName(i);
                    String value = resultset.getString(key);
                    map.put(key, value);
                }
                System.out.println(map);
                ListFromResult.add(map);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
