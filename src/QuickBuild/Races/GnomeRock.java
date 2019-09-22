package QuickBuild.Races;
import QuickBuild.Player.CharacterController;

import java.util.*;

public class GnomeRock implements Races {
    public void applyBuffs(Map<String, Integer> stats, CharacterController control){
        stats.put("INT", stats.get("INT") + 2);
        stats.put("CON", stats.get("CON") + 1);
    }
    public Set<String> racialLanguages(CharacterController control){
        return new HashSet<>(Arrays.asList("Common", "Gnomish"));
    }

    public Set<String> racialProfs(CharacterController control){
        return new HashSet<>(Arrays.asList("Tinker's Tools"));
    }
}
