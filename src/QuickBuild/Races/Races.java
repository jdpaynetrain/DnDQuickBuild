package QuickBuild.Races;
import QuickBuild.QuickBuilder;

import java.util.*;

public interface Races {
    Set<String> allRaces = new HashSet<>
            (Arrays.asList("Hill Dwarf", "Mountain Dwarf", "High Elf",
                    "Wood Elf", "Dark Elf", "Lightfoot Halfling",
                    "Stout Halfling", "Human", "Dragonborn", "Forest Gnome",
                    "Rock Gnome", "Half Elf", "Half Orc", "Tiefling"));
    Set<String> allAttributes = new HashSet<>
            (Arrays.asList("INT", "CHA", "WIS", "DEX", "CON", "STR"));
    Set<String> allLanguages = new HashSet<>
            (Arrays.asList("Common", "Dwarvish", "Elvish", "Giant", "Gnomish",
                           "Goblin", "Halfling", "Orc", "Abyssal", "Celestial",
                           "Draconic", "Deep Speech", "Infernal", "Primordial",
                           "Sylvan", "Undercommon"));
    Set<String> artisansTools = new HashSet<>
            (Arrays.asList("Smith's Tools", "Brewer's Supplies",
                           "Mason's Tools"));
    void applyBuffs(Map<String, Integer> stats);
    Set<String> racialLanguages();
    Set<String> racialProfs();

    static String getLine(){
        return QuickBuilder.getUserLine();
    }

    static Integer getNumber(){
        return QuickBuilder.getUserInt();
    }

    static void printStuff(String message){
        QuickBuilder.printToUser(message);
    }
}
