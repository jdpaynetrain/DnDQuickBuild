package QuickBuild.Feats;
import QuickBuild.Player.Character;

public class Tough implements IFeats {

    public void updateStats(Character person){
        person.addHealth(person.getLevel() * 2);
        person.addHealthBonus(2);
    }

    public String featDescription(){
        return "Your hit point maximum increases by an amount equal " +
                "to twice your level when you gain this feat. Whenever " +
                "you gain a level thereafter, your hit point maximum " +
                "increases by an additional 2 hit points.";
    }
}
