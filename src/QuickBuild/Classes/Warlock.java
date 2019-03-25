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
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 2; i++) {
            Character.printToUser("Choose a skill to have proficiency in:");
            Character.printToUser(warlockSkills.toString());
            String userProf = sc.nextLine();
            while (!warlockSkills.contains(userProf) || profs.contains(userProf)) {
                if (profs.contains(userProf)) {
                    Character.printToUser("You already have proficiency. Choose " +
                            "another");
                    Character.printToUser(warlockSkills.toString());
                } else {
                    Character.printToUser("That is not an option. Choose another");
                    Character.printToUser(warlockSkills.toString());
                }
                userProf = sc.nextLine();
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
