package base;


import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/*
 * Creates the session object where we will save the db info when the app is running
 */
public class Session {

	private StringProperty name;
	private StringProperty form;
	private StringProperty result;
	private StringProperty exercise;
	
	
	/** 
	 * Constructor that makes a new session
	 * @param Name off session
	 * @param users form string from 1 to 10
	 * @param users result string from 1 to 10
	 * @param string that is a list of exercises
	 */
	public Session(String name, String form, String result, String exercise) {
		super();
		this.name = new SimpleStringProperty(name);
		this.form = new SimpleStringProperty(form);
		this.result = new SimpleStringProperty(result);
		this.exercise = new SimpleStringProperty(exercise);
	}


	public String getName() {
		return name.get();
	}


	public String getForm() {
		return form.get();
	}


	public String getResult() {
		return result.get();
	}


	public String getExercise() {
		return exercise.get();
	}
	
	
	
	
	
	
	
	
	
}
