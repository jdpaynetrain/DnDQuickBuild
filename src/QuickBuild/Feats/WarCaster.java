package QuickBuild.Feats;
import QuickBuild.Character;

public class WarCaster implements IFeats {

    public void updateStats(Character person){
    }

    public Boolean metPreReqs(Character person){
        return spellCasters.contains(person.getType());
    }
}