package QuickBuild.Classes;

import QuickBuild.Player.CharacterController;
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

    Set<String> barbSkills = new HashSet<>
            (Arrays.asList("Animal Handling", "Athletics", "Intimidation",
                    "Nature", "Perception", "Survival"));
    Set<String> barbProfs = new HashSet<>(Arrays.asList("Light Armor",
            "Medium Armor", "Shields", "Simple Weapons", "Martial Weapons"));

    Set<String> bardProfs = new HashSet<>(Arrays.asList("Light Armor",
            "Simple Weapons", "Hand Crossbows", "Longswords", "Rapiers",
            "Shortswords"));

    Set<String> clericSkills = new HashSet<>
            (Arrays.asList("History", "Insight", "Medicine", "Persuasion",
                    "Religion"));
    Set<String> clericProfs = new HashSet<>
            (Arrays.asList("Light Armor", "All Simple Weapons"));

    Set<String> druidSkills = new HashSet<>
            (Arrays.asList("Arcana", "Animal Handling", "Insight", "Medicine",
                    "Nature", "Perception", "Religion", "Survival"));
    Set<String> druidProfs = new HashSet<>
            (Arrays.asList("Light Armor", "Medium Armor", "Shields",
                    "Clubs", "Daggers", "Javelins", "Maces", "Quarterstaffs",
                    "Scimitars", "Sickles", "Slings", "Spears",
                    "Herbalism Kit"));

    Set<String> fighterSkills = new HashSet<>
            (Arrays.asList("Acrobatics", "Animal Handling", "Athletics",
                    "History", "Insight", "Intimidation", "Perception",
                    "Survival"));
    Set<String> fighterProfs = new HashSet<>
            (Arrays.asList("All Armor", "Shields", "Simple Weapons",
                    "Martial Weapons"));

    Set<String> monkSkills = new HashSet<>
            (Arrays.asList("Acrobatics", "Athletics", "History", "Insight",
                    "Religion", "Stealth"));
    Set<String> monkProfs = new HashSet<>(Arrays.asList("Simple Weapons",
            "Shortswords"));

    Set<String> paladinSkills = new HashSet<>
            (Arrays.asList("Athletics", "Insight", "Intimidation", "Medicine",
                    "Persuasion", "Religion"));
    Set<String> paladinProfs = new HashSet<>
            (Arrays.asList("All Armor", "Shields", "Simple Weapons",
                    "Martial Weapons"));

    Set<String> rangerSkills = new HashSet<>
            (Arrays.asList("Animal Handling", "Athletics", "Insight",
                    "Investigation", "Nature", "Perception", "Stealth",
                    "Survival"));
    Set<String> rangerProfs = new HashSet<>
            (Arrays.asList("Light Armor", "Medium Armor", "Shields",
                    "Simple Weapons", "Martial Weapons"));

    Set<String> rogueSkills = new HashSet<>
            (Arrays.asList("Acrobatics", "Athletics", "Deception", "Insight",
                    "Intimidation", "Investigation", "Perception",
                    "Performance", "Persuasion", "Sleight of Hand",
                    "Stealth"));
    Set<String> rogueProfs = new HashSet<>
            (Arrays.asList("Light Armor", "Simple Weapons",
                    "Hand Crossbows", "Longswords", "Rapiers", "Shortswords",
                    "Thieves' Tools"));

    Set<String> sorcererSkills = new HashSet<>
            (Arrays.asList("Arcana", "Deception", "Insight", "Intimidation",
                    "Persuasion", "Religion"));
    Set<String> sorcererProfs = new HashSet<>
            (Arrays.asList("Daggers", "Darts", "Slings",
                    "Quarterstaffs", "Light Crossbows"));

    Set<String> warlockSkills = new HashSet<>
            (Arrays.asList("Arcana", "Deception", "History", "Intimidation",
                    "Investigation", "Nature", "Religion"));
    Set<String> warlockProfs = new HashSet<>
            (Arrays.asList("Light Armor", "Simple Weapons"));

    Set<String> wizardSkills = new HashSet<>
            (Arrays.asList("Arcana", "History", "Insight", "Investigation",
                    "Medicine", "Religion"));
    Set<String> wizardProfs = new HashSet<>
            (Arrays.asList("Daggers", "Darts", "Slings",
                    "Quarterstaffs", "Light Crossbows"));

    Map<String, Integer> applyModifiers(List<Integer> baseStats);
    void classProfs(Set<String> profs, CharacterController control);
    Integer baseHealth();
    Integer rollHitDie();

}
