package trainingdiary.src.base;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import trainingdiary.src.base.*;
import java.sql.Connection;



public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
		primaryStage.setTitle("Training Diary");
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
		
		
	}
		
		/*

		dbConnection dbc = new dbConnection();
		Connection con = dbc.getConnection();
		dbc.getAllExercises(con);
		*/
	
		
	
	
}
