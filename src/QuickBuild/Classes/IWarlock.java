package QuickBuild.Classes;
import java.util.*;

public interface IWarlock extends Classes {
    Set<String> warlockSkills = new HashSet<>
            (Arrays.asList("Arcana", "Deception", "History", "Intimidation",
                    "Investigation", "Nature", "Religion"));

    Set<String> warlockProfs = new HashSet<>
            (Arrays.asList("Light Armor", "Simple Weapons"));
}
