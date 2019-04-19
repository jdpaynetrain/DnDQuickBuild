package QuickBuild.Feats;
import QuickBuild.Character;
import java.util.Set;
import java.util.HashSet;

public class Resilient implements IFeats {

    public void updateStats(Character person){
        Set<String> abilityOptions = new HashSet<>();
        for(String curr: Character.allScores){
            if(person.checkStat(curr) < 20)
                abilityOptions.add(curr);
        }
        IFeats.printStuff("Choose an ability to increase:");
        person.printScores();
        String userScore = IFeats.getLine();
        while(!abilityOptions.contains(userScore)){
            IFeats.printStuff("That isn't a choice");
            person.printScores();
            userScore = IFeats.getLine();
        }
        person.updateStat(userScore, 1);
    }

    public String featDescription(){
        return "Choose one ability score. You gain the following benefits:\n" +
                "- Increase the chosen ability score by 1, to a maximum " +
                "of 20.\n" +
                "- You gain proficiency in saving throws using the " +
                "chosen ability.";
    }
}
