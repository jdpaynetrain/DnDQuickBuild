package QuickBuild.Classes;
import QuickBuild.Player.CharacterController;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Druid implements Classes {
    private Map<String, Integer> scores = new LinkedHashMap<>();

    public Map<String, Integer> applyModifiers(List<Integer> baseStats){
        Collections.sort(baseStats);
        scores.put("STR", baseStats.get(1));
        scores.put("DEX", baseStats.get(3));
        scores.put("CON", baseStats.get(4));
        scores.put("INT", baseStats.get(2));
        scores.put("WIS", baseStats.get(5));
        scores.put("CHA", baseStats.get(0));
        return scores;
    }

    public void classProfs(Set<String> profs, CharacterController control){
        profs.addAll(druidProfs);
        Set<String> profOptions = new HashSet<>();
        for(String curr: druidSkills){
            if(!profs.contains(curr))
                profOptions.add(curr);
        }
        control.addClassProfs(profs, profOptions);
        control.addClassProfs(profs, profOptions);
    }
    public Integer rollHitDie(){
        return ThreadLocalRandom.current().nextInt(1, 9);
    }

    public Integer baseHealth(){
        return 8;
    }
}
