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

        System.out.println("What race would you like to play? Options are: ");
        System.out.println(allRaces);
        String userRace = sc.nextLine();
        while(!allRaces.contains(userRace)){
            System.out.println("Race must be one of the following:");
            System.out.println(allRaces);
            userRace = sc.nextLine();
        }

        System.out.println("What class would you like to play? Options are: ");
        System.out.println(allClasses);
        String userClass = sc.nextLine();
        while(!allClasses.contains(userClass)){
            System.out.println("Class must be one of the following:");
            System.out.println(allClasses);
            userClass = sc.nextLine();
        }

        System.out.println("What level character do you want? (1-20)");
        int level = sc.nextInt();
        sc.nextLine();
        while(level > 20 || level < 1){
            System.out.println("Level must be between 1 and 20");
            level = sc.nextInt();
            sc.nextLine();
        }

        person.rollCharacter(userClass, userRace, level);
        printStats(person);
    }

    public static void printStats(Character person){
        System.out.println(person.getRace() + "-" + person.getType());
        System.out.println("Level: " + person.getLevel());
        person.printScores();
        System.out.println("Initiative: " + person.getInitiative());
        System.out.println("Health: " + person.getHealth());
        System.out.println("Proficiencies are:");
        System.out.println(person.getProficiencies());
        System.out.println("Known languages are:");
        System.out.println(person.getKnownLanguages());
    }


}
