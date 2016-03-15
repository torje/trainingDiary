package base;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.sql.Connection;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
		primaryStage.setTitle("gui");
		primaryStage.setScene(new Scene(root, 600, 600));
		primaryStage.show();

		dbConnection dbc = new dbConnection();
		Connection con = dbc.getConnection();
		dbc.getAllExercises(con);
		
	}
		
	
	
}
