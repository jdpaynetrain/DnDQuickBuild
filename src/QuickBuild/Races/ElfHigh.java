package QuickBuild.Races;
import java.util.*;
import QuickBuild.Character;

public class ElfHigh implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("DEX", Math.min(stats.get("DEX") + 2, 20));
        stats.put("INT", Math.min(stats.get("INT") + 1, 20));
    }
    public Set<String> racialLanguages(){
        Set<String> lang = new HashSet<>(Arrays.asList("Common", "Elvish"));
        Character.printToUser("Choose a language other than Common and " +
                "Elvish to know. Options are:");
        Character.printToUser(allLanguages.toString());
        Scanner sc = new Scanner(System.in);
        String userLang = sc.nextLine();
        while(!allLanguages.contains(userLang) || lang.contains(userLang)){
            if(lang.contains(userLang)){
                Character.printToUser("You already know that language. " +
                        "Choose another");
                Character.printToUser(allLanguages.toString());
            }
            else{
                Character.printToUser("That language is not an option. " +
                        "Choose another");
                Character.printToUser(allLanguages.toString());
            }
            userLang = sc.nextLine();
        }

        lang.add(userLang);

        return lang;
    }

    public Set<String> racialProfs(){
        return new HashSet<>(Arrays.asList("Perception", "Longswords",
                "Shortswords", "Shortbows", "Longbows"));
    }
}
