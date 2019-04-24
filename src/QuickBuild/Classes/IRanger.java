package QuickBuild.Classes;

import java.util.*;

public interface IRanger extends Classes {
    Set<String> rangerSkills = new HashSet<>
            (Arrays.asList("Animal Handling", "Athletics", "Insight",
                    "Investigation", "Nature", "Perception", "Stealth",
                    "Survival"));

    Set<String> rangerProfs = new HashSet<>
            (Arrays.asList("Light Armor", "Medium Armor", "Shields",
                    "Simple Weapons", "Martial Weapons"));
}
