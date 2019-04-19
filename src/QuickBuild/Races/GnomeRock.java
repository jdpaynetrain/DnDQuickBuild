package QuickBuild.Races;
import java.util.*;

public class GnomeRock implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("INT", stats.get("INT") + 2);
        stats.put("CON", stats.get("CON") + 1);
    }
    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Gnomish"));
    }

    public Set<String> racialProfs(){
        return new HashSet<>(Arrays.asList("Tinker's Tools"));
    }
}
