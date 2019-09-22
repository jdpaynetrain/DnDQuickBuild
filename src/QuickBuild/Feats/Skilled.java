package QuickBuild.Feats;
import QuickBuild.Player.Character;
import QuickBuild.Classes.Classes;
import QuickBuild.Player.CharacterController;
import QuickBuild.Races.Races;
import java.util.Set;
import java.util.HashSet;

public class Skilled implements IFeats {
    public void updateStats(Character person, CharacterController control){
        Set<String> profOptions = new HashSet<>();
        for(String curr: Races.artisansTools){
            if(!person.hasProf(curr))
                profOptions.add(curr);
        }
        for(String curr: Classes.allSkills){
            if(!person.hasProf(curr))
                profOptions.add(curr);
        }
        control.applyFeatProfs(person, profOptions);
        control.applyFeatProfs(person, profOptions);
        control.applyFeatProfs(person, profOptions);
    }

    public String featDescription(){
        return "You gain proficiency in any combination of three skills or " +
                "tools of your choice.";
    }
}
