package QuickBuild.Races;

import java.util.*;

public interface IHalfling extends Races {
    default Set<String> racialProfs() {
        return new HashSet<>();
    }

    default Set<String> racialLanguages(){
        return new HashSet<>(Arrays.asList("Common", "Halfling"));
    }


}
