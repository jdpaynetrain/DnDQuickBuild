package QuickBuild.Classes;
import java.util.*;

public interface IRogue extends Classes {
    Set<String> rogueSkills = new HashSet<>
            (Arrays.asList("Acrobatics", "Athletics", "Deception", "Insight",
                    "Intimidation", "Investigation", "Perception",
                    "Performance", "Persuasion", "Sleight of Hand",
                    "Stealth"));
    Set<String> rogueProfs = new HashSet<>
            (Arrays.asList("Light Armor", "Simple Weapons",
                    "Hand Crossbows", "Longswords", "Rapiers", "Shortswords",
                    "Thieves' Tools"));
}
