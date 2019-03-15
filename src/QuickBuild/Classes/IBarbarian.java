package QuickBuild.Classes;

import java.util.*;

public interface IBarbarian extends Classes {
    Set<String> barbSkills = new HashSet<>
            (Arrays.asList("Animal Handling", "Athletics", "Intimidation",
                    "Nature", "Perception", "Survival"));
    Set<String> barbProfs = new HashSet<>(Arrays.asList("Light Armor",
            "Medium Armor", "Shields", "Simple Weapons", "Martial Weapons"));
}
