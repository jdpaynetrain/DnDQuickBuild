package QuickBuild.Feats;
import QuickBuild.Character;
import QuickBuild.Races.Races;
import java.util.Scanner;

public class Linguist implements IFeats {
    public void updateStats(Character person){
        person.updateStat("INT", 1);
        for(int i = 0; i < 3; i++) {
            Scanner sc = new Scanner(System.in);
            Character.printToUser("Choose a language to learn.");
            Character.printToUser(Races.allLanguages.toString());
            String userLang = sc.nextLine();
            while(!Races.allLanguages.contains(userLang) || person.hasLang(userLang)){
                if(person.hasLang(userLang)) {
                    Character.printToUser("You already know this language.");
                }
                else {
                    Character.printToUser("That is not an option");
                }
                Character.printToUser("Choose another.");
                Character.printToUser(Races.allLanguages.toString());
                userLang = sc.nextLine();
            }
        }
    }

    public Boolean metPreReqs(Character person){
        return true;
    }
}
