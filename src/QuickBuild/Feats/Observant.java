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

    public String featDescription() {
        return "Quick to notice details of your environment, you gain " +
                "the following benefits:\n" +
                "- Increase your Intelligence or Wisdom score by 1, to a " +
                "maximum of 20.\n" +
                "- If you can see a creature’s mouth while it is speaking " +
                "a language you understand, you can interpret what it’s " +
                "saying by reading its lips.\n" +
                "- You have a +5 bonus to your passive Wisdom " +
                "(Perception) and passive Intelligence (Investigation) " +
                "scores.";
    }
}
