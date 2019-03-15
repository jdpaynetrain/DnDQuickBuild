package QuickBuild.Races;

import java.util.*;

public interface IDwarf extends Races {
    default Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Dwarvish"));
    }
}
