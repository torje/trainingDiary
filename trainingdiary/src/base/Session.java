package base;


import java.time.LocalDate;
import java.util.ArrayList;

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

	private String name;
	private String form;
	private String result;
	private ArrayList<Exercise> exercises;
	
	
	/** 
	 * Constructor that makes a new session
	 * @param Name off session
	 * @param users form string from 1 to 10
	 * @param users result string from 1 to 10
	 * @param string that is a list of exercises
	 */
	public Session(String name, String form, String result, ArrayList<Exercise> exercises) {
		super();
		this.name = name;
		this.form = form;
		this.result = result;
		this.exercises = exercises;
	}


	public String getName() {
		return name;
	}

	public String getForm() {
		return form;
	}

	public String getResult() {
		return result;
	}

	public ArrayList<Exercise> getExercises() {
		return exercises;
	}

	public String getExercisesAsString(){
		String str = "";
		for (Exercise ex : exercises){
			str += ex.getExName();
		}
		return str;
	}
}
