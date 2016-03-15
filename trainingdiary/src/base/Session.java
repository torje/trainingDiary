package trainingdiary.src.base;

public class Session {

	private String name;
	private String form;
	private String result;
	private String exercise;
	
	
	public Session(String name, String form, String result, String exercise){
		this.name = name;
		this.form = form;
		this.result = result;
		this.exercise = exercise;
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


	public String getExercise() {
		return exercise;
	}
	
	
	
	
	
	
}
