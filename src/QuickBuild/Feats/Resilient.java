package QuickBuild.Feats;
import QuickBuild.Player.Character;
import QuickBuild.Player.CharacterController;
import java.util.*;

public class Resilient implements IFeats {

    public void updateStats(Character person, CharacterController control){
        Set<String> statOptions = new HashSet<>();
        for(String curr: Character.allScores){
            if(person.getStat(curr) < 20)
                statOptions.add(curr);
        }
        control.applyFeatStats(person, statOptions);
    }

    public String featDescription(){
        return "Choose one ability score. You gain the following benefits:\n" +
                "- Increase the chosen ability score by 1, to a maximum " +
                "of 20.\n" +
                "- You gain proficiency in saving throws using the " +
                "chosen ability.";
    }
}
