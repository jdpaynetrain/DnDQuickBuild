package QuickBuild.Feats;
import QuickBuild.Player.Character;
import QuickBuild.Player.CharacterController;
import java.util.*;

public class Observant implements IFeats {

    public void updateStats(Character person, CharacterController control){
        Set<String> statOptions = new HashSet<>(Arrays.asList("INT", "WIS"));
        control.applyFeatStats(person, statOptions);
    }

    public String featDescription() {
        return "Quick to notice details of your environment, you gain " +
                "the following benefits:\n" +
                "- Increase your Intelligence or Wisdom score by 1, to a " +
                "maximum of 20.\n" +
                "- If you can see a creature’s mouth while it is speaking " +
                "a language you understand, you can interpret what it’s " +
                "saying by reading its lips.\n" +
                "- You have a +5 bonus to your passive Wisdom " +
                "(Perception) and passive Intelligence (Investigation) " +
                "scores.";
    }
}
