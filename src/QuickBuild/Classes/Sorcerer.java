package QuickBuild.Classes;
import java.util.*;

public class Sorcerer implements Classes {
    private static final Set<String> skillProfs = new HashSet<>
            (Arrays.asList("Arcana", "Deception", "Insight", "Intimidation",
                    "Persuasion", "Religion"));
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
        profs.addAll(Arrays.asList("Daggers", "Darts", "Slings",
                "Quarterstaffs", "Light Crossbows"));
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 2; i++) {
            System.out.println("Choose a skill to have proficiency in:");
            System.out.println(skillProfs);
            String userProf = sc.nextLine();
            while (!skillProfs.contains(userProf) || profs.contains(userProf)) {
                if (profs.contains(userProf)) {
                    System.out.println("You already have proficiency. Choose " +
                            "another");
                    System.out.println(skillProfs);
                } else {
                    System.out.println("That is not an option. Choose another");
                    System.out.println(skillProfs);
                }
                userProf = sc.nextLine();
            }
            profs.add(userProf);
        }
    }
}
