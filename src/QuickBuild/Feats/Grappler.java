package QuickBuild.Feats;
import QuickBuild.Character;

public class Grappler implements IFeats {
    public Boolean metPreReqs(Character person){
        return person.checkStat("STR") >= 13;
    }

    public void updateStats(Character person){

    }
}
