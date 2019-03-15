package QuickBuild.Races;

import java.util.*;

public class DwarfHill implements IDwarf {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("CON", Math.min(stats.get("CON") + 2, 20));
        stats.put("WIS", Math.min(stats.get("WIS") + 1, 20));
    }

    public Set<String> racialProfs(){
        Scanner sc = new Scanner(System.in);
        Set<String> profs = new HashSet<>(Arrays.asList("Battleaxe", "Handaxe",
                "Throwing Hammer", "Warhammer"));
        System.out.println("Choose an artisan tool to have proficiency with");
        System.out.println(artisansTools);
        String userTool = sc.nextLine();
        while(!artisansTools.contains(userTool)){
            System.out.println("Tool must be one of the following");
            System.out.println(artisansTools);
            userTool = sc.nextLine();
        }
        profs.add(userTool);

        return profs;
    }
}
