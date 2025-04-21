package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorBD {

    private static final String URL = "jdbc:mysql://localhost:3306/dungeon";
    private static final String USER = "dan";
    private static final String PASSWORD = "Password1234";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
