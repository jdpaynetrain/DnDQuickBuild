package QuickBuild.Feats;
import QuickBuild.Character;

public class Sharpshooter implements IFeats {
    public void updateStats(Character person){

    }

    public String featDescription(){
        return "You have mastered ranged weapons and can make " +
                "shots that others find impossible. You gain the " +
                "following benefits:\n" +
                "- Attacking at long range doesn't impose disadvantage " +
                "on your ranged weapon attack rolls.\n" +
                "- Your ranged weapon attacks ignore half cover and " +
                "three-quarters cover.\n" +
                "- Before you make an attack with a ranged weapon that " +
                "you are proficient with, you can choose to take a - 5 " +
                "penalty to the attack roll. If the attack hits, you add +10 "+
                "to the attack’s damage.";
    }
}
