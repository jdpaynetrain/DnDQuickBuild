package QuickBuild.Races;
import java.util.*;

public class ElfHigh implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("DEX", stats.get("DEX") + 2);
        stats.put("INT", stats.get("INT") + 1);
    }
    public Set<String> racialLanguages(){
        Set<String> lang = new HashSet<>(Arrays.asList("Common", "Elvish"));
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
        return new HashSet<>(Arrays.asList("Perception", "Longswords",
                "Shortswords", "Shortbows", "Longbows"));
    }
}
