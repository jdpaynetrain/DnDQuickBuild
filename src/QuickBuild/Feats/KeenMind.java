package QuickBuild.Feats;
import QuickBuild.Player.Character;
import QuickBuild.Player.CharacterController;

public class KeenMind implements IFeats {
    public void updateStats(Character person, CharacterController control){
        person.updateStat("INT", 1);
    }

    public String featDescription(){
        return "You have a mind that can track time, direction, and detail " +
                "with uncanny precision. You gain the following benefits.\n" +
                "- Increase your Intelligence score by 1, to a maximum " +
                "of 20.\n" +
                "- You always know which way is north.\n" +
                "- You always know the number of hours left before the " +
                "next sunrise or sunset.\n" +
                "- You can accurately recall anything you have seen or " +
                "heard within the past month.";
    }
}
