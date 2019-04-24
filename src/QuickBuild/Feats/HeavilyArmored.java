package QuickBuild.Feats;
import QuickBuild.Character;

public class HeavilyArmored implements IFeats {
    public void updateStats(Character person){
        person.addProf("Heavy Armor");
        person.updateStat("STR", 1);
    }

    static public Boolean metPreReqs(Character person){
        return person.hasProf("All Armor") || person.hasProf("Medium Armor");
    }

    public String featDescription(){
        return "You have trained to master the use of heavy armor, " +
                "gaining the following benefits:\n" +
                "- Increase your Strength score by 1, to a maximum of 20.\n" +
                "- You gain proficiency with heavy armor.";
    }
}
