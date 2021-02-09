import java.util.ArrayList;

public class Question {
    String name;
    byte noOfOptions;
    ArrayList<Option> options=new ArrayList<>();
    Question(String name, byte noOfOptions, ArrayList<Option> options){
        this.name=name;
        this.noOfOptions=noOfOptions;
        this.options=options;
    }
    void displayQuestion(){
        System.out.println(name);
    }
    void displayOptions(){
        for(Option option:options){
            System.out.println(option.name);
        }
    }
    void markOption(Option markOption){
        for(Option option:options){
            if(option.name.equals(markOption.name)){
                option.cnt++;
                break;
            }
        }
    }
    void finalScore(){
        for(Option option:options){
            System.out.println(option.cnt);
        }
    }
}