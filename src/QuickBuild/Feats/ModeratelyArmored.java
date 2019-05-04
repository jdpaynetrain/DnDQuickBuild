package QuickBuild.Feats;
import QuickBuild.Character;

public class ModeratelyArmored implements IFeats {
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
