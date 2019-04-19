package QuickBuild.Classes;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import QuickBuild.Character;

public class Ranger implements IRanger {
    private Map<String, Integer> scores = new LinkedHashMap<>();

    public Map<String, Integer> applyModifiers(List<Integer> baseStats){
        Collections.sort(baseStats);
        scores.put("STR", baseStats.get(1));
        scores.put("DEX", baseStats.get(5));
        scores.put("CON", baseStats.get(4));
        scores.put("INT", baseStats.get(2));
        scores.put("WIS", baseStats.get(3));
        scores.put("CHA", baseStats.get(0));
        return scores;
    }

    public void classProfs(Set<String> profs) {
        profs.addAll(rangerProfs);
        for(int i = 0; i < 3; i++) {
            Classes.printStuff("Choose a skill to have proficiency in:");
            Classes.printStuff(rangerSkills.toString());
            String userProf = Classes.getLine();
            while (!rangerSkills.contains(userProf) || profs.contains(userProf)) {
                if (profs.contains(userProf)) {
                    Classes.printStuff("You already have proficiency. Choose " +
                            "another");
                    Classes.printStuff(rangerSkills.toString());
                } else {
                    Classes.printStuff("That is not an option. Choose another");
                    Classes.printStuff(rangerSkills.toString());
                }
                userProf = Classes.getLine();
            }
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
