package QuickBuild.Races;

import QuickBuild.Player.CharacterController;

import java.util.*;

public class DwarfHill implements Races {
    public Set<String> racialLanguages(CharacterController control){
        return new HashSet<>(Arrays.asList("Common", "Dwarvish"));
    }

    public void applyBuffs(Map<String, Integer> stats, CharacterController control){
        stats.put("CON", stats.get("CON") + 2);
        stats.put("WIS", stats.get("WIS") + 1);
    }

    public Set<String> racialProfs(CharacterController control){
        Set<String> profs = new HashSet<>(Arrays.asList("Battleaxe", "Handaxe",
                "Throwing Hammer", "Warhammer"));
        control.addRacialProfs(profs, artisansTools);

        return profs;
    }
}
