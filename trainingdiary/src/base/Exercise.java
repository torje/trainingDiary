//package base;

/**
 * Created by andreanornes on 16.03.2016.
 */
public class Exercise {
    private int id;
    private String exName;
    private String exDesc;
    public Exercise(int id, String exName, String exDesc){
        this.exDesc = exDesc;
        this.exName = exName;
        this.id = id;
    }



    public int getId() {
        return id;
    }

    public String getExName() {
        return exName;
    }

    public String getExDesc() {
        return exDesc;
    }
}
