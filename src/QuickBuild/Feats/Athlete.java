package QuickBuild.Feats;
import QuickBuild.Character;

public class Athlete implements IFeats {
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
