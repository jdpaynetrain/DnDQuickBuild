package QuickBuild.Feats;
import QuickBuild.Character;

public class KeenMind implements IFeats {
    public void updateStats(Character person){
        person.updateStat("INT", 1);
    }

    public Boolean metPreReqs(Character person){
        return true;
    }
}
