package trainingdiary.src.base;

import java.time.LocalDate;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

	public Button LagreKnapp;
	public TextField rom;
	public DatePicker dato;
	public TextField fra;
	public TextField til;
	public TextField rep;
	public TextField slutt;
	public TextArea formål;

	
	
	public void handleButton(){
		String romNr = String.valueOf(rom.getText());
		LocalDate datoVal = dato.getValue();
		String fraString = String.valueOf(fra.getText());
		String tilString = String.valueOf(til.getText());
		String repString = String.valueOf(rep.getText());
		String sluttString = String.valueOf(slutt.getText());
		String formålString = String.valueOf(formål.getText());
		
		String[] splitedRom = romNr.split("\\s+");
		if (splitedRom[1].matches(".*\\d+.*")){
			System.out.println("Rom akseptert");
		}
		else{
			System.out.println("Nope");
		}
		
		if (fraString.contains(":")){
			System.out.println("Riktig fra tidspunkt");
		}
		if (tilString.contains(":")){
			System.out.println("Riktig til tidspunkt");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
