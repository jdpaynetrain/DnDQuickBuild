package QuickBuild;

import QuickBuild.Classes.*;
import QuickBuild.Races.*;
import java.util.*;

public class Character {
    private List<Integer> baseStats;
    private Classes archetype;
    private Races racial;
    private Map<String, Integer> stats;
    private Map<String, Integer> scoreMods;
    private String type;
    private String race;
    private Set<String> proficiencies;
    private Set<String> knownLanguages;
    private Map<Boolean, Integer> darkvision;

    public Character(){
        StatRoller roller = new StatRoller();
        baseStats = roller.rollStats();
    }

    private void applyClass(String type){
        if(type.equals("Barbarian"))
            archetype = new Barbarian();
        else if(type.equals("Bard"))
            archetype = new Bard();
        else if(type.equals("Cleric"))
            archetype = new Cleric();
        else if(type.equals("Druid"))
            archetype = new Druid();
        else if(type.equals("Fighter"))
            archetype = new Fighter();
        else if(type.equals("Monk"))
            archetype = new Monk();
        else if(type.equals("Paladin"))
            archetype = new Paladin();
        else if(type.equals("Ranger"))
            archetype = new Ranger();
        else if(type.equals("Rogue"))
            archetype = new Rogue();
        else if(type.equals("Sorcerer"))
            archetype = new Sorcerer();
        else if(type.equals("Warlock"))
            archetype = new Warlock();
        else if(type.equals("Wizard"))
            archetype = new Wizard();
        stats = archetype.applyModifiers(baseStats);
    }

    private void applyRace(String race){
        if(race.equals("Hill Dwarf"))
            racial = new DwarfHill();
        else if(race.equals("Mountain Dwarf"))
            racial = new DwarfMountain();
        else if(race.equals("High Elf"))
            racial = new ElfHigh();
        else if(race.equals("Wood Elf"))
            racial = new ElfWood();
        else if(race.equals("Dark Elf"))
            racial = new ElfDark();
        else if(race.equals("Lightfoot Halfling"))
            racial = new HalflingLightfoot();
        else if(race.equals("Stout Halfling"))
            racial = new HalflingStout();
        else if(race.equals("Human"))
            racial = new Human();
        else if(race.equals("Dragonborn"))
            racial = new Dragonborn();
        else if(race.equals("Forest Gnome"))
            racial = new GnomeForest();
        else if(race.equals("Rock Gnome"))
            racial = new GnomeRock();
        else if(race.equals("Half Elf"))
            racial = new HalfElf();
        else if(race.equals("Half Orc"))
            racial = new HalfOrc();
        else if(race.equals("Tiefling"))
            racial = new Tiefling();

        racial.applyBuffs(stats);
    }

    public void rollCharacter(String type, String race){
        this.type = type;
        this.race = race;
        this.applyClass(type);
        this.applyRace(race);
        this.calcMods();
        this.knownLanguages = racial.racialLanguages();
        this.proficiencies = racial.racialProfs();
        archetype.classProfs(proficiencies);
    }


    private void calcMods(){
        scoreMods = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry: stats.entrySet()){
            scoreMods.put(entry.getKey(),
                            Math.floorDiv(entry.getValue() - 10, 2));

        }
    }

    public void printStats(){
        System.out.println(race + " " + type);
        for(Map.Entry<String, Integer> entry: stats.entrySet()){
            System.out.println(entry.getKey() + " -- " + entry.getValue() +
                               "(" + scoreMods.get(entry.getKey()) + ")");
        }
        System.out.println("Proficiencies are:");
        System.out.println(proficiencies);
        System.out.println("Known languages are:");
        System.out.println(knownLanguages);
    }
}
