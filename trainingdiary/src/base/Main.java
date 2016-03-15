package trainingdiary.src.base;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import trainingdiary.src.base.*;

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
		
		
	}
		
	
	
}
