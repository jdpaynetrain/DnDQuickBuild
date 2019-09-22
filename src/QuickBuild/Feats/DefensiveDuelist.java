package QuickBuild.Feats;
import QuickBuild.Player.Character;

public class DefensiveDuelist implements IFeats {
    static public Boolean metPreReqs(Character person){
        return (person.getStat("DEX") >= 13);
    }

    public String featDescription(){
        return "When you are wielding a finesse weapon with which you are " +
                "proficient and another creature hits you with a melee " +
                "attack, you can use your reaction to add your proficiency " +
                "to your AC for that attack, potentially causing the " +
                "attack to miss you.";
    }
}
