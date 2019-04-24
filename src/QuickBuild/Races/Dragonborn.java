package QuickBuild.Races;
import java.util.*;

public class Dragonborn implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("STR", stats.get("STR") + 2);
        stats.put("CHA", stats.get("CHA") + 1);
    }
    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Draconic"));
    }

    public Set<String> racialProfs(){
        return new HashSet<>();
    }
}
