package QuickBuild.Feats;
import QuickBuild.Character;

public class WarCaster implements IFeats {

    public void updateStats(Character person){
    }

    static public Boolean metPreReqs(Character person){
        return spellCasters.contains(person.getType());
    }

    public String featDescription(){
        return "You have practiced casting spells in the midst of " +
                "combat, learning techniques that grant you the " +
                "following benefits:\n" +
                "- You have advantage on Constitution saving throws " +
                "that you make to maintain your concentration on a " +
                "spell when you take damage.\n" +
                "- You can perform the somatic components of spells " +
                "even when you have weapons or a shield in one or " +
                "both hands.\n" +
                "- When a hostile creature's movement provokes an " +
                "opportunity attack from you, you can use your reaction " +
                "to cast a spell at the creature, rather than making " +
                "an opportunity attack. The spell must have a casting " +
                "time of 1 action and must target only that creature.";
    }
}
