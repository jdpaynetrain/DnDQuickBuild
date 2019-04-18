package QuickBuild.Feats;
import QuickBuild.Character;

public class Healer implements IFeats {
    public void updateStats(Character person){

    }

    public String featDescription(){
        return "You are an able physician, allowing you to mend wounds " +
                "quickly and get your allies back in the fight. You gain " +
                "the following benefits:\n" +
                "- When you use a healer's kit to stabilize a dying " +
                "creature, that creature also regains 1 hit point.\n" +
                "- As an action, you can spend one use of a healer’s kit to " +
                "tend to a creature and restore 1d6 + 4 hit points to it, " +
                "plus additional hit points equal to the creature’s maximum " +
                "number o f Hit Dice. The creature can’t regain " +
                "hit points from this feat again until it finishes a short " +
                "or long rest.";
    }
}
