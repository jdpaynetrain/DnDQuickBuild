package QuickBuild.Feats;
import QuickBuild.Player.Character;
import QuickBuild.Player.CharacterController;

public class Actor implements IFeats {
    public void updateStats(Character person, CharacterController control){
        person.updateStat("CHA", 1);
    }

    public String featDescription(){
        return "Skilled at mimicry and dramatics, you gain the following " +
                "benefits: \n" +
                "- Increase your Charisma score by 1, to a maximum of 20 \n" +
                "- You have advantage on Charisma (Deception) and Charisma " +
                "(Performance) checks when trying to pass yourself off as a " +
                "different person.\n" +
                "- You can mimic the speech of another person or the sounds " +
                "made by other creatures. You must have heard the person " +
                "speaking, or heard the creature make the sound, for at " +
                "least 1 minute. A successful Wisdom (Insight) check " +
                "contested by your Charisma (Deception) check allows a " +
                "listened to determine the effect is faked.";
    }
}
