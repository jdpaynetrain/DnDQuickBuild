package QuickBuild.Feats;

import QuickBuild.Character;

public class Alert implements IFeats {
    public void updateStats(Character person){
        person.addInit(5);
    }

    public Boolean metPreReqs(Character person){
        return true;
    }
}
