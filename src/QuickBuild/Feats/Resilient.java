package QuickBuild.Feats;
import QuickBuild.Character;
import java.util.Scanner;

public class Resilient implements IFeats {

    public void updateStats(Character person){
        Scanner sc = new Scanner(System.in);
        Character.printToUser("Choose an ability to increase:");
        person.printScores();
        String userScore = sc.nextLine();
        while(!Character.allScores.contains(userScore) ||
                person.checkStat(userScore) == 20){
            if(Character.allScores.contains(userScore)){
                Character.printToUser("Scores can only be increased to 20."
                        + " Choose another.");
            }
            else{
                Character.printToUser("That isn't a choice");
            }
            person.printScores();
            userScore = sc.nextLine();
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
