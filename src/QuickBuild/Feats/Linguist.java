package QuickBuild.Feats;
import QuickBuild.Character;
import QuickBuild.Races.Races;
import java.util.Set;
import java.util.HashSet;

public class Linguist implements IFeats {
    public void updateStats(Character person){
        person.updateStat("INT", 1);
        Set<String> langOptions = new HashSet<>();
        for(String curr: Races.allLanguages){
            if(!person.hasLang(curr))
                langOptions.add(curr);
        }
        for(int i = 0; i < 3; i++) {
            IFeats.printStuff("Choose a language to learn.");
            IFeats.printStuff(langOptions.toString());
            String userLang = IFeats.getLine();
            while(!langOptions.contains(userLang)){
                IFeats.printStuff("That is not an option.");
                IFeats.printStuff(langOptions.toString());
                userLang = IFeats.getLine();
            }
            langOptions.remove(userLang);
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
