package trainingdiary.src.base;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import trainingdiary.src.base.Session;
import trainingdiary.src.base.Main;

public class Controller {
	
	private Main main;
	
	/*
	 * Creates the table where we push the info from the db
	 */
	@FXML
	private TableView<Session> sessionTable;
	@FXML
	private TableColumn<Session, String> nameCol;
	@FXML
	private TableColumn<Session, String> formCol;
	@FXML
	private TableColumn<Session, String> resultCol;
	@FXML
	private TableColumn<Session, String> exerciseCol;

	public Button SaveButton;
	String timeRegex = "^(1?[0-9]|2[0-3]):[0-5][0-9]$";
	
	
	/*
	 * Initializes the controller class. This is loaded automaticly
	 */
	public void initialize(){
		nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
	}
	
	/*
	 * Called my main to set observerlist
	 */
	public void setMain(Main main){
		this.main = main;
		sessionTable.setItems(main.getSessionData());
	}
	
	
	/** 
	 * Triggers when save in diary is pressed
	 */
	public void handleButton(){
		
		System.out.print("hey");
		
		
	}

	//setting time fields
	private LocalTime getTime(TextField field) {
		String val = field.getText();
		if (!val.matches(timeRegex)) {
			throw new IllegalArgumentException("Enter a valid time!\n");
		}
		int hour = Integer.parseInt(val.substring(0,2));
		int minutes = Integer.parseInt(val.substring(3,5));
		return LocalTime.of(hour, minutes);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
