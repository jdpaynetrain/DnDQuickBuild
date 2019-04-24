package QuickBuild.Classes;
import java.util.*;

public interface IWizard extends Classes {
    Set<String> wizardSkills = new HashSet<>
            (Arrays.asList("Arcana", "History", "Insight", "Investigation",
                    "Medicine", "Religion"));

    Set<String> wizardProfs = new HashSet<>
            (Arrays.asList("Daggers", "Darts", "Slings",
                    "Quarterstaffs", "Light Crossbows"));
}
