package co.sofka.conexion;

import co.sofka.domain.PersonaDTO;

import java.util.List;

public interface PersonaRepository {

    List<PersonaDTO> getAllPersonas();
}
