package trainingdiary.src.base;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/*
 * Creates the session object where we will save the db info when the app is running
 */
public class Session {

	private StringProperty name;
	private String form;
	private String result;
	private String exercise;
	
	/** 
	 * Constructor that makes a new session
	 * @param Name off session
	 * @param users form string from 1 to 10
	 * @param users result string from 1 to 10
	 * @param string that is a list of exercises
	 */
	public Session(String name, String form, String result, String exercise){
		this.name = new SimpleStringProperty(name);
		this.form = form;
		this.result = result;
		this.exercise = exercise;
	}


	public StringProperty nameProperty() {
		return name;
	}


	public String getForm() {
		return form;
	}


	public String getResult() {
		return result;
	}


	public String getExercise() {
		return exercise;
	}
	
	
	
	
	
	
}
