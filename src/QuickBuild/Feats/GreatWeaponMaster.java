package QuickBuild.Feats;
import QuickBuild.Character;

public class GreatWeaponMaster implements IFeats {
    public void updateStats(Character person){

    }

    public String featDescription(){
        return "You've learned to put the weight of a weapon to your " +
                "advantage, letting its momentum empower your strikes. You " +
                "gain the following benefits:\n" +
                "- On your turn, when you score a critical hit with a melee " +
                "weapon or reduce a creature to 0 hit points with one, you " +
                "can make one melee weapon attack as a bonus action.\n" +
                "- Before you make a melee attack with a heavy weapon that " +
                "you are proficient with, you can choose to take a -5 " +
                "penalty to the attack roll. If the attack hits, you add " +
                "+10 to the attack's damage.";
    }
}