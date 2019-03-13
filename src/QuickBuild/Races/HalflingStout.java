package QuickBuild.Races;
import java.util.*;

public class HalflingStout implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("DEX", Math.min(stats.get("DEX") + 2, 20));
        stats.put("CON", Math.min(stats.get("CON") + 1, 20));
    }
    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Halfling"));
    }

    public Set<String> racialProfs(){
        return new HashSet<>();
    }
}
