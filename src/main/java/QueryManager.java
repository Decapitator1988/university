import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryManager {
    private static String USERNAME = "postgres";
    private static String PASSWORD = "postgres";
    private static  String URL = "jdbc:postgresql://localhost:5432/";
    private Connection connection = null;
    private DBProcessor dbProcessor = new DBProcessor();

    public Connection getConnection() throws SQLException {
        connection =  dbProcessor.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
    public void createDatabase(String dbName) throws SQLException {
        if (connection!=null){
            try(Statement statement = connection.createStatement()){
                String createQuery = "DROP DATABASE IF EXISTS "+ dbName+";"+
                        "CREATE DATABASE "+dbName+";";
                statement.executeUpdate(createQuery);
            }catch (SQLException ex){
                ex.printStackTrace();
            }finally {
                if (connection!=null){
                    connection.close();
                }
            }
        }
    }
    public void dropDataBase(String dbName) throws SQLException {
        if (connection!=null){
            try(Statement statement = connection.createStatement()){
                String dropQuery = "DROP DATABASE IF EXISTS "+dbName+";";
                statement.executeUpdate(dropQuery);
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    public void createStudentsTable(Connection connection){
        if (connection!=null){
            try (Statement statement = connection.createStatement()){
                String createStudentsTableQuery = "CREATE TABLE STUDENTS (" +
                        "STUDENT_ID SERIAL PRIMARY KEY," +
                        "GROUP_ID INT," +
                        "FIRST_NAME VARCHAR(255) NOT NULL," +
                        "LAST_NAME VARCHAR(255) UNIQUE NOT NULL," +
                        "FOREIGN KEY (GROUP_ID) REFERENCES GROUPS(GROUP_ID)" +
                        ");";
                statement.execute(createStudentsTableQuery);
                System.out.println("Students table created");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void createGroupsTable(Connection connection){
        if (connection!=null){
            try (Statement statement = connection.createStatement()){
                String createGroupsTableQuery = "CREATE TABLE GROUPS(" +
                        "GROUP_ID SERIAL PRIMARY KEY," +
                        "NAME VARCHAR(255) NOT NULL" +
                        ");";
                statement.execute(createGroupsTableQuery);
                System.out.println("Groups table created");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void createCoursesTable(Connection connection){
        if (connection!=null){
            try (Statement statement = connection.createStatement()){
                String createCoursesTableQuery = "CREATE TABLE COURSES(" +
                        "COURSE_ID SERIAL PRIMARY KEY," +
                        "NAME VARCHAR(255) NOT NULL," +
                        "DESCRIPTION VARCHAR(500)" +
                        ");";
                statement.execute(createCoursesTableQuery);
                System.out.println("Courses table created");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertToStudentsTable(int groupId, String firstName, String lastName, Connection connection){
        if (connection!=null){
            try (Statement statement = connection.createStatement()){
                String createCoursesTableQuery = "INSERT INTO students ("+
                "group_id, first_name, last_name)"+
                "VALUES("+groupId+", "+"'"+firstName+"', '"+lastName+"');";
                statement.execute(createCoursesTableQuery);
                System.out.println("Courses table created");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void insertToGroupsTable(String name, Connection connection) {
        if (connection != null) {
            try (Statement statement = connection.createStatement()) {
                String createCoursesTableQuery = "INSERT INTO groups (" +
                        "name)" +
                        "VALUES('" + name + "');";
                statement.execute(createCoursesTableQuery);
                System.out.println("Courses table created");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void insertToCoursesTable(String name, String description, Connection connection){
        if (connection != null) {
            try (Statement statement = connection.createStatement()) {
                String createCoursesTableQuery = "INSERT INTO courses (" +
                        "name, description)" +
                        "VALUES("+"'"+name+"', '" + description + "');";
                statement.execute(createCoursesTableQuery);
                System.out.println("Courses table created");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void createStudentsCoursesTable(Connection connection){
        if (connection!=null){
            try (Statement statement = connection.createStatement()){
                String createStudentsCoursesTableQuery = "CREATE TABLE studentsCourses(" +
                        "STUDENT_ID INT NOT NULL," +
                        "COURSES_ID INT NOT NULL," +
                        "PRIMARY KEY (STUDENT_ID, COURSES_ID)," +
                        "FOREIGN KEY (STUDENT_ID) REFERENCES students(student_id),"+
                        "FOREIGN KEY (COURSES_ID) REFERENCES courses(course_id)"+
                        ");";
                statement.execute(createStudentsCoursesTableQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void insertToStudentCoursesTable(int studentsId, int coursesId, Connection connection){
        if (connection != null) {
            try (Statement statement = connection.createStatement()) {
                String insertToStudentCoursesTableQuery = "INSERT INTO studentscourses (" +
                        "student_id, courses_id)" +
                        "VALUES("+studentsId+", " + coursesId + ");";
                statement.execute(insertToStudentCoursesTableQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
