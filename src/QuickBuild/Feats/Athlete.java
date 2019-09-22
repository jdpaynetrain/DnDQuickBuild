package QuickBuild.Feats;
import QuickBuild.Player.Character;
import QuickBuild.Player.CharacterController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Athlete implements IFeats {
    public void updateStats(Character person, CharacterController control){
        Set<String> statOptions = new HashSet<>(Arrays.asList("STR", "DEX"));
        control.applyFeatStats(person, statOptions);
    }

    public String featDescription(){
        return "You have undergone extensive physical training to gain " +
                "the following benefits:\n" +
                "- Increase your Strength or Dexterity by 1, to a " +
                "maximum of 20.\n" +
                "- When you are prone, standing uses only 5 feet of your " +
                "movement.\n" +
                "- Climbing doesn't halve your speed.\n" +
                "- You can make a running long jump or a running high jump " +
                "after moving only 5 feet on foot, rather than 10 feet";
    }
}
