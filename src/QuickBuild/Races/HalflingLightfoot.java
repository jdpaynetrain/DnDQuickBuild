package QuickBuild.Races;
import java.util.*;

public class HalflingLightfoot implements IHalfling {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("DEX", Math.min(stats.get("DEX") + 2, 20));
        stats.put("CHA", Math.min(stats.get("CHA") + 1, 20));
    }
}
