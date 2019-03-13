package QuickBuild.Classes;
import java.util.*;

public class Bard implements Classes {
    private Map<String, Integer> scores = new LinkedHashMap<>();

    public Map<String, Integer> applyModifiers(List<Integer> baseStats){
        Collections.sort(baseStats);
        scores.put("STR", baseStats.get(1));
        scores.put("DEX", baseStats.get(4));
        scores.put("CON", baseStats.get(3));
        scores.put("INT", baseStats.get(0));
        scores.put("WIS", baseStats.get(2));
        scores.put("CHA", baseStats.get(5));
        return scores;
    }

    public void classProfs(Set<String> profs){
        profs.addAll(Arrays.asList("Light Armor", "Simple Weapons",
                "Hand Crossbows", "Longswords", "Rapiers", "Shortswords"));
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a skill to have proficiency in:");
        System.out.println(allSkills);
        String userProf = sc.nextLine();
        while(!allSkills.contains(userProf) || profs.contains(userProf)){
            if(profs.contains(userProf)){
                System.out.println("You already have proficiency. Choose " +
                        "another");
                System.out.println(allSkills);
            }
            else{
                System.out.println("That is not an option. Choose another");
                System.out.println(allSkills);
            }
            userProf = sc.nextLine();
        }
        profs.add(userProf);

        System.out.println("Choose another skill to have proficiency in:");
        System.out.println(allSkills);
        userProf = sc.nextLine();
        while(!allSkills.contains(userProf) || profs.contains(userProf)){
            if(profs.contains(userProf)){
                System.out.println("You already have proficiency. Choose " +
                        "another");
                System.out.println(allSkills);
            }
            else{
                System.out.println("That is not an option. Choose another");
                System.out.println(allSkills);
            }
            userProf = sc.nextLine();
        }
        profs.add(userProf);

        System.out.println("Choose another skill to have proficiency in:");
        System.out.println(allSkills);
        userProf = sc.nextLine();
        while(!allSkills.contains(userProf) || profs.contains(userProf)){
            if(profs.contains(userProf)){
                System.out.println("You already have proficiency. Choose " +
                        "another");
                System.out.println(allSkills);
            }
            else{
                System.out.println("That is not an option. Choose another");
                System.out.println(allSkills);
            }
            userProf = sc.nextLine();
        }
        profs.add(userProf);
    }
}
