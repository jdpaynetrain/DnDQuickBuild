package QuickBuild.Classes;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Wizard implements IWizard {
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

    public void classProfs(Set<String> profs) {
        profs.addAll(wizardProfs);
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 2; i++) {
            System.out.println("Choose a skill to have proficiency in:");
            System.out.println(wizardSkills);
            String userProf = sc.nextLine();
            while (!wizardSkills.contains(userProf) || profs.contains(userProf)) {
                if (profs.contains(userProf)) {
                    System.out.println("You already have proficiency. Choose " +
                            "another");
                    System.out.println(wizardSkills);
                } else {
                    System.out.println("That is not an option. Choose another");
                    System.out.println(wizardSkills);
                }
                userProf = sc.nextLine();
            }
            profs.add(userProf);
        }
    }

    public Integer rollHitDie(){
        return ThreadLocalRandom.current().nextInt(1, 7);
    }

    public Integer baseHealth(){
        return 6;
    }
}
