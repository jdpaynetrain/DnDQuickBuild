package QuickBuild.Feats;
import QuickBuild.Character;

public class Actor implements IFeats {
    public void updateStats(Character person){
        person.updateStat("CHA", 1);
    }

    public Boolean metPreReqs(Character person){
        return true;
    }
}
