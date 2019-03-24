package QuickBuild;
import java.util.*;

public class QuickBuilder {
    private static final Set<String> allClasses = new HashSet<>
            (Arrays.asList("Barbarian", "Bard", "Cleric", "Druid", "Fighter",
                    "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer",
                    "Warlock", "Wizard"));
    private static final Set<String> allRaces = new HashSet<>
            (Arrays.asList("Hill Dwarf", "Mountain Dwarf", "High Elf",
                    "Wood Elf", "Dark Elf", "Lightfoot Halfling",
                    "Stout Halfling", "Human", "Dragonborn", "Forest Gnome",
                    "Rock Gnome", "Half Elf", "Half Orc", "Tiefling"));

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Character person = new Character();

        Character.printToUser("What race would you like to play? Options are: ");
        Character.printToUser(allRaces.toString());
        String userRace = sc.nextLine();
        while(!allRaces.contains(userRace)){
            Character.printToUser("Race must be one of the following:");
            Character.printToUser(allRaces.toString());
            userRace = sc.nextLine();
        }

        Character.printToUser("What class would you like to play? Options are: ");
        Character.printToUser(allClasses.toString());
        String userClass = sc.nextLine();
        while(!allClasses.contains(userClass)){
            Character.printToUser("Class must be one of the following:");
            Character.printToUser(allClasses.toString());
            userClass = sc.nextLine();
        }

        Character.printToUser("What level character do you want? (1-20)");
        int level = sc.nextInt();
        sc.nextLine();
        while(level > 20 || level < 1){
            Character.printToUser("Level must be between 1 and 20");
            level = sc.nextInt();
            sc.nextLine();
        }

        person.rollCharacter(userClass, userRace, level);
        printStats(person);
    }

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
