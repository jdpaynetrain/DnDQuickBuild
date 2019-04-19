package QuickBuild;

import QuickBuild.Classes.*;
import QuickBuild.Races.*;
import QuickBuild.Feats.*;
import com.sun.source.tree.IfTree;

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
    static public Set<String> allScores = new HashSet<>
            (Arrays.asList("STR", "DEX", "CON", "INT", "WIS", "CHA"));
    private Integer initiative;
    private Integer initBonus;
    private Set<String> feats;
    private Integer healthBonus;

    public Character(){
        feats = new HashSet<>();
        initBonus = 0;
        healthBonus = 0;

        // Base stats will be rolled right when the character is declared
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
        /*
         * Levels 4, 8, 12, 16, and 19 all have the choice of increasing two
         * ability scores or choosing a feat. At every level they gain health
         */
        if(level > 1){
            for(int i = 2; i <= level; i++) {
                if(i == 4 || i == 8 || i == 12 || i == 16 || i == 19) {
                    this.specialLevel();
                    this.calcMods();
                }
                this.level = i;
                this.addHealth();
            }
        }
    }

    // Every class has their own hit die and this re-rolls 1s
    private void addHealth(){
        int temp = archetype.rollHitDie();
        if(feats.contains("Durable"))
            while(temp > Math.max(scoreMods.get("CON") * 2, 2))
                temp = archetype.rollHitDie();
        else
            while(temp == 1)
                temp = archetype.rollHitDie();
        health = health + temp + scoreMods.get("CON") + healthBonus;
    }

    public void addHealth(Integer health){
        this.health += health;
    }

    // Mods are based off the (ability score - 10) / 2
    private void calcMods(){
        scoreMods = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry: stats.entrySet()){
            scoreMods.put(entry.getKey(),
                            Math.floorDiv(entry.getValue() - 10, 2));

        }
        // Initiative is based on the dex mod and bonuses if they exist
        this.initiative = scoreMods.get("DEX") + initBonus;
    }

    // Special levels are 4, 8, 12, 16, and 19 and this gets the user's choice
    // For those levels
    private void specialLevel(){
        Scanner sc = new Scanner(System.in);
        Character.printToUser("Would you like to increase your ability score (AS)"
                + " or gain a feat (feat)?");
        String userChoice = sc.nextLine();
        while(!userChoice.equals("AS") && !userChoice.equals("feat")){
            Character.printToUser("Choice must be AS or feat");
            userChoice = sc.nextLine();
        }
        if(userChoice.equals("AS")){
            this.ASI();
        }
        else{
            this.addFeat();
        }
    }

    // This gets the user's choice for scores to increase and increases them
    private void ASI(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 2; i++){
            Character.printToUser("Choose an ability to increase:");
            this.printScores();
            String userScore = sc.nextLine();
            while(!allScores.contains(userScore) ||
                    stats.get(userScore) == 20){
                if(allScores.contains(userScore)){
                    Character.printToUser("Scores can only be increased to 20."
                            + " Choose another.");
                }
                else{
                    Character.printToUser("That isn't a choice");
                }
                this.printScores();
                userScore = sc.nextLine();
            }
            this.updateStat(userScore, 1);
        }
    }

    // Get's the user's feat choice and adds it
    private void addFeat(){
        Set<String> allowedFeats = allowedFeats();
        Scanner sc = new Scanner(System.in);
        Character.printToUser("Choose a feat");
        Character.printToUser(allowedFeats.toString());
        String userFeat = sc.nextLine();
        // We want to ensure the user doesn't have the feat, the choice is
        // allowed and they meet the prereqs for the feats
        while(!allowedFeats.contains(userFeat)){
            Character.printToUser("That is not an option. Chose another");
            Character.printToUser(allowedFeats.toString());
            userFeat = sc.nextLine();
        }
        feats.add(userFeat);
        this.applyFeat(IFeats.addFeat(userFeat));
    }

    private Set<String> allowedFeats(){
        Set<String> allowed = new HashSet<>();
        for(String curr: IFeats.allFeats){
            if(IFeats.checkPreReqs(this, curr) && !feats.contains(curr)){
                allowed.add(curr);
            }
        }
        return allowed;
    }

    private void applyFeat(IFeats aFeat){
        aFeat.updateStats(this);
    }

    public void printScores(){
        for(Map.Entry<String, Integer> entry: stats.entrySet()){
            Character.printToUser(entry.getKey() + " -- " + entry.getValue() +
                    "(" + scoreMods.get(entry.getKey()) + ")");
        }
    }

    // Adders/getters/setters
    public void updateStat(String stat, Integer bonus){
        stats.put(stat, Math.min(stats.get(stat) + bonus, 20));
    }

    public Boolean hasProf(String prof){
        return proficiencies.contains(prof);
    }

    public Boolean hasLang(String lang){
        return knownLanguages.contains(lang);
    }

    public void addInit(Integer bonus){
        this.initBonus += bonus;
    }

    public void addProf(String prof){
        proficiencies.add(prof);
    }

    public void addHealthBonus(Integer bonus){ this.healthBonus += bonus; }

    public void addLang(String lang){  knownLanguages.add(lang);}

    public Map<String, Integer> getStats() {
        return stats;
    }

    public Integer checkStat(String stat){
        return stats.get(stat);
    }

    public Set<String> getFeats(){
        return feats;
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

    public Integer getInitiative(){
        return initiative;
    }

    static public void printToUser(String output){
        System.out.println(output);
    }

}
