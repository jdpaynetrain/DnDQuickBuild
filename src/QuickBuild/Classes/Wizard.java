package QuickBuild.Classes;
import QuickBuild.Player.CharacterController;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Wizard implements Classes {
    private Map<String, Integer> scores = new LinkedHashMap<>();

    public Map<String, Integer> applyModifiers(List<Integer> baseStats){
        Collections.sort(baseStats);
        scores.put("STR", baseStats.get(0));
        scores.put("DEX", baseStats.get(1));
        scores.put("CON", baseStats.get(4));
        scores.put("INT", baseStats.get(5));
        scores.put("WIS", baseStats.get(2));
        scores.put("CHA", baseStats.get(3));
        return scores;
    }

    public void classProfs(Set<String> profs, CharacterController control){
        profs.addAll(wizardProfs);
        Set<String> profOptions = new HashSet<>();
        for(String curr: wizardSkills){
            if(!profs.contains(curr))
                profOptions.add(curr);
        }
        control.addClassProfs(profs, profOptions);
        control.addClassProfs(profs, profOptions);
    }

    public Integer rollHitDie(){
        return ThreadLocalRandom.current().nextInt(1, 7);
    }

    public Integer baseHealth(){
        return 6;
    }
}
