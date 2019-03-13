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
        System.out.println("Choose a language other than Common to know" +
                           " Options are:");
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
