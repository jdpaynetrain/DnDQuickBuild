package QuickBuild.Feats;

import QuickBuild.Character;

public class Alert implements IFeats {
    public void updateStats(Character person){
        person.addInit(5);
    }

    public Boolean metPreReqs(Character person){
        return true;
    }

    static public String featDescription(){
        return "Always on the lookout for danger, you gain the following " +
                "benefits: \n" +
                "- You gain a +5 bonus to initiative. \n" +
                "- You can't be surprised while you are conscious.\n" +
                "- Other creatures don't gain advantage on attack rolls " +
                "against you as a result of being hidden from you";
    }
}
