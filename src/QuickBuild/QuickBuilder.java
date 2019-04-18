package QuickBuild;
import java.util.*;
import QuickBuild.Classes.Classes;
import QuickBuild.Races.Races;

public class QuickBuilder {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Character person = new Character();

        // Get the user's race
        Character.printToUser("What race would you like to play? Options are: ");
        Character.printToUser(Races.allRaces.toString());
        String userRace = sc.nextLine();
        while(!Races.allRaces.contains(userRace)){
            Character.printToUser("Race must be one of the following:");
            Character.printToUser(Races.allRaces.toString());
            userRace = sc.nextLine();
        }

        // Get the user's class
        Character.printToUser("What class would you like to play? Options are: ");
        Character.printToUser(Classes.allClasses.toString());
        String userClass = sc.nextLine();
        while(!Classes.allClasses.contains(userClass)){
            Character.printToUser("Class must be one of the following:");
            Character.printToUser(Classes.allClasses.toString());
            userClass = sc.nextLine();
        }

        // Get the user's level
        Character.printToUser("What level character do you want? (1-20)");
        int level = sc.nextInt();
        sc.nextLine();
        while(level > 20 || level < 1){
            Character.printToUser("Level must be between 1 and 20");
            level = sc.nextInt();
            sc.nextLine();
        }

        // Build the character and print the stats
        person.rollCharacter(userClass, userRace, level);
        printStats(person);
    }

    // Print the final stats for the built character
    public static void printStats(Character person){
        Character.printToUser(person.getRace() + "-" + person.getType());
        Character.printToUser("Level: " + person.getLevel());
        person.printScores();
        Character.printToUser("Initiative: " + person.getInitiative());
        Character.printToUser("Health: " + person.getHealth());
        Character.printToUser("Proficiencies are:");
        Character.printToUser(person.getProficiencies().toString());
        Character.printToUser("Known languages are:");
        Character.printToUser(person.getKnownLanguages().toString());
        if(person.getFeats().size() > 0) {
            Character.printToUser("Feats:");
            Character.printToUser(person.getFeats().toString());
        }

    }


}
