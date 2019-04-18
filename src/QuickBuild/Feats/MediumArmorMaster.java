package QuickBuild.Feats;
import QuickBuild.Character;

public class MediumArmorMaster implements IFeats {
    public void updateStats(Character person){

    }

    static public Boolean metPreReqs(Character person){
        return person.hasProf("Medium Armor") || person.hasProf("All Armor");
    }
}
