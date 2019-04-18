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
            person.addLang(userLang);
        }
    }

    public String featDescription(){
        return "You have studied languages and codes, gaining the " +
                "following benefits:\n" +
                "- Increase your Intelligence score by 1, to a maximum " +
                "of 20.\n" +
                "- You learn three languages of your choice.\n" +
                "- You can ably create written ciphers. Others can’t " +
                "decipher a code you create unless you teach them, they " +
                "succeed on an Intelligence check (DC equal to your " +
                "Intelligence score + your proficiency bonus), or they " +
                "use magic to decipher it.";
    }
}
