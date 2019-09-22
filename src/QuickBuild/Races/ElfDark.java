package QuickBuild.Races;
import QuickBuild.Player.CharacterController;

import java.util.*;

public class ElfDark implements Races {
    public void applyBuffs(Map<String, Integer> stats, CharacterController control){
        stats.put("DEX", stats.get("DEX") + 2);
        stats.put("CHA", stats.get("CHA") + 1);
    }
    public Set<String> racialLanguages(CharacterController control){
        return new HashSet<>(Arrays.asList("Common", "Elvish"));
    }

    public Set<String> racialProfs(CharacterController control){
        return new HashSet<>(Arrays.asList("Perception", "Rapiers",
                "Shortswords", "Hand Crossbows"));
    }
}
