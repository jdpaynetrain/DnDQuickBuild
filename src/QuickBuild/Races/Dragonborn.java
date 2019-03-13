package QuickBuild.Races;
import java.util.*;

public class Dragonborn implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("STR", Math.min(stats.get("STR") + 2, 20));
        stats.put("CHA", Math.min(stats.get("CHA") + 1, 20));
    }
    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Draconic"));
    }

    public Set<String> racialProfs(){
        return new HashSet<>();
    }
}
