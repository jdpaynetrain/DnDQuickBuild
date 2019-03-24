package QuickBuild.Feats;
import QuickBuild.Character;

public class RitualCaster implements IFeats {
    public void updateStats(Character person){

    }

    public Boolean metPreReqs(Character person){
        return person.checkStat("WIS") >= 13 || person.checkStat("INT") >= 13;
    }
}
