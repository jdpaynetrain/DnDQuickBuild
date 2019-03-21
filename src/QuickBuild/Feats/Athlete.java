package QuickBuild.Feats;
import QuickBuild.Character;
import java.util.Scanner;

public class Athlete implements IFeats {
    public Boolean metPreReqs(Character person){
        return true;
    }

    public void updateStats(Character person){
        if(person.checkStat("STR") != 20 || person.checkStat("DEX") != 20){
            Scanner sc = new Scanner(System.in);
            System.out.println("You have chose the athlete feat.");
            System.out.println("Choose STR or DEX to increase");
            person.printScores();
            String temp = sc.nextLine();
            while((!temp.equals("DEX") && !temp.equals("STR")) ||
                    person.checkStat(temp) == 20){
                if(temp.equals("DEX")) {
                    System.out.println("DEX is already 20. Boosting STR");
                    temp = "STR";
                }
                else if(temp.equals("STR")){
                    System.out.println("STR is already 20. Boosting DEX");
                    temp = "DEX";
                }
                else{
                    System.out.println("Options are DEX or STR");
                    temp = sc.nextLine();
                }
            }
            person.updateStat(temp, 1);
        }
    }
}
