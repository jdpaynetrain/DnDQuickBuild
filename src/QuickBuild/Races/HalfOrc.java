package QuickBuild.Races;
import java.util.*;

public class HalfOrc implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("CON", stats.get("CON") + 1);
        stats.put("STR", stats.get("STR") + 2);
    }
    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Orc"));
    }

    public Set<String> racialProfs(){
        return new HashSet<>(Arrays.asList("Intimidation"));
    }
}
