package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {

    static Connection connection = null;
    static Statement statement = null;
    private static ResultSet resultset;
    private static ResultSetMetaData resultSetMetaData;


    public static ResultSet getResultset(String sqlQuery) {

        try {
            connection = DriverManager.getConnection(
                    ConfigReader.getPropertyValue("urldb"),
                    ConfigReader.getPropertyValue("usernamedb"),
                    ConfigReader.getPropertyValue("passworddb"));
            statement = connection.createStatement();
            resultset = statement.executeQuery(sqlQuery);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultset;

    }

    public static ResultSetMetaData getResultSetMetaData(String query) {

        resultset = getResultset(query);
        resultSetMetaData = null;

        try {
            resultSetMetaData = resultset.getMetaData();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSetMetaData;
    }

    public static List<Map<String, String>> getListOfMapsFromRset(String query) {
        resultSetMetaData = getResultSetMetaData(query);
        List<Map<String, String>> listFromRset = new ArrayList<>();

        try {
            while (resultset.next()) {
                Map<String, String> map = new LinkedHashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    String key = resultSetMetaData.getColumnName(i);
                    String value = resultset.getString(key);
                    map.put(key, value);

                }
                System.out.println(map);
                listFromRset.add(map);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtility.closeResultSet(resultset);
            DBUtility.closeStatement(statement);
            DBUtility.closeConnection(connection);
        }
        return listFromRset;

    }

    public static void closeResultSet(ResultSet rSet) {
        if (rSet != null) {
            try {
                rSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement statement) {

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}