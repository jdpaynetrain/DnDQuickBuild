package QuickBuild.Feats;

public class CrossbowExpert implements IFeats {

    public String featDescription(){
        return "Thanks to extensive practice you gain the following " +
                "benefits:\n" +
                "- You ignore the loading quality of crossbows with which " +
                "you are proficient.\n" +
                "- Being within 5 feet of a hostile creature doesn't " +
                "impose disadvantage on your ranged attack rolls.\n" +
                "- When you use the Attack action and attack with a " +
                "one-handed weapon, you can use a bonus action to " +
                "attack with a loaded hand crossbow you are holding";
    }
}
