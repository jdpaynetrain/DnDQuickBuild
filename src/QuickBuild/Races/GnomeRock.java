package QuickBuild.Races;
import java.util.*;

public class GnomeRock implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("INT", Math.min(stats.get("INT") + 2, 20));
        stats.put("CON", Math.min(stats.get("CON") + 1, 20));
    }
    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Gnomish"));
    }

    public Set<String> racialProfs(){
        return new HashSet<>(Arrays.asList("Tinker's Tools"));
    }
}
