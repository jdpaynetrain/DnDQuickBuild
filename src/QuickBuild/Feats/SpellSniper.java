package QuickBuild.Feats;
import QuickBuild.Character;

public class SpellSniper implements IFeats {
    public void updateStats(Character person){

    }

    static public Boolean metPreReqs(Character person){
        return spellCasters.contains(person.getType());
    }
}
