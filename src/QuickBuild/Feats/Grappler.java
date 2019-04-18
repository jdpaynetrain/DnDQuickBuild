package QuickBuild.Feats;
import QuickBuild.Character;

public class Grappler implements IFeats {
    static public Boolean metPreReqs(Character person){
        return person.checkStat("STR") >= 13;
    }

    public void updateStats(Character person){

    }

    public String featDescription(){
        return "";
    }
}
