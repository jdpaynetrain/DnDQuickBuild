package QuickBuild.Races;
import java.util.*;

public class HalfOrc implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("CON", Math.min(stats.get("CON") + 1, 20));
        stats.put("STR", Math.min(stats.get("STR") + 2, 20));
    }
    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Orc"));
    }

    public Set<String> racialProfs(){
        return new HashSet<>(Arrays.asList("Intimidation"));
    }
}
