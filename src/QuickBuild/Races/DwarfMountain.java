package QuickBuild.Races;

import java.util.*;
import QuickBuild.Character;

public class DwarfMountain implements Races {

    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Dwarvish"));
    }
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("CON", Math.min(stats.get("CON") + 2, 20));
        stats.put("STR", Math.min(stats.get("STR") + 2, 20));
    }

    public Set<String> racialProfs(){
        Scanner sc = new Scanner(System.in);
        Set<String> profs = new HashSet<>(Arrays.asList("Battleaxe", "Handaxe",
                "Throwing Hammer", "Warhammer", "Light Armor", "Heavy Armor"));
        Character.printToUser("Choose an artisan tool to have proficiency with");
        Character.printToUser(artisansTools.toString());
        String userTool = sc.nextLine();
        while(!artisansTools.contains(userTool)){
            Character.printToUser("Tool must be one of the following");
            Character.printToUser(artisansTools.toString());
            userTool = sc.nextLine();
        }
        profs.add(userTool);

        return profs;
    }
}
