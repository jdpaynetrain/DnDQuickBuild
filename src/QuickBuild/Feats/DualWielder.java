package QuickBuild.Feats;
import QuickBuild.Character;

public class DualWielder implements IFeats {
    public void updateStats(Character person){

    }

    public String featDescription(){
        return "You master fighting with two weapons, gaining the following " +
                "benefits:\n" +
                "- You gain a +1 bonus to AC while you are wielding a " +
                "separate melee weapon in each hand.\n" +
                "- You can use two-weapon fighting even when the one-handed " +
                "melee weapons you are wielding aren't light.\n" +
                "- You can draw or stow two one-handed weapons when you " +
                "would normally be able to draw or stow only one.";
    }
}
