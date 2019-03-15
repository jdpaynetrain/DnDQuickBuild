package QuickBuild.Classes;

import java.util.*;

public interface IFighter extends Classes {
    Set<String> fighterSkills = new HashSet<>
            (Arrays.asList("Acrobatics", "Animal Handling", "Athletics",
                    "History", "Insight", "Intimidation", "Perception",
                    "Survival"));

    Set<String> fighterProfs = new HashSet<>
            (Arrays.asList("All Armor", "Shields", "Simple Weapons",
                    "Martial Weapons"));
}
