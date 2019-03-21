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
    private Integer health;
    private Integer level;
    private Set<String> allScores = new HashSet<>
            (Arrays.asList("STR", "DEX", "CON", "INT", "WIS", "CHA"));

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

    public void rollCharacter(String type, String race, Integer level){
        this.type = type;
        this.race = race;
        this.level = 1;
        this.applyClass(type);
        this.applyRace(race);
        this.calcMods();
        this.knownLanguages = racial.racialLanguages();
        this.proficiencies = racial.racialProfs();
        archetype.classProfs(proficiencies);
        health = archetype.baseHealth() + scoreMods.get("CON");
        if(level > 1){
            for(int i = 2; i <= level; i++) {
                if(i == 4 || i == 8 || i == 12 || i == 16 || i == 19) {
                    this.ASI();
                    this.calcMods();
                }
                this.level = i;
                this.addHealth();
            }
        }
    }

    private void addHealth(){
        int temp = archetype.rollHitDie();
        while(temp == 1)
            temp = archetype.rollHitDie();
        health = health + temp + scoreMods.get("CON");
    }

    private void calcMods(){
        scoreMods = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry: stats.entrySet()){
            scoreMods.put(entry.getKey(),
                            Math.floorDiv(entry.getValue() - 10, 2));

        }
    }


    private void ASI(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to increase your ability score (AS)"
                + " or gain a feat (feat)?");
        String userChoice = sc.nextLine();
        while(!userChoice.equals("AS") && !userChoice.equals("feat")){
            System.out.println("Choice must be AS or feat");
            userChoice = sc.nextLine();
        }
        if(userChoice.equals("AS")){
            for(int i = 0; i < 2; i++){
                System.out.println("Choose an ability to increase:");
                this.printScores();
                String userScore = sc.nextLine();
                while(!allScores.contains(userScore) ||
                        stats.get(userScore) == 20){
                    if(allScores.contains(userScore)){
                        System.out.println("Scores can only be increased to 20."
                                + " Choose another.");
                    }
                    else{
                        System.out.println("That isn't a choice");
                        System.out.println(allScores);
                    }
                    userScore = sc.nextLine();
                }
                stats.put(userScore, stats.get(userScore) + 1);
            }
        }
        else{

        }
    }

    public void printScores(){
        for(Map.Entry<String, Integer> entry: stats.entrySet()){
            System.out.println(entry.getKey() + " -- " + entry.getValue() +
                    "(" + scoreMods.get(entry.getKey()) + ")");
        }
    }

    public Map<String, Integer> getStats() {
        return stats;
    }

    public Integer getLevel(){
        return level;
    }

    public String getRace(){
        return race;
    }

    public String getType(){
        return type;
    }

    public Integer getHealth(){
        return health;
    }

    public Set<String> getKnownLanguages() {
        return knownLanguages;
    }

    public Set<String> getProficiencies() {
        return proficiencies;
    }

}
