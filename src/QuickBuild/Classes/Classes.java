package QuickBuild.Classes;

import QuickBuild.QuickBuilder;

import java.util.*;

public interface Classes {
    
    Set<String> allClasses = new HashSet<>
            (Arrays.asList("Barbarian", "Bard", "Cleric", "Druid", "Fighter",
                    "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer",
                    "Warlock", "Wizard"));
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

    static String getLine(){
        return QuickBuilder.getUserLine();
    }

    static Integer getNumber(){
        return QuickBuilder.getUserInt();
    }

    static void printStuff(String message){
        QuickBuilder.printToUser(message);
    }
}
