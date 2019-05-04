package QuickBuild;
import java.util.*;

import QuickBuild.Classes.Classes;
import QuickBuild.Races.Races;

public class QuickBuilder {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Character person = new Character();

        // Get the user's race
        printToUser("What race would you like to play? Options are: ");
        printToUser(Races.allRaces.toString());
        String userRace = getUserLine();
        while(!Races.allRaces.contains(userRace)){
            printToUser("Race must be one of the following:");
            printToUser(Races.allRaces.toString());
            userRace = getUserLine();
        }

        // Get the user's class
        printToUser("What class would you like to play? Options are: ");
        printToUser(Classes.allClasses.toString());
        String userClass = getUserLine();
        while(!Classes.allClasses.contains(userClass)){
            printToUser("Class must be one of the following:");
            printToUser(Classes.allClasses.toString());
            userClass = getUserLine();
        }

        // Get the user's level
        printToUser("What level character do you want? (1-20)");
        int level = getUserInt();
        while(level > 20 || level < 1){
            printToUser("Level must be between 1 and 20");
            level = getUserInt();
        }

        // Build the character and print the stats
        person.rollCharacter(userClass, userRace, level);
        printStats(person);
    }

    // Print the final stats for the built character
    private static void printStats(Character person){
        printToUser(person.getRace() + "-" + person.getType());
        printToUser("Level: " + person.getLevel());
        person.printScores();
        printToUser("Initiative: " + person.getInitiative());
        printToUser("Health: " + person.getHealth());
        printToUser("Proficiencies are:");
        printToUser(person.getProficiencies().toString());
        printToUser("Known languages are:");
        printToUser(person.getKnownLanguages().toString());
        if(person.getFeats().size() > 0) {
            printToUser("Feats:");
            printToUser(person.getFeats().toString());
        }
    }

    public static void printToUser(String message){
        System.out.println(message);
    }

    public static String getUserLine(){
        return sc.nextLine();
    }

    public static Integer getUserInt(){
        Integer value = sc.nextInt();
        sc.nextLine();
        return value;
    }
}
