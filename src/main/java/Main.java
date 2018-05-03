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

        queryManager.insertToGroupsTable( "first", connection);
        queryManager.insertToGroupsTable("second", connection);
        queryManager.insertToGroupsTable("third", connection);

        queryManager.insertToCoursesTable("MUSIC", "ROCK MUSIC", connection);
        queryManager.insertToCoursesTable( "BIOLOGY", "BIOCHEMISTRY",connection);
        queryManager.insertToCoursesTable("PHYSICS", "QUANTUM PHYSICS", connection);

        queryManager.insertToStudentsTable( 1, "Johnny", "Walker",connection);
        queryManager.insertToStudentsTable(1, "Jim", "Beam",connection);
        queryManager.insertToStudentsTable(2, "John", "Lennon", connection);
        queryManager.insertToStudentsTable(3, "Frank", "Sinatra", connection);
        queryManager.insertToStudentsTable(3, "Michael ", "Jackson", connection);
        queryManager.insertToStudentsTable(2, "George", "Michael,", connection);
        queryManager.insertToStudentsTable(2, "Darren", "Heyes", connection);
        queryManager.insertToStudentsTable(1, "James", "Hatfield", connection);
        

        queryManager.createStudentsCoursesTable(connection);
        queryManager.insertToStudentCoursesTable(1,3, connection);
        queryManager.insertToStudentCoursesTable(2, 1, connection);
        queryManager.insertToStudentCoursesTable(3, 3, connection);
        queryManager.insertToStudentCoursesTable(4, 2, connection);
        queryManager.insertToStudentCoursesTable(5, 1, connection);
        queryManager.insertToStudentCoursesTable(6,1, connection);

        connection.close();
    }
    }
