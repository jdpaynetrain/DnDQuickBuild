package QuickBuild.Races;
import java.util.*;

public class ElfHigh implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        stats.put("DEX", Math.min(stats.get("DEX") + 2, 20));
        stats.put("INT", Math.min(stats.get("INT") + 1, 20));
    }
    public Set<String> racialLanguages(){
        Set<String> lang = new HashSet<>(Arrays.asList("Common", "Elvish"));
        System.out.println("Choose a language other than Common and " +
                "Elvish to know. Options are:");
        System.out.println(allLanguages);
        Scanner sc = new Scanner(System.in);
        String userLang = sc.nextLine();
        while(!allLanguages.contains(userLang) || lang.contains(userLang)){
            if(lang.contains(userLang)){
                System.out.println("You already know that language. " +
                        "Choose another");
                System.out.println(allLanguages);
            }
            else{
                System.out.println("That language is not an option. " +
                        "Choose another");
                System.out.println(allLanguages);
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
