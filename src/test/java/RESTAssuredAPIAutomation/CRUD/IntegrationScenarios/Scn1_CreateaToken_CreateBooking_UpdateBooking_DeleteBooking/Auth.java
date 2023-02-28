package RESTAssuredAPIAutomation.CRUD.IntegrationScenarios.Scn1_CreateaToken_CreateBooking_UpdateBooking_DeleteBooking;

public class Auth {

    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
