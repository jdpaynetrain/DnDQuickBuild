package QuickBuild.Feats;
import QuickBuild.Character;

public class InspiringLeader implements IFeats {
    public void updateStats(Character person){

    }

    public Boolean metPreReqs(Character person){
        return person.checkStat("CHA") >= 13;
    }
}
