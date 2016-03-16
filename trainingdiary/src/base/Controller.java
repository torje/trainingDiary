//package base;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
//import base.Session;
//import base.Main;

public class Controller implements Initializable {
	
	public Button SaveButton;
	private int count = 6;
	
	//List with all inputs
	@FXML
	public TextField sessionID;


	public ComboBox<String> formInn;
	public ComboBox<String> resultInn;
	public DatePicker date;
	public TextField from;
	public TextField end;
	public RadioButton gain;
	public RadioButton condition;
	@FXML
	private ComboBox<String> exerciseList;
	
	
	//Regex for timedate
	String timeRegex = "^(1?[0-9]|2[0-3]):[0-5][0-9]$";
	
	/*
	 * Creates the table where we push the info from the db
	 */
	@FXML
	private TableView<Session> tableID;
	@FXML
	private TableColumn<Session, String> name;
	@FXML
	private TableColumn<Session, String> form;
	@FXML
	private TableColumn<Session, String> result;
	@FXML
	private TableColumn<Session, String> exercise;

	
	/*
	 * Makes the arraylist that pushes to the table
	 * use new Session(String nameOfSession, String Form, String Result, String listOfexercises)
	 */
	ObservableList<Session> data = FXCollections.observableArrayList(
			//Example
			//new Session("Markloft", "8", "8", "Kneboy, hilgu , hui ho , ghiu gig , giu giug")
			//TODO create some sort off script to add a new session for each dbrow
		);
	
	/*
	 * Sets the table
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		name.setCellValueFactory(new PropertyValueFactory<Session, String>("name"));
		form.setCellValueFactory(new PropertyValueFactory<Session, String>("form"));
		result.setCellValueFactory(new PropertyValueFactory<Session, String>("result"));
		exercise.setCellValueFactory(new PropertyValueFactory<Session, String>("exercise"));
		updateTableID();
		exerciseList.getItems().addAll(this.getExerciseList());
	}
	private void updateTableID( ){

		ArrayList<Session> als = new DBConnection().getAllSessions();
		data.setAll(als);
		tableID.setItems(data);
	}
	
	/** 
	 * Triggers when save in diary is pressed
	 */

	private void addExerciseToSession(){
		String fieldContent  = sessionID.getText();
		int sesid;
		try {
			sesid = Integer.parseInt(fieldContent);
		}catch( Exception e) {
			System.out.println("Invalid format, I want a number! ");
			return;
		}
		for ( Session session: data) {
			if ( Integer.parseInt(session.getName()) == sesid) {
				System.out.println(session.getName() );
			}
		}
	}

	public void handleButton(){

		//TODO get the vaules off the field and push it to db




		DBConnection dbc = new DBConnection();
		ArrayList<Exercise> exercises = dbc.getAllExercises();

		Exercise ex = new Exercise(0, "", "");
		for (Exercise e : exercises){
			if (e.getExName() == exerciseList.getValue()){
				ex = e;
			}
		}
		ArrayList<Exercise> sesExs = new ArrayList<Exercise>();
		sesExs.add(ex);

		//dbc.addSessionToDB(count, Integer.parseInt(formInn.getValue()), Integer.parseInt(resultInn.getValue()), sesExs);
		count ++ ;
		ArrayList<Session> sessions = dbc.getAllSessions();
		for (Session s : sessions){
			//System.out.println(s.getExercisesAsString());
		}
		updateTableID();
		addExerciseToSession();
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


	//gets exercises from database
	private ArrayList<String> getExerciseList() {

		DBConnection dbc = new DBConnection();
		ArrayList<Exercise> exercises = dbc.getAllExercises();
		ArrayList<String> exNames = new ArrayList<String>();
		for (Exercise exercise : exercises) {
			System.out.println(exercise.getExName());
			exNames.add(exercise.getExName());

		}



		return exNames;
	}


	

	
	
	
	
	
	
	
	
}
