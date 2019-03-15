package QuickBuild.Classes;
import QuickBuild.Character;

import java.util.*;

public interface Classes {
    Set<String> allSkills = new HashSet<>
            (Arrays.asList("Acrobatics", "Animal Handling", "Arcana",
                    "Athletics", "Deception", "History", "Insight",
                    "Intimidation", "Investigation", "Medicine", "Nature",
                    "Perception", "Performance", "Persuasion", "Religion",
                    "Sleight of Hand", "Stealth", "Survival"));
    Map<String, Integer> applyModifiers(List<Integer> baseStats);
    void classProfs(Set<String> profs);
    Integer baseHealth();
    Integer rollHitDie();
    //Integer levelUp(Character person);
}
