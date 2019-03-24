package QuickBuild.Feats;
import QuickBuild.Character;
import java.util.Scanner;

public class LightlyArmored implements IFeats {

    public void updateStats(Character person){
        if(person.checkStat("STR") != 20 || person.checkStat("DEX") != 20){
            Scanner sc = new Scanner(System.in);
            Character.printToUser("You have chosen the Lightly Armored feat.");
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

        person.addProf("Light Armor");
    }

    public Boolean metPreReqs(Character person){
        return true;
    }
}
