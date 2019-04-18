package QuickBuild.Races;
import java.util.*;
import QuickBuild.Character;

public class Human implements Races {
    public void applyBuffs(Map<String, Integer> stats){
        for(Map.Entry<String, Integer> entry: stats.entrySet())
            stats.put(entry.getKey(), entry.getValue() + 1);
    }
    public Set<String> racialLanguages(){
        Set<String> lang = new HashSet<>();
        lang.add("Common");
        Character.printToUser("Choose a language other than Common to know" +
                           " Options are:");
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
