package QuickBuild.Races;
import java.util.*;

public class Tiefling implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("INT", Math.min(stats.get("INT") + 1, 20));
        stats.put("CHA", Math.min(stats.get("CHA") + 2, 20));
    }
    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Infernal"));
    }

    public Set<String> racialProfs(){
        return new HashSet<>();
    }
}
