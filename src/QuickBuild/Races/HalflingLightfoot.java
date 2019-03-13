package QuickBuild.Races;
import java.util.*;

public class HalflingLightfoot implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("DEX", Math.min(stats.get("DEX") + 2, 20));
        stats.put("CHA", Math.min(stats.get("CHA") + 1, 20));
    }
    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Halfling"));
    }

    public Set<String> racialProfs(){
        return new HashSet<>();
    }
}
