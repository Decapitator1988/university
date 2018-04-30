import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryManager {
    private static String USERNAME = "postgres";
    private static String PASSWORD = "postgres";
    private static  String URL = "jdbc:postgresql://localhost:5432/";
    private Connection connection = null;
    private DBProcesor dbProcesor = new DBProcesor();

    public Connection getConnection() throws SQLException {
        connection =  dbProcesor.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
    public void createDatabase(String dbName) throws SQLException {
        if (connection!=null){
            try(Statement statement = connection.createStatement()){
                String createQuery = "CREATE DATABASE "+dbName+";";
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
}
