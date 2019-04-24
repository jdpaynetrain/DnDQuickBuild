package QuickBuild.Classes;

import java.util.*;

public interface IPaladin extends Classes {
    Set<String> paladinSkills = new HashSet<>
            (Arrays.asList("Athletics", "Insight", "Intimidation", "Medicine",
                    "Persuasion", "Religion"));

    Set<String> paladinProfs = new HashSet<>
            (Arrays.asList("All Armor", "Shields", "Simple Weapons",
                    "Martial Weapons"));
}
