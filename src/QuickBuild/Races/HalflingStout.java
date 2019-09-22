package QuickBuild.Races;
import QuickBuild.Player.CharacterController;

import java.util.*;

public class HalflingStout implements Races {

    public Set<String> racialProfs(CharacterController control) {
        return new HashSet<>();
    }

    public Set<String> racialLanguages(CharacterController control){
        return new HashSet<>(Arrays.asList("Common", "Halfling"));
    }

    public void applyBuffs(Map<String, Integer> stats, CharacterController control){
        stats.put("DEX", stats.get("DEX") + 2);
        stats.put("CON", stats.get("CON") + 1);
    }
}
