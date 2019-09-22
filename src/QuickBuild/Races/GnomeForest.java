package QuickBuild.Races;
import QuickBuild.Player.CharacterController;

import java.util.*;

public class GnomeForest implements Races {
    public void applyBuffs(Map<String, Integer> stats, CharacterController control){
        stats.put("INT", stats.get("INT") + 2);
        stats.put("DEX", stats.get("DEX") + 1);
    }
    public Set<String> racialLanguages(CharacterController control){
        return new HashSet<>(Arrays.asList("Common", "Gnomish"));
    }

    public Set<String> racialProfs(CharacterController control){
        return new HashSet<>();
    }
}
