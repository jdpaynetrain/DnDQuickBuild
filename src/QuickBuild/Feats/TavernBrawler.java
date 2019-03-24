package QuickBuild.Feats;
import QuickBuild.Character;
import java.util.Scanner;

public class TavernBrawler implements IFeats {

    public void updateStats(Character person){
        if(person.checkStat("STR") != 20 || person.checkStat("CON") != 20){
            Scanner sc = new Scanner(System.in);
            Character.printToUser("You have chosen the athlete feat.");
            Character.printToUser("Choose STR or CON to increase");
            person.printScores();
            String temp = sc.nextLine();
            while((!temp.equals("CON") && !temp.equals("STR")) ||
                    person.checkStat(temp) == 20){
                if(temp.equals("CON")) {
                    Character.printToUser("CON is already 20. Boosting STR");
                    temp = "STR";
                }
                else if(temp.equals("STR")){
                    Character.printToUser("STR is already 20. Boosting CON");
                    temp = "CON";
                }
                else{
                    Character.printToUser("Options are CON or STR");
                    temp = sc.nextLine();
                }
            }
            person.updateStat(temp, 1);
        }
        else{
            Character.printToUser("STR and CON are both 20. No stats to boost.");
        }
        person.addProf("Improvised Weapons");
        person.addProf("Unarmed Strikes");
    }

    public Boolean metPreReqs(Character person){
        return true;
    }
}
