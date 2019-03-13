package QuickBuild.Races;
import java.util.*;

public class GnomeForest implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("INT", Math.min(stats.get("INT") + 2, 20));
        stats.put("DEX", Math.min(stats.get("DEX") + 1, 20));
    }
    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Gnomish"));
    }

    public Set<String> racialProfs(){
        return new HashSet<>();
    }
}
