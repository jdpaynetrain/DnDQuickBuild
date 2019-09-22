package QuickBuild.Races;
import QuickBuild.Player.CharacterController;

import java.util.*;

public class Human implements Races {
    public void applyBuffs(Map<String, Integer> stats, CharacterController control){
        for(Map.Entry<String, Integer> entry: stats.entrySet())
            stats.put(entry.getKey(), entry.getValue() + 1);
    }
    public Set<String> racialLanguages(CharacterController control){
        Set<String> lang = new HashSet<>();
        lang.add("Common");
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
