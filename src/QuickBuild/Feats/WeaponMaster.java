package QuickBuild.Feats;
import QuickBuild.Character;

import java.util.Scanner;

public class WeaponMaster implements IFeats {
    public void updateStats(Character person){
        if(person.checkStat("STR") == 20 && person.checkStat("DEX") == 20){
            IFeats.printStuff("STR and DEX are both 20. No stats to boost.");
        }
        else if(person.checkStat("STR").equals(20)){
            IFeats.printStuff("STR is already 20. Boosting DEX");
            person.updateStat("STR", 1);
        }
        else if(person.checkStat("DEX").equals(20)){
            IFeats.printStuff("DEX is already 20. Boosting STR");
            person.updateStat("DEX", 1);
        }
        else {
            IFeats.printStuff("Choose STR or DEX to increase");
            person.printScores();
            String temp = IFeats.getLine();
            while((!temp.equals("DEX") && !temp.equals("STR"))){
                IFeats.printStuff("Options are DEX or STR");
                temp = IFeats.getLine();
            }
            person.updateStat(temp, 1);
        }
        for(int i = 0; i < 4; i++){
            IFeats.printStuff("Choose 4 weapons to have proficiency with");
            String userWeapon = IFeats.getLine();
            while(person.hasProf(userWeapon)){
                IFeats.printStuff("You already have proficiency");
                userWeapon = IFeats.getLine();
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
