package QuickBuild.Feats;
import QuickBuild.Character;
import QuickBuild.Classes.Classes;
import QuickBuild.Races.Races;
import java.util.Set;
import java.util.HashSet;

public class Skilled implements IFeats {
    public void updateStats(Character person){
        Set<String> profOptions = new HashSet<>();
        for(String curr: Races.artisansTools){
            if(!person.hasProf(curr))
                profOptions.add(curr);
        }
        for(String curr: Classes.allSkills){
            if(!person.hasProf(curr))
                profOptions.add(curr);
        }
        for(int i = 0; i < 3; i++) {
            IFeats.printStuff("Choose one of the following" +
                    "to gain proficiency in");
            IFeats.printStuff(profOptions.toString());
            String userProf = IFeats.getLine();
            while(!profOptions.contains(userProf)){
                IFeats.printStuff("That is not an option");
                IFeats.printStuff(profOptions.toString());
                userProf = IFeats.getLine();
            }
            profOptions.remove(userProf);
            person.addProf(userProf);
        }
    }

    public String featDescription(){
        return "You gain proficiency in any combination of three skills or " +
                "tools of your choice.";
    }
}
