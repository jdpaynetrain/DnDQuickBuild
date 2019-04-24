package QuickBuild.Feats;
import QuickBuild.Character;
import java.util.Scanner;

public class Observant implements IFeats {

    public void updateStats(Character person){
        if(person.checkStat("INT") == 20 && person.checkStat("WIS") == 20){
            IFeats.printStuff("INT and WIS are both 20. No stats to boost.");
        }
        else if(person.checkStat("INT").equals(20)){
            IFeats.printStuff("INT is already 20. Boosting WIS");
            person.updateStat("INT", 1);
        }
        else if(person.checkStat("WIS").equals(20)){
            IFeats.printStuff("WIS is already 20. Boosting INT");
            person.updateStat("WIS", 1);
        }
        else {
            IFeats.printStuff("Choose INT or WIS to increase");
            person.printScores();
            String temp = IFeats.getLine();
            while((!temp.equals("WIS") && !temp.equals("INT"))){
                IFeats.printStuff("Options are WIS or INT");
                temp = IFeats.getLine();
            }
            person.updateStat(temp, 1);
        }
    }

    public String featDescription() {
        return "Quick to notice details of your environment, you gain " +
                "the following benefits:\n" +
                "- Increase your Intelligence or Wisdom score by 1, to a " +
                "maximum of 20.\n" +
                "- If you can see a creature’s mouth while it is speaking " +
                "a language you understand, you can interpret what it’s " +
                "saying by reading its lips.\n" +
                "- You have a +5 bonus to your passive Wisdom " +
                "(Perception) and passive Intelligence (Investigation) " +
                "scores.";
    }
}
