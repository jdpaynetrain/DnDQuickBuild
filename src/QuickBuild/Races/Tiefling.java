package QuickBuild.Races;
import QuickBuild.Player.CharacterController;

import java.util.*;

public class Tiefling implements Races {
    public void applyBuffs(Map<String, Integer> stats, CharacterController control){
        stats.put("INT", stats.get("INT") + 1);
        stats.put("CHA", stats.get("CHA") + 2);
    }
    public Set<String> racialLanguages(CharacterController control){
        return new HashSet<>(Arrays.asList("Common", "Infernal"));
    }

    public Set<String> racialProfs(CharacterController control){
        return new HashSet<>();
    }
}
