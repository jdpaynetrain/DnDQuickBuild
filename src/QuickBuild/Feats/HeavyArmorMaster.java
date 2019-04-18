package QuickBuild.Feats;
import QuickBuild.Character;

public class HeavyArmorMaster implements IFeats {
    public void updateStats(Character person){
        person.updateStat("STR", 1);
    }

    static public Boolean metPreReqs(Character person){
        return person.hasProf("Heavy Armor") || person.hasProf("All Armor");
    }

    public String featDescription(){
        return "You can use your armor to deflect strikes that would kill " +
                "others. You gain the following benefits:\n" +
                "- Increase your Strength score by 1, to a maximum of 20.\n" +
                "- While you are wearing heavy armor, bludgeoning, " +
                "piercing, and slashing damage that you take from " +
                "non-magical weapons is reduced by 3.";
    }
}
