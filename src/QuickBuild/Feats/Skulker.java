package QuickBuild.Feats;
import QuickBuild.Character;

public class Skulker implements IFeats {
    public void updateStats(Character person){

    }

    public Boolean metPreReqs(Character person){
        return person.checkStat("DEX") >= 13;
    }
}
