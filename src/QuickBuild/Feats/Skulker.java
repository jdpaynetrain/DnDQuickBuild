package QuickBuild.Feats;
import QuickBuild.Character;

public class Skulker implements IFeats {
    public void updateStats(Character person){

    }

    static public Boolean metPreReqs(Character person){
        return person.checkStat("DEX") >= 13;
    }

    public String featDescription(){
        return "You are expert at slinking through shadows. You gain " +
                "the following benefits:\n" +
                "- You can try to hide when you are lightly obscured " +
                "from the creature from which you are hiding.\n" +
                "- When you are hidden from a creature and miss it with " +
                "a ranged weapon attack, making the attack doesn't " +
                "reveal your position.\n" +
                "- Dim light doesn't impose disadvantage on your " +
                "Wisdom (Perception) checks relying on sight.";
    }
}
