package QuickBuild.Feats;
import QuickBuild.Character;

public class Durable implements IFeats {
    public void updateStats(Character person){
        person.updateStat("CON", 1);
    }

    public Boolean metPreReqs(Character person){
        return true;
    }
}
