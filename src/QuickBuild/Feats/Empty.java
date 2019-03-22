package QuickBuild.Feats;

import QuickBuild.Character;

public class Empty implements IFeats {

    public Boolean metPreReqs(Character person){
        return true;
    }

    public void updateStats(Character person){    }
}
