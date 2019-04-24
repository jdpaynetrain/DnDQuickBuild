package QuickBuild.Classes;
import java.util.*;

public interface IMonk extends Classes {
    Set<String> monkSkills = new HashSet<>
            (Arrays.asList("Acrobatics", "Athletics", "History", "Insight",
                    "Religion", "Stealth"));
    Set<String> monkProfs = new HashSet<>(Arrays.asList("Simple Weapons",
            "Shortswords"));
}
