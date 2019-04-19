package QuickBuild.Feats;
import QuickBuild.Character;

import java.util.Scanner;

public class WeaponMaster implements IFeats {

    public void updateStats(Character person){
        Scanner sc = new Scanner(System.in);
        if(person.checkStat("STR") != 20 || person.checkStat("DEX") != 20){
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
        for(int i = 0; i < 4; i++){
            Character.printToUser("Choose 4 weapons to have proficiency with");
            String userWeapon = sc.nextLine();
            while(person.hasProf(userWeapon)){
                Character.printToUser("You already have proficiency");
                userWeapon = sc.nextLine();
            }
            person.addProf(userWeapon);
        }
    }

    public String featDescription(){
        return "You have practiced extensively with a variety of " +
                "weapons, gaining the following benefits:\n" +
                "- Increase your Strength or Dexterity score by 1, to a " +
                "maximum of 20.\n" +
                "- You gain proficiency with four weapons of your choice.";
    }
}
