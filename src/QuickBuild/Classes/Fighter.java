package QuickBuild.Classes;
import QuickBuild.Player.CharacterController;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Fighter implements Classes {

    private Map<String, Integer> scores = new LinkedHashMap<>();

    public Map<String, Integer> applyModifiers(List<Integer> baseStats){
        Collections.sort(baseStats);
        scores.put("STR", baseStats.get(5));
        scores.put("DEX", baseStats.get(1));
        scores.put("CON", baseStats.get(4));
        scores.put("INT", baseStats.get(2));
        scores.put("WIS", baseStats.get(3));
        scores.put("CHA", baseStats.get(0));
        return scores;
    }

    public void classProfs(Set<String> profs, CharacterController control){
        profs.addAll(fighterProfs);
        Set<String> profOptions = new HashSet<>();
        for(String curr: fighterSkills){
            if(!profs.contains(curr))
                profOptions.add(curr);
        }
        control.addClassProfs(profs, profOptions);
        control.addClassProfs(profs, profOptions);
    }

    public Integer rollHitDie(){
        return ThreadLocalRandom.current().nextInt(1, 11);
    }

    public Integer baseHealth(){
        return 10;
    }
}
