package QuickBuild.Feats;
import QuickBuild.Character;
import QuickBuild.Classes.Classes;
import QuickBuild.Races.Races;

import java.util.Scanner;

public class Skilled implements IFeats {
    public void updateStats(Character person){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 3; i++) {
            Character.printToUser("Choose one of the following" +
                    "to gain proficiency in");
            Character.printToUser(Races.artisansTools.toString());
            Character.printToUser(Classes.allSkills.toString());
            String userProf = sc.nextLine();
            while((!Races.artisansTools.contains(userProf) &&
                    !Classes.allSkills.contains(userProf)) ||
                    person.hasProf(userProf)){
                if(person.hasProf(userProf)){
                    Character.printToUser("You already have proficiency");
                }
                else{
                    Character.printToUser("That is not an option");
                }
                userProf = sc.nextLine();
            }
            person.addProf(userProf);
        }
    }

    public String featDescription(){
        return "You gain proficiency in any combination of three skills or " +
                "tools of your choice.";
    }
}
