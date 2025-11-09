package javaassignment2;

public class DatabaseConnection {

    private DatabaseConnection(){

    }

    private static DatabaseConnection databaseConnection = null;

    private static DatabaseConnection getDatabaseConnection(){
        if (databaseConnection == null){
            return databaseConnection = new DatabaseConnection();
        }
        else {
           return databaseConnection;
        }
    }
}
