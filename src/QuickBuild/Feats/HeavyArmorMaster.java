package QuickBuild.Feats;
import QuickBuild.Character;

public class HeavyArmorMaster implements IFeats {
    public void updateStats(Character person){
        person.updateStat("STR", 1);
    }

    static public Boolean metPreReqs(Character person){
        return person.hasProf("Heavy Armor") || person.hasProf("All Armor");
    }

}
