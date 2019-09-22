package QuickBuild.Feats;
import QuickBuild.Player.Character;
import QuickBuild.Player.CharacterController;

import java.util.*;

public class WeaponMaster implements IFeats {
    public void updateStats(Character person, CharacterController control){
        Set<String> statOptions = new HashSet<>(Arrays.asList("DEX", "STR"));
        control.applyFeatStats(person, statOptions);

        control.applyWeaponMaster(person);
    }

    public String featDescription(){
        return "You have practiced extensively with a variety of " +
                "weapons, gaining the following benefits:\n" +
                "- Increase your Strength or Dexterity score by 1, to a " +
                "maximum of 20.\n" +
                "- You gain proficiency with four weapons of your choice.";
    }
}
