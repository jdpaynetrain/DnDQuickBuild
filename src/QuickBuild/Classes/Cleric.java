package QuickBuild.Classes;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import QuickBuild.Character;

public class Cleric implements ICleric {

    private Map<String, Integer> scores = new LinkedHashMap<>();

    public Map<String, Integer> applyModifiers(List<Integer> baseStats){
        Collections.sort(baseStats);
        scores.put("STR", baseStats.get(1));
        scores.put("DEX", baseStats.get(4));
        scores.put("CON", baseStats.get(3));
        scores.put("INT", baseStats.get(0));
        scores.put("WIS", baseStats.get(5));
        scores.put("CHA", baseStats.get(2));
        return scores;
    }

    public void classProfs(Set<String> profs){
        profs.addAll(clericProfs);
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 2; i++) {
            Character.printToUser("Choose a skill to have proficiency in:");
            Character.printToUser(clericSkills.toString());
            String userProf = sc.nextLine();
            while (!clericSkills.contains(userProf) || profs.contains(userProf)) {
                if (profs.contains(userProf)) {
                    Character.printToUser("You already have proficiency. Choose " +
                            "another");
                    Character.printToUser(clericSkills.toString());
                } else {
                    Character.printToUser("That is not an option. Choose another");
                    Character.printToUser(clericSkills.toString());
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
