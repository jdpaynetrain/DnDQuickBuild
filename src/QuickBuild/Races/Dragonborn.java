package QuickBuild.Races;

import QuickBuild.Player.CharacterController;

import java.util.*;

public class Dragonborn implements Races {
    public void applyBuffs(Map<String, Integer> stats, CharacterController control){
        stats.put("STR", stats.get("STR") + 2);
        stats.put("CHA", stats.get("CHA") + 1);
    }
    public Set<String> racialLanguages(CharacterController control){
        return new HashSet<>(Arrays.asList("Common", "Draconic"));
    }

    public Set<String> racialProfs(CharacterController control){
        return new HashSet<>();
    }
}
