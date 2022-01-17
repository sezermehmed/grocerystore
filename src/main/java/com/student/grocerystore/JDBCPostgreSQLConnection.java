package com.student.grocerystore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCPostgreSQLConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "  ";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    // close connection to the database
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     */
    public static void main() {
        //JDBCPostgreSQLConnection app = new JDBCPostgreSQLConnection();
        //app.connect();
    }

}
