package QuickBuild.Races;
import QuickBuild.Player.CharacterController;

import java.util.*;

public class HalfOrc implements Races {
    public void applyBuffs(Map<String, Integer> stats, CharacterController control){
        stats.put("CON", stats.get("CON") + 1);
        stats.put("STR", stats.get("STR") + 2);
    }
    public Set<String> racialLanguages(CharacterController control){
        return new HashSet<>(Arrays.asList("Common", "Orc"));
    }

    public Set<String> racialProfs(CharacterController control){
        return new HashSet<>(Arrays.asList("Intimidation"));
    }
}
