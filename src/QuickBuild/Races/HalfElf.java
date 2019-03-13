package QuickBuild.Races;
import java.util.*;

public class HalfElf implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        Scanner sc = new Scanner(System.in);
        stats.put("CHA", Math.min(stats.get("CHA") + 2, 20));

        System.out.println("Choose an ability score to increase by 1");
        System.out.println(allAttributes);
        String newStat = sc.nextLine();
        while(!allAttributes.contains(newStat) || stats.get(newStat) + 1 > 20){
            if(allAttributes.contains(newStat)){
                System.out.println("Ability scores can only go to 20, " +
                        "choose another");
            }
            else {
                System.out.println("Choice must be one of the following:");
                System.out.println(allAttributes);
            }
            newStat = sc.nextLine();
        }
        stats.put(newStat, Math.min(stats.get(newStat) + 1, 20));

        System.out.println("Choose another ability score to increase by 1");
        System.out.println(allAttributes);
        newStat = sc.nextLine();
        while(!allAttributes.contains(newStat) || stats.get(newStat) + 1 > 20){
            if(allAttributes.contains(newStat)){
                System.out.println("Ability scores can only go to 20, " +
                        "choose another");
            }
            else {
                System.out.println("Choice must be one of the following:");
                System.out.println(allAttributes);
            }
            newStat = sc.nextLine();
        }
        stats.put(newStat, Math.min(stats.get(newStat) + 1, 20));
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
        return new HashSet<>();
    }
}
