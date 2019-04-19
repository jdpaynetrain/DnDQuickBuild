package QuickBuild.Feats;
import QuickBuild.Character;

public class PolearmMaster implements IFeats {
    public void updateStats(Character person){

    }

    public String featDescription() {
        return "You can keep your enemies at bay with reach weapons. " +
                "You gain the following benefits:\n" +
                "- When you take the Attack action and attack with only " +
                "a glaive, halberd, or quarterstaff, you can use a bonus " +
                "action to make a melee attack with the opposite end of " +
                "the weapon. The weapon’s damage die for this attack " +
                "is a d4, and the attack deals bludgeoning damage.\n" +
                "- While you are wielding a glaive, halberd, pike, or " +
                "quarterstaff,other creatures provoke an opportunity attack " +
                "from you when they enter your reach.";
    }
}
