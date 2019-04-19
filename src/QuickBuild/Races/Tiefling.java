package QuickBuild.Races;
import java.util.*;

public class Tiefling implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("INT", stats.get("INT") + 1);
        stats.put("CHA", stats.get("CHA") + 2);
    }
    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Infernal"));
    }

    public Set<String> racialProfs(){
        return new HashSet<>();
    }
}
