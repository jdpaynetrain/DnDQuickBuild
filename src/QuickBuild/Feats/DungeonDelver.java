package QuickBuild.Feats;

public class DungeonDelver implements IFeats {

    public String featDescription(){
        return "Alert to the hidden traps and secret doors found in many " +
                "dungeons, you gain the following benefits:\n" +
                "- You have advantage on Wisdom (Perception) and " +
                "Intelligence (Investigation) checks made to detect the " +
                "presence of secret doors.\n" +
                "- You have advantage on saving throws made to avoid\n" +
                "or resist traps.\n" +
                "- You have resistance to the damage dealt by traps.\n" +
                "- You can search for traps while traveling at a normal " +
                "pace, instead of only at a slow pace.";
    }
}
