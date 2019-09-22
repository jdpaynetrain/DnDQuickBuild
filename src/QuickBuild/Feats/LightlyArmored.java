package QuickBuild.Feats;
import QuickBuild.Player.Character;
import QuickBuild.Player.CharacterController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LightlyArmored implements IFeats {

    public void updateStats(Character person, CharacterController control){
        Set<String> statOptions = new HashSet<>(Arrays.asList("STR", "DEX"));
        control.applyFeatStats(person, statOptions);
        person.addProf("Light Armor");
    }

    public String featDescription(){
        return "You have trained to master the use of light armor, " +
                "gaining the following benefits:\n" +
                "- Increase your Strength or Dexterity score by 1, to a " +
                "maximum of 20.\n" +
                "- You gain proficiency with light armor.";
    }
}
