package SQLtest;

import co.sofka.conexion.PersonasJDBC;
import co.sofka.domain.PersonaDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

public class personaDTOtest {

    @Test
    public void test() {
        PersonasJDBC personasJDBC = new PersonasJDBC();
        List<PersonaDTO> personas;
        personas = personasJDBC.getAllPersonas();
        for (PersonaDTO persona: personas) System.out.println("personas =" + persona);

    }
}