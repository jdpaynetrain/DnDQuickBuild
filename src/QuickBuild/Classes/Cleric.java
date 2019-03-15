package QuickBuild.Classes;
import java.util.*;

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
            System.out.println("Choose a skill to have proficiency in:");
            System.out.println(clericSkills);
            String userProf = sc.nextLine();
            while (!clericSkills.contains(userProf) || profs.contains(userProf)) {
                if (profs.contains(userProf)) {
                    System.out.println("You already have proficiency. Choose " +
                            "another");
                    System.out.println(clericSkills);
                } else {
                    System.out.println("That is not an option. Choose another");
                    System.out.println(clericSkills);
                }
                userProf = sc.nextLine();
            }
            profs.add(userProf);
        }
    }
}
