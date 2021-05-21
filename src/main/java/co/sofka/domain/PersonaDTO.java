package co.sofka.domain;

public class PersonaDTO {

    private int personaId;
    private String firstname;
    private String lastname;
    private String user;
    private String password;
    private String zipcode;

    public PersonaDTO() {
    }

    public PersonaDTO(int personaId) {
        this.personaId = personaId;
    }

    public PersonaDTO(String firstName, String lastName, String user, String password, String zipcode) {
        this.firstname = firstName;
        this.lastname = lastName;
        this.user = user;
        this.password = password;
        this.zipcode = zipcode;
    }

    public PersonaDTO(int personaId, String firstName, String lastName, String user, String password, String zipcode) {
        this.personaId = personaId;
        this.firstname = firstName;
        this.lastname = lastName;
        this.user = user;
        this.password = password;
        this.zipcode = zipcode;
    }

    public int getActorId() {
        return personaId;
    }

    public void setPersonaId(int persona_id) {
        this.personaId = persona_id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "actor{" +
                "actorId=" + personaId +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
