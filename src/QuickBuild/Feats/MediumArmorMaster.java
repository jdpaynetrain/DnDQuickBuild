package QuickBuild.Feats;
import QuickBuild.Player.Character;

public class MediumArmorMaster implements IFeats {

    static public Boolean metPreReqs(Character person){
        return person.hasProf("Medium Armor") || person.hasProf("All Armor");
    }

    public String featDescription(){
        return "You have practiced moving in medium armor to gain the " +
                "following benefits:\n" +
                "- Wearing medium armor doesn't impose disadvantage " +
                "on your Dexterity (Stealth) checks.\n" +
                "- When you wear medium armor, you can add 3, " +
                "rather than 2, to your AC if you have a Dexterity of " +
                "16 or higher.";
    }
}
