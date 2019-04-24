package QuickBuild.Classes;
import java.util.*;

public interface ISorcerer extends Classes {
    Set<String> sorcererSkills = new HashSet<>
            (Arrays.asList("Arcana", "Deception", "Insight", "Intimidation",
                    "Persuasion", "Religion"));

    Set<String> sorcererProfs = new HashSet<>
            (Arrays.asList("Daggers", "Darts", "Slings",
                    "Quarterstaffs", "Light Crossbows"));
}
