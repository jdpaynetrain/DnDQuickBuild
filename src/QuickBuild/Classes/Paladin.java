package QuickBuild.Classes;
import java.util.*;

public class Paladin implements IPaladin {
    private Map<String, Integer> scores = new LinkedHashMap<>();

    public Map<String, Integer> applyModifiers(List<Integer> baseStats){
        Collections.sort(baseStats);
        scores.put("STR", baseStats.get(5));
        scores.put("DEX", baseStats.get(0));
        scores.put("CON", baseStats.get(3));
        scores.put("INT", baseStats.get(1));
        scores.put("WIS", baseStats.get(2));
        scores.put("CHA", baseStats.get(4));
        return scores;
    }

    public void classProfs(Set<String> profs) {
        profs.addAll(paladinProfs);
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 2; i++) {
            System.out.println("Choose a skill to have proficiency in:");
            System.out.println(paladinSkills);
            String userProf = sc.nextLine();
            while (!paladinSkills.contains(userProf) || profs.contains(userProf)) {
                if (profs.contains(userProf)) {
                    System.out.println("You already have proficiency. Choose " +
                            "another");
                    System.out.println(paladinSkills);
                } else {
                    System.out.println("That is not an option. Choose another");
                    System.out.println(paladinSkills);
                }
                userProf = sc.nextLine();
            }
            profs.add(userProf);
        }
    }
}
