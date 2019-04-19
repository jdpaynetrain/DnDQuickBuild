package QuickBuild.Feats;
import QuickBuild.Character;
import java.util.Scanner;

public class TavernBrawler implements IFeats {
    public void updateStats(Character person){
        if(person.checkStat("STR") == 20 && person.checkStat("CON") == 20){
            IFeats.printStuff("STR and CON are both 20. No stats to boost.");
        }
        else if(person.checkStat("STR").equals(20)){
            IFeats.printStuff("STR is already 20. Boosting CON");
            person.updateStat("STR", 1);
        }
        else if(person.checkStat("CON").equals(20)){
            IFeats.printStuff("CON is already 20. Boosting STR");
            person.updateStat("CON", 1);
        }
        else {
            IFeats.printStuff("Choose STR or CON to increase");
            person.printScores();
            String temp = IFeats.getLine();
            while((!temp.equals("CON") && !temp.equals("STR"))){
                IFeats.printStuff("Options are CON or STR");
                temp = IFeats.getLine();
            }
            person.updateStat(temp, 1);
        }
        person.addProf("Improvised Weapons");
        person.addProf("Unarmed Strikes");
    }

    public String featDescription(){
        return "Accustomed to rough-and-tumble fighting using " +
                "whatever weapons happen to be at hand, you gain the " +
                "following benefits:\n" +
                "- Increase your Strength or Constitution score by 1, " +
                "to a maximum of 20.\n" +
                "- You are proficient with improvised weapons and " +
                "unarmed strikes.\n" +
                "- Your unarmed strike uses a d4 for damage.\n" +
                "- When you hit a creature with an unarmed strike or an " +
                "improvised weapon on your turn, you can use a bonus " +
                "action to attempt to grapple the target.";
    }
}
