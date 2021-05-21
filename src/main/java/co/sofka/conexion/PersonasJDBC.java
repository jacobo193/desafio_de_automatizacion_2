package co.sofka.conexion;

import co.sofka.domain.PersonaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class PersonasJDBC implements PersonaRepository {

    @Override
    public List<PersonaDTO> getAllPersonas() {
        final String SQL_SELECT = "SELECT persona_id, firstname, lastname, user, password, zipcode" +
                " FROM jacobo_diaz.persona";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<PersonaDTO> personas = new ArrayList<>();

        try {
            connection = MySQLConnection.getConnection();
            statement = connection.prepareStatement(SQL_SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                final int personaId = resultSet.getInt("persona_id");
                final String firstName = resultSet.getString("firstname");
                final String lastName = resultSet.getString("lastname");
                final String user = resultSet.getString("user");
                final String password = resultSet.getString("password");
                final String zipcode = resultSet.getString("zipcode");
                PersonaDTO persona = new PersonaDTO(personaId, firstName, lastName, user, password, zipcode);

                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (nonNull(resultSet))
                    MySQLConnection.close(resultSet);

                if (nonNull(statement))
                    MySQLConnection.close(statement);

                if (nonNull(connection))
                    MySQLConnection.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return personas;
    }
}
