package QuickBuild.Races;
import java.util.*;

public class Human implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        for(Map.Entry<String, Integer> entry: stats.entrySet())
            stats.put(entry.getKey(), entry.getValue() + 1);
    }
    public Set<String> racialLanguages(){
        Set<String> lang = new HashSet<>();
        lang.add("Common");
        Set<String> langOptions = new HashSet<>();

        for(String curr: allLanguages){
            if(!lang.contains(curr))
                langOptions.add(curr);
        }

        Races.printStuff("Choose a language to learn:");
        Races.printStuff(langOptions.toString());
        String userLang = Races.getLine();
        while(!langOptions.contains(userLang)){
            Races.printStuff("That language is not an option. " +
                    "Choose another");
            Races.printStuff(langOptions.toString());
            userLang = Races.getLine();
        }
        lang.add(userLang);

        return lang;
    }

    public Set<String> racialProfs(){
        return new HashSet<>();
    }
}
