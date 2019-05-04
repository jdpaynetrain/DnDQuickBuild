package QuickBuild.Races;

import java.util.*;

public class DwarfHill implements Races {
    public Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Dwarvish"));
    }

    public void applyBuffs(Map<String, Integer> stats){
        stats.put("CON", stats.get("CON") + 2);
        stats.put("WIS", stats.get("WIS") + 1);
    }

    public Set<String> racialProfs(){
        Set<String> profs = new HashSet<>(Arrays.asList("Battleaxe", "Handaxe",
                "Throwing Hammer", "Warhammer"));
        Races.printStuff("Choose an artisan tool to have proficiency with");
        Races.printStuff(artisansTools.toString());
        String userTool = Races.getLine();
        while(!artisansTools.contains(userTool)){
            Races.printStuff("Tool must be one of the following");
            Races.printStuff(artisansTools.toString());
            userTool = Races.getLine();
        }
        profs.add(userTool);

        return profs;
    }
}
