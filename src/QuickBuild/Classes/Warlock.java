package QuickBuild.Classes;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import QuickBuild.Character;

public class Warlock implements IWarlock {
    private Map<String, Integer> scores = new LinkedHashMap<>();

    public Map<String, Integer> applyModifiers(List<Integer> baseStats){
        Collections.sort(baseStats);
        scores.put("STR", baseStats.get(0));
        scores.put("DEX", baseStats.get(3));
        scores.put("CON", baseStats.get(4));
        scores.put("INT", baseStats.get(2));
        scores.put("WIS", baseStats.get(1));
        scores.put("CHA", baseStats.get(5));
        return scores;
    }

    public void classProfs(Set<String> profs) {
        profs.addAll(warlockProfs);
        for(int i = 0; i < 2; i++) {
            Classes.printStuff("Choose a skill to have proficiency in:");
            Classes.printStuff(warlockSkills.toString());
            String userProf = Classes.getLine();
            while (!warlockSkills.contains(userProf) || profs.contains(userProf)) {
                if (profs.contains(userProf)) {
                    Classes.printStuff("You already have proficiency. Choose " +
                            "another");
                    Classes.printStuff(warlockSkills.toString());
                } else {
                    Classes.printStuff("That is not an option. Choose another");
                    Classes.printStuff(warlockSkills.toString());
                }
                userProf = Classes.getLine();
            }
            profs.add(userProf);
        }
    }

    public Integer rollHitDie(){
        return ThreadLocalRandom.current().nextInt(1, 9);
    }

    public Integer baseHealth(){
        return 8;
    }
}
