import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBProcesor {
    private Connection connection;

    public DBProcesor() {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex){
            System.out.println("Driver not found");
            return;
        }
    }

    public Connection getConnection(String url, String username, String password) throws SQLException {
        if (connection!=null){
            return connection;
        }
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
