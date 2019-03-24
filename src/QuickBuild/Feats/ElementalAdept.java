package QuickBuild.Feats;
import QuickBuild.Character;

public class ElementalAdept implements IFeats {
    public Boolean metPreReqs(Character person){
        return spellCasters.contains(person.getType());
    }

    public void updateStats(Character person){

    }
}
