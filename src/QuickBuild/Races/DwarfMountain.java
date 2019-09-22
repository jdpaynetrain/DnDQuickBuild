package QuickBuild.Races;

import QuickBuild.Player.CharacterController;

import java.util.*;

public class DwarfMountain implements Races {

    public Set<String> racialLanguages(CharacterController control){
        return new HashSet<>(Arrays.asList("Common", "Dwarvish"));
    }
    public void applyBuffs(Map<String, Integer> stats, CharacterController control){
        stats.put("CON", Math.min(stats.get("CON") + 2, 20));
        stats.put("STR", Math.min(stats.get("STR") + 2, 20));
    }

    public Set<String> racialProfs(CharacterController control){
        Set<String> profs = new HashSet<>(Arrays.asList("Battleaxe", "Handaxe",
                "Throwing Hammer", "Warhammer", "Light Armor", "Heavy Armor"));
        control.addRacialProfs(profs, artisansTools);

        return profs;
    }
}
