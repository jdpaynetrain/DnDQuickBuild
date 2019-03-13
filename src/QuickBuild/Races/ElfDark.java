package QuickBuild.Races;
import java.util.*;

public class ElfDark implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("DEX", Math.min(stats.get("DEX") + 2, 20));
        stats.put("CHA", Math.min(stats.get("CHA") + 1, 20));
    }
    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Elvish"));
    }

    public Set<String> racialProfs(){
        return new HashSet<>(Arrays.asList("Perception", "Rapiers",
                "Shortswords", "Hand Crossbows"));
    }
}
