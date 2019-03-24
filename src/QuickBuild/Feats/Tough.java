package QuickBuild.Feats;
import QuickBuild.Character;

public class Tough implements IFeats {

    public void updateStats(Character person){
        person.addHealth(person.getLevel() * 2);
        person.addHealthBonus(2);
    }

    public Boolean metPreReqs(Character person){
        return true;
    }
}
