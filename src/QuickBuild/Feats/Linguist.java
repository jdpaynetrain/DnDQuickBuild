package QuickBuild.Feats;
import QuickBuild.Player.Character;
import QuickBuild.Player.CharacterController;
import QuickBuild.Races.Races;
import java.util.*;

public class Linguist implements IFeats {
    public void updateStats(Character person, CharacterController control){
        person.updateStat("INT", 1);
        Set<String> langOptions = new HashSet<>();
        for(String curr: Races.allLanguages){
            if(!person.hasLang(curr))
                langOptions.add(curr);
        }
        control.applyFeatLangs(person, langOptions);
        control.applyFeatLangs(person, langOptions);
        control.applyFeatLangs(person, langOptions);
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
