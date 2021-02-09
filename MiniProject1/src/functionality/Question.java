package functionality;

import java.util.ArrayList;

public class Question {
    ArrayList<Choice> choices=new ArrayList<>();
    String qStatement;
    Question(String qStatement){
        this.qStatement=qStatement;
    }

    public ArrayList<Choice> getChoices() {
        return choices;
    }

    public String getqStatement() {
        return qStatement;
    }
}