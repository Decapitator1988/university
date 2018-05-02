import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static String USERNAME = "postgres";
    private static String PASSWORD = "postgres";
    private static  String URL = "jdbc:postgresql://localhost:5432/";

    public static void main(String[] args) throws SQLException {
        QueryManager queryManager = new QueryManager();
        String dbName = "university";
        Connection connection = queryManager.getConnection();
        queryManager.createDatabase(dbName);
        URL += dbName;
        DBProcessor dbProcessor = new DBProcessor();
        connection = dbProcessor.getConnection(URL, USERNAME, PASSWORD);
        queryManager.createCoursesTable(connection);
        queryManager.createGroupsTable(connection);
        queryManager.createStudentsTable(connection);
        queryManager.insertToGroupsTable( "fifth", connection);
        queryManager.insertToCoursesTable( "BIOLOGY", "BIOCHEMISTRY",connection);
        queryManager.insertToStudentsTable( 1, "Johnny", "Walker",connection);
        queryManager.insertToStudentsTable(1, "Jim", "Beam",connection);

        connection.close();
    }
    }
