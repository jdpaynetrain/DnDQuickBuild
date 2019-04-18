package QuickBuild.Races;
import java.util.*;
import QuickBuild.Character;

public class HalfElf implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        Scanner sc = new Scanner(System.in);
        stats.put("CHA", Math.min(stats.get("CHA") + 2, 20));

        Character.printToUser("Choose an ability score to increase by 1");
        Character.printToUser(allAttributes.toString());
        String newStat = sc.nextLine();
        while(!allAttributes.contains(newStat) || stats.get(newStat) + 1 > 20){
            if(allAttributes.contains(newStat)){
                Character.printToUser("Ability scores can only go to 20, " +
                        "choose another");
            }
            else {
                Character.printToUser("Choice must be one of the following:");
                Character.printToUser(allAttributes.toString());
            }
            newStat = sc.nextLine();
        }
        stats.put(newStat, Math.min(stats.get(newStat) + 1, 20));

        Character.printToUser("Choose another ability score to increase by 1");
        Character.printToUser(allAttributes.toString());
        newStat = sc.nextLine();
        while(!allAttributes.contains(newStat) || stats.get(newStat) + 1 > 20){
            if(allAttributes.contains(newStat)){
                Character.printToUser("Ability scores can only go to 20, " +
                        "choose another");
            }
            else {
                Character.printToUser("Choice must be one of the following:");
                Character.printToUser(allAttributes.toString());
            }
            newStat = sc.nextLine();
        }
        stats.put(newStat, Math.min(stats.get(newStat) + 1, 20));
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
        return new HashSet<>();
    }
}
