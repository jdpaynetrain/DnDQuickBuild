package QuickBuild.Feats;
import QuickBuild.Character;
import java.util.Scanner;

public class Observant implements IFeats {

    public void updateStats(Character person){
        if(person.checkStat("INT") != 20 || person.checkStat("WIS") != 20){
            Scanner sc = new Scanner(System.in);
            Character.printToUser("You have chosen the Observant feat.");
            Character.printToUser("Choose INT or WIS to increase");
            person.printScores();
            String temp = sc.nextLine();
            while((!temp.equals("INT") && !temp.equals("WIS")) ||
                    person.checkStat(temp) == 20){
                if(temp.equals("INT")) {
                    Character.printToUser("INT is already 20. Boosting WIS");
                    temp = "WIS";
                }
                else if(temp.equals("WIS")){
                    Character.printToUser("WIS is already 20. Boosting INT");
                    temp = "INT";
                }
                else{
                    Character.printToUser("Options are INT or WIS");
                    temp = sc.nextLine();
                }
            }
            person.updateStat(temp, 1);
        }
        else{
            Character.printToUser("STR and DEX are both 20. No stats to boost.");
        }
    }

    public Boolean metPreReqs(Character person){
        return true;
    }
}
