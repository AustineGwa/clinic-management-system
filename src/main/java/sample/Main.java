package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.database.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        createDbTables();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 375));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void createDbTables() throws SQLException {

        //String deleteDbRecords ="DELETE FROM patients";

        String createPatientTableSql = "CREATE TABLE IF NOT EXISTS  patients(name VARCHAR(100), reg_num VARCHAR(20), " +
                "year VARCHAR(30),symptoms VARCHAR(250),  disease VARCHAR(50), prescription VARCHAR(50))";

        String createDoctorsTableSql = "CREATE TABLE IF NOT EXISTS doctors(name VARCHAR(50), ID VARCHAR(20), specialization VARCHAR(100))";

        Connection conn = DbConnection.getConnection();
        if (conn != null) {
            conn.createStatement().execute(createPatientTableSql);
            conn.createStatement().execute(createDoctorsTableSql);
           // conn.createStatement().execute(deleteDbRecords);
        } else {
            System.out.println("not connected to db");
        }
    }
}
