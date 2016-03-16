//package base;


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
	private String exercises;
	
	
	/** 
	 * Constructor that makes a new session
	 * @param Name off session
	 * @param users form string from 1 to 10
	 * @param users result string from 1 to 10
	 * @param string that is a list of exercises
	 */
    //public Session(String name, String form, String result, ArrayList<Exercise> exercises) {
    public Session(String name, String form, String result, String exercises) {
		super();
		this.name = name;
		this.form = form;
		this.result = result;
        this.exercises = exercises;
        //this.exercises = "shitface";
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

    public String getExercise() { return exercises;}
    public String toString() {
        return name + form + result +exercises;
    }

	/*public ArrayList<Exercise> getExercises() {
		return exercises;
	}

	public String getExercisesAsString(){
		String str = "";
		for (Exercise ex : exercises){
			str += ex.getExName();
		}
		return str;
	}*/
}
