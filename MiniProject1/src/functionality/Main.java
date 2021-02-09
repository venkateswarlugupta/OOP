package functionality;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Question> questions=new ArrayList<>();
        FileReader frq=new FileReader("D:\\VCE\\OOP\\MiniProject1\\src\\data\\Questions");
        BufferedReader brq=new BufferedReader(frq);
        String qstatement;
        int i=1;
        while((qstatement=brq.readLine())!=null){
            Question q=new Question(qstatement);
            questions.add(q);
            String filename="D:\\VCE\\OOP\\MiniProject1\\src\\data\\ChoicesOfQ"+i;
            FileReader frc=new FileReader(filename);
            BufferedReader brc=new BufferedReader(frc);
            String cstatement;
            while((cstatement=brc.readLine())!=null){
                Choice c=new Choice(cstatement);
                q.choices.add(c);
            }
            brc.close();
            frc.close();
            i++;
        }
        brq.close();
        frq.close();
        i=1;
        for(Question question:questions){
            System.out.println("Question "+i+" is : "+question.getqStatement());
            int j=1;
            for(Choice choice:question.choices){
                System.out.println("    Choice "+j+" is : "+choice.getCstatement());
                j++;
            }
            i++;
        }
    }
}