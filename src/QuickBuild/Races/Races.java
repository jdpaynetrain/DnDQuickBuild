package QuickBuild.Races;
import java.util.*;

public interface Races {
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
}
