package trainingdiary.src.base;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

	public Button SaveButton;
	String timeRegex = "^(1?[0-9]|2[0-3]):[0-5][0-9]$";
	
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
