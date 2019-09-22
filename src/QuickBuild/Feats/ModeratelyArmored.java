package QuickBuild.Feats;
import QuickBuild.Player.Character;
import QuickBuild.Player.CharacterController;
import java.util.*;

public class ModeratelyArmored implements IFeats {
    public void updateStats(Character person, CharacterController control){
        Set<String> statOptions = new HashSet<>(Arrays.asList("DEX", "STR"));
        control.applyFeatStats(person, statOptions);
        person.addProf("Medium Armor");
        person.addProf("Shields");
    }


    static public Boolean metPreReqs(Character person){
        return person.hasProf("All Armor") || person.hasProf("Light Armor");
    }

    public String featDescription(){
        return "You have trained to master the use of medium armor " +
                "and shields, gaining the following benefits:\n" +
                "- Increase your Strength or Dexterity score by 1, to a " +
                "maximum of 20.\n" +
                "- You gain proficiency with medium armor and shields.";
    }
}
