package QuickBuild.Feats;
import QuickBuild.Character;
import java.util.Scanner;

public class Athlete implements IFeats {

    public void updateStats(Character person){
        if(person.checkStat("STR") != 20 || person.checkStat("DEX") != 20){
            Scanner sc = new Scanner(System.in);
            Character.printToUser("You have chosen the athlete feat.");
            Character.printToUser("Choose STR or DEX to increase");
            person.printScores();
            String temp = sc.nextLine();
            while((!temp.equals("DEX") && !temp.equals("STR")) ||
                    person.checkStat(temp) == 20){
                if(temp.equals("DEX")) {
                    Character.printToUser("DEX is already 20. Boosting STR");
                    temp = "STR";
                }
                else if(temp.equals("STR")){
                    Character.printToUser("STR is already 20. Boosting DEX");
                    temp = "DEX";
                }
                else{
                    Character.printToUser("Options are DEX or STR");
                    temp = sc.nextLine();
                }
            }
            person.updateStat(temp, 1);
        }
        else{
            Character.printToUser("STR and DEX are both 20. No stats to boost.");
        }
    }

    public String featDescription(){
        return "You have undergone extensive physical training to gain " +
                "the following benefits:\n" +
                "- Increase your Strength or Dexterity by 1, to a " +
                "maximum of 20.\n" +
                "- When you are prone, standing uses only 5 feet of your " +
                "movement.\n" +
                "- Climbing doesn't halve your speed.\n" +
                "- You can make a running long jump or a running high jump " +
                "after moving only 5 feet on foot, rather than 10 feet";
    }
}
