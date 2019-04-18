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
}
