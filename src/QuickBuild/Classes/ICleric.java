package QuickBuild.Classes;

import java.util.*;

public interface ICleric extends Classes {
    Set<String> clericSkills = new HashSet<>
            (Arrays.asList("History", "Insight", "Medicine", "Persuasion",
                    "Religion"));

    Set<String> clericProfs = new HashSet<>
            (Arrays.asList("Light Armor", "All Simple Weapons"));
}
