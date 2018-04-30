import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        QueryManager queryManager = new QueryManager();
            queryManager.getConnection();
            queryManager.dropDataBase("Staff");
            queryManager.createDatabase("Staff");

    }
//    private static String USERNAME = "postgres";
//    private static String PASSWORD = "postgres";
//    private static  String URL = "jdbc:postgresql://localhost:5432/";

//    public static void main(String[] args) throws SQLException {
//        Connection connection = null;
//        DBProcesor dbProcesor = new DBProcesor();
//        connection = dbProcesor.getConnection(URL, USERNAME, PASSWORD);
//        try(Statement statement = connection.createStatement()){
//            String removeDbQuery = "DROP DATABASE IF EXISTS University";
//            String createDbQuery = "CREATE DATABASE University";
//            statement.executeUpdate(removeDbQuery);
//            statement.executeUpdate(createDbQuery);
//
//
//        }catch (SQLException ex){
//            ex.printStackTrace();
//        }finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            }catch (SQLException ex){
//                ex.printStackTrace();
//            }
//        }

    }
