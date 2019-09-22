package QuickBuild.Races;
import QuickBuild.Player.CharacterController;

import java.util.*;

public class HalfElf implements Races {
    public void applyBuffs(Map<String, Integer> stats, CharacterController control){
        stats.put("CHA", stats.get("CHA") + 2);

        Set<String> statOptions = new HashSet<>();
        for(String curr: allAttributes){
            if(stats.get(curr) < 20)
                statOptions.add(curr);
        }
        control.applyRaceBuffs(stats, statOptions);

        statOptions.clear();
        for(String curr: allAttributes){
            if(stats.get(curr) < 20)
                statOptions.add(curr);
        }
        control.applyRaceBuffs(stats, statOptions);
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
        return new HashSet<>();
    }
}
