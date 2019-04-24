package QuickBuild.Races;
import java.util.*;
public class ElfWood implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("DEX", stats.get("DEX") + 2);
        stats.put("WIS", stats.get("WIS") + 1);
    }
    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Elvish"));
    }

    public Set<String> racialProfs(){
        return new HashSet<>(Arrays.asList("Perception", "Longswords",
                "Shortswords", "Shortbows", "Longbows"));
    }
}


