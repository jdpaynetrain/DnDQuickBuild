package QuickBuild.Races;
import java.util.*;
import QuickBuild.Character;

public class HalfElf implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("CHA", stats.get("CHA") + 2);

        Set<String> statOptions = new HashSet<>();
        for(String curr: allAttributes){
            if(stats.get(curr) < 20)
                statOptions.add(curr);
        }
        Races.printStuff("Choose an ability score to increase by 1");
        Races.printStuff(statOptions.toString());
        String newStat = Races.getLine();
        while(!statOptions.contains(newStat)){
                Races.printStuff("Choice must be one of the following:");
                Races.printStuff(statOptions.toString());
            newStat = Races.getLine();
        }
        stats.put(newStat, stats.get(newStat) + 1);

        if(stats.get(newStat).equals(20))
            statOptions.remove(newStat);

        Races.printStuff("Choose an ability score to increase by 1");
        Races.printStuff(statOptions.toString());
        newStat = Races.getLine();
        while(!statOptions.contains(newStat)){
            Races.printStuff("Choice must be one of the following:");
            Races.printStuff(statOptions.toString());
            newStat = Races.getLine();
        }
        stats.put(newStat, stats.get(newStat) + 1);
    }

    public Set<String> racialLanguages(){
        Set<String> lang = new HashSet<>(Arrays.asList("Common", "Elvish"));
        Set<String> langOptions = new HashSet<>();
        for(String curr: allLanguages){
            if(!lang.contains(curr))
                langOptions.add(curr);
        }
        Races.printStuff("Choose a language to learn. Options are:");
        Races.printStuff(langOptions.toString());
        String userLang = Races.getLine();
        while(!langOptions.contains(userLang)){
                Races.printStuff("That language is not an option. Choose " +
                        "another");
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
