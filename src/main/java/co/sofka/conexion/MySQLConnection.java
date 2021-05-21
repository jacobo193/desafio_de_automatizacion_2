package co.sofka.conexion;

import java.sql.*;

public class MySQLConnection {




    private static  final String JDBC_URL = "jdbc:mysql://sofka-training.cpxphmd1h1ok.us-east-1.rds.amazonaws.com:3306/jacobo_diaz?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "sofka_training";
    private static final String JDBC_PASS = "BZenX643bQHw";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(PreparedStatement stmt) throws SQLException {
        stmt.close();
    }

    public static void close(Connection con) throws SQLException {
        con.close();
    }
}
