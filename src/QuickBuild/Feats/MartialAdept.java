package QuickBuild.Feats;
import QuickBuild.Character;

public class MartialAdept implements IFeats {
    public void updateStats(Character person){

    }

    public String featDescription(){
        return "You have martial training that allows you to " +
                "perform special combat maneuvers. You gain the " +
                "following benefits:\n" +
                "- You learn two maneuvers of your choice from among " +
                "those available to the Battle Master archetype in the " +
                "fighter class. If a maneuver you use requires your target " +
                "to make a saving throw to resist the maneuver’s " +
                "effects, the saving throw DC equals 8 + your proficiency " +
                "bonus + your Strength or Dexterity modifier " +
                "(your choice).\n" +
                "- If you already have superiority dice, you gain one " +
                "more; otherwise, you have one superiority die, which " +
                "is a d6. This die is used to fuel your maneuvers. A " +
                "superiority die is expended when you use it. You " +
                "regain your expended superiority d ice when you " +
                "finish a short or long rest.";
    }
}