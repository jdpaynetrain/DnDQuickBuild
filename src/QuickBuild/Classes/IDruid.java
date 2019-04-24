package QuickBuild.Classes;
import java.util.*;

public interface IDruid extends Classes {
    Set<String> druidSkills = new HashSet<>
            (Arrays.asList("Arcana", "Animal Handling", "Insight", "Medicine",
                    "Nature", "Perception", "Religion", "Survival"));

    Set<String> druidProfs = new HashSet<>
            (Arrays.asList("Light Armor", "Medium Armor", "Shields",
                    "Clubs", "Daggers", "Javelins", "Maces", "Quarterstaffs",
                    "Scimitars", "Sickles", "Slings", "Spears",
                    "Herbalism Kit"));
}
