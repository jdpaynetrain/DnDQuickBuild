package QuickBuild.Feats;
import QuickBuild.Character;

public class DefensiveDuelist implements IFeats {
    public Boolean metPreReqs(Character person){
        return (person.checkStat("DEX") >= 13);
    }

    public void updateStats(Character person){

    }
}
