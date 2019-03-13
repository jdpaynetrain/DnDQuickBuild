package QuickBuild.Classes;
import java.util.*;

public class Monk implements Classes {
    private Map<String, Integer> scores = new LinkedHashMap<>();

    public Map<String, Integer> applyModifiers(List<Integer> baseStats){
        Collections.sort(baseStats);
        scores.put("STR", baseStats.get(0));
        scores.put("DEX", baseStats.get(5));
        scores.put("CON", baseStats.get(3));
        scores.put("INT", baseStats.get(1));
        scores.put("WIS", baseStats.get(4));
        scores.put("CHA", baseStats.get(2));
        return scores;
    }

    public void classProfs(Set<String> profs){
        profs.addAll(Arrays.asList("Light Armor", "All Simple Weapons"));
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a skill to have proficiency in:");
        System.out.println(skillProfs);
        String userProf = sc.nextLine();
        while(!skillProfs.contains(userProf) || profs.contains(userProf)){
            if(profs.contains(userProf)){
                System.out.println("You already have proficiency. Choose " +
                        "another");
                System.out.println(skillProfs);
            }
            else{
                System.out.println("That is not an option. Choose another");
                System.out.println(skillProfs);
            }
            userProf = sc.nextLine();
        }
        profs.add(userProf);

        System.out.println("Choose another skill to have proficiency in:");
        System.out.println(skillProfs);
        userProf = sc.nextLine();
        while(!skillProfs.contains(userProf) || profs.contains(userProf)){
            if(profs.contains(userProf)){
                System.out.println("You already have proficiency. Choose " +
                        "another");
                System.out.println(skillProfs);
            }
            else{
                System.out.println("That is not an option. Choose another");
                System.out.println(skillProfs);
            }
            userProf = sc.nextLine();
        }
        profs.add(userProf);
    }
}
