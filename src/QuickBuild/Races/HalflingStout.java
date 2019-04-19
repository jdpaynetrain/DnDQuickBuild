package QuickBuild.Races;
import java.util.*;

public class HalflingStout implements Races {

    public Set<String> racialProfs() {
        return new HashSet<>();
    }

    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Halfling"));
    }

    public void applyBuffs(Map<String, Integer> stats){
        stats.put("DEX", stats.get("DEX") + 2);
        stats.put("CON", stats.get("CON") + 1);
    }
}
