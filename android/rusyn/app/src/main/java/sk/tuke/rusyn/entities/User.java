package sk.tuke.rusyn.entities;

/**
 * Created by petko on 22. 2. 2018.
 */

public class User {
    public static final String tableName = "USERS";

    public static final String columnID = "id";
    public static final String columnEmail = "email";
    public static final String columnIsLogged = "isLogged";

    private String id;
    private String email;
    private int isLogged;

    //CREATE TABLE
    public static final String createTable =
            "CREATE TABLE " + tableName + "("
                    + columnID + " TEXT,"
                    + columnEmail + " TEXT,"
                    + columnIsLogged + " INTEGER"
                    + ")";

    //CONSTUCTORS
    public User() {
    }

    public User(String id, String email, int isLogged) {
        this.id = id;
        this.email = email;
        this.isLogged = isLogged;
    }

    //GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(int isLogged) {
        this.isLogged = isLogged;
    }
}
