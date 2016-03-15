package base;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD
import trainingdiary.src.base.*;
=======

import java.sql.Connection;

>>>>>>> 136dd4f011499c165ece33fdc16332a68442dc3a

public class Main extends Application {
	
	private ObservableList<Session> sessionData = FXCollections.observableArrayList();
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		sessionData.add(new Session("Markløft", "8", "9", "Markløft, knebøy, pushups"));
		Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
		primaryStage.setTitle("gui");
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();

		dbConnection dbc = new dbConnection();
		Connection con = dbc.getConnection();
		dbc.getAllExercises(con);
		
	}
		
	
	
}
