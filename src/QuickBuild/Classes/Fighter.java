package QuickBuild.Classes;
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

    public void classProfs(Set<String> profs){
        profs.addAll(fighterProfs);
        Set<String> profOptions = new HashSet<>();
        for(String curr: fighterSkills){
            if(!profs.contains(curr))
                profOptions.add(curr);
        }
        for(int i = 0; i < 2; i++) {
            Classes.printStuff("Choose a skill to have proficiency in:");
            Classes.printStuff(profOptions.toString());
            String userProf = Classes.getLine();
            while (!profOptions.contains(userProf)) {
                Classes.printStuff("That is not an option. Choose another");
                Classes.printStuff(profOptions.toString());
                userProf = Classes.getLine();
            }
            profOptions.remove(userProf);
            profs.add(userProf);
        }
    }

    public Integer rollHitDie(){
        return ThreadLocalRandom.current().nextInt(1, 11);
    }

    public Integer baseHealth(){
        return 10;
    }
}
