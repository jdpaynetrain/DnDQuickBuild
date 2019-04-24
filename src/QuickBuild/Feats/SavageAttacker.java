package QuickBuild.Feats;
import QuickBuild.Character;

public class SavageAttacker implements IFeats {
    public void updateStats(Character person){

    }

    public String featDescription() {
        return "Once per turn when you roll damage for a melee weapon " +
                "attack, you can reroll the weapon's damage dice and use " +
                "either total.";
    }
}
