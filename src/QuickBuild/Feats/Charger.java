package QuickBuild.Feats;
import QuickBuild.Character;

public class Charger implements IFeats {
    public void updateStats(Character person){ }

    public String featDescription(){
        return "When you use your action to Dash, you can use a bonus action " +
                "to make one melee weapon attack or to shove a creature.\n" +
                "If you move at least 10 feet in a straight line immediately "+
                "before taking this bonus action, you either gain a +5 to the "+
                "attack's damage roll (if you choose to make a melee attack " +
                "and hit) or push the target up to 10 feet away from you (if" +
                "you choose to shove and succeed)";
    }
}
