package SQLtest;


import org.junit.jupiter.api.Test;

import java.sql.*;

public class TestMySQL {

    @Test
    public void main() {
        //creando variable del Url para la conxion
        var url = "jdbc:mysql://localhost/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            // creando conexion para la base de datos
            Connection connection = DriverManager.getConnection(url, "root", "admin");
            //realizar la sentencias de SQL
            Statement instruccion = connection.createStatement();
            var sql = "SELECT persona_id, firstname, lastname, user, password, zip, code FROM test.persona";
            // realizando Query
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.println("persona_id: " + resultado.getInt("persona_id"));
                System.out.print("firstname,:" + resultado.getString("firstname"));
                System.out.print("lastname:" + resultado.getString("lastname"));
                System.out.println("user:" + resultado.getString("user"));
                System.out.println("password:" + resultado.getString("password"));
                System.out.println("zipcode:" + resultado.getString("zipcode"));
            }
            // cerrando conexion
            resultado.close();
            instruccion.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);

        }
    }
}
