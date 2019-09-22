package QuickBuild.Feats;
import QuickBuild.Player.Character;
import QuickBuild.Player.CharacterController;

public class Durable implements IFeats {
    public void updateStats(Character person, CharacterController control){
        person.updateStat("CON", 1);
    }

    public String featDescription(){
        return "Hardy and resilient, you gain the following benefits:\n" +
                "- Increase your Constitution score by 1, to a maximum of " +
                "20.\n" +
                "- When you roll a Hit Die to regain hit points, the " +
                "minimum number of hit points you regain from the roll " +
                "equals twice your Constitution modifier (minimum of 2)";
    }
}
