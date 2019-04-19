package QuickBuild.Feats;
import QuickBuild.Character;
import java.util.Scanner;

public class ModeratelyArmored implements IFeats {
    public void updateStats(Character person){
        if(person.checkStat("STR") != 20 || person.checkStat("DEX") != 20){
            Scanner sc = new Scanner(System.in);
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

        person.addProf("Medium Armor");
        person.addProf("Shields");
    }

    static public Boolean metPreReqs(Character person){
        return person.hasProf("All Armor") || person.hasProf("Light Armor");
    }

    public String featDescription(){
        return "You have trained to master the use of medium armor " +
                "and shields, gaining the following benefits:\n" +
                "- Increase your Strength or Dexterity score by 1, to a " +
                "maximum of 20.\n" +
                "- You gain proficiency with medium armor and shields.";
    }
}
