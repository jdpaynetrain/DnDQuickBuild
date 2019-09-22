package QuickBuild.Races;
import QuickBuild.Player.CharacterController;

import java.util.*;

public class ElfHigh implements Races {
    public void applyBuffs(Map<String, Integer> stats, CharacterController control){
        stats.put("DEX", stats.get("DEX") + 2);
        stats.put("INT", stats.get("INT") + 1);
    }
    public Set<String> racialLanguages(CharacterController control){
        Set<String> lang = new HashSet<>(Arrays.asList("Common", "Elvish"));
        Set<String> langOptions = new HashSet<>();
        for(String curr: allLanguages){
            if(!lang.contains(curr))
                langOptions.add(curr);
        }
        control.addRacialLanguages(lang, langOptions);
        return lang;
    }

    public Set<String> racialProfs(CharacterController control){
        return new HashSet<>(Arrays.asList("Perception", "Longswords",
                "Shortswords", "Shortbows", "Longbows"));
    }
}
