package QuickBuild;

import QuickBuild.Classes.*;
import QuickBuild.Races.*;
import QuickBuild.Feats.*;

import java.util.*;

public class Character {
    private List<Integer> baseStats;
    private Classes mClass;
    private Races mRace;
    private Map<String, Integer> stats;
    private Map<String, Integer> scoreMods;
    private String type;
    private String nRace;
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
        scoreMods = new LinkedHashMap<>();
        initBonus = 0;
        healthBonus = 0;

        // Base stats will be rolled right when the character is declared
        StatRoller roller = new StatRoller();
        baseStats = roller.rollStats();
    }

    public void rollCharacter(String type, String nRace, Integer level){
        this.type = type;
        this.nRace = nRace;
        this.level = 1;
        this.applyClass(type);
        this.applyRace(nRace);
        this.calcMods();
        this.knownLanguages = mRace.racialLanguages();
        this.proficiencies = mRace.racialProfs();
        mClass.classProfs(proficiencies);
        health = mClass.baseHealth() + scoreMods.get("CON");
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
                // Rogues get an additional bonus at level 10
                else if(i == 10 && type.equals("Rogue")){
                    this.specialLevel();
                    this.calcMods();
                }
                this.level = i;
                this.addHealth();
            }
        }
    }
    private void setClass(String type){
        if(type.equals("Barbarian"))
            mClass = new Barbarian();
        else if(type.equals("Bard"))
            mClass = new Bard();
        else if(type.equals("Cleric"))
            mClass = new Cleric();
        else if(type.equals("Druid"))
            mClass = new Druid();
        else if(type.equals("Fighter"))
            mClass = new Fighter();
        else if(type.equals("Monk"))
            mClass = new Monk();
        else if(type.equals("Paladin"))
            mClass = new Paladin();
        else if(type.equals("Ranger"))
            mClass = new Ranger();
        else if(type.equals("Rogue"))
            mClass = new Rogue();
        else if(type.equals("Sorcerer"))
            mClass = new Sorcerer();
        else if(type.equals("Warlock"))
            mClass = new Warlock();
        else if(type.equals("Wizard"))
            mClass = new Wizard();
    }

    private void applyClass(String type){
        this.setClass(type);
        stats = mClass.applyModifiers(baseStats);
    }

    private void setRace(String nRace){
        if(nRace.equals("Hill Dwarf"))
            mRace = new DwarfHill();
        else if(nRace.equals("Mountain Dwarf"))
            mRace = new DwarfMountain();
        else if(nRace.equals("High Elf"))
            mRace = new ElfHigh();
        else if(nRace.equals("Wood Elf"))
            mRace = new ElfWood();
        else if(nRace.equals("Dark Elf"))
            mRace = new ElfDark();
        else if(nRace.equals("Lightfoot Halfling"))
            mRace = new HalflingLightfoot();
        else if(nRace.equals("Stout Halfling"))
            mRace = new HalflingStout();
        else if(nRace.equals("Human"))
            mRace = new Human();
        else if(nRace.equals("Dragonborn"))
            mRace = new Dragonborn();
        else if(nRace.equals("Forest Gnome"))
            mRace = new GnomeForest();
        else if(nRace.equals("Rock Gnome"))
            mRace = new GnomeRock();
        else if(nRace.equals("Half Elf"))
            mRace = new HalfElf();
        else if(nRace.equals("Half Orc"))
            mRace = new HalfOrc();
        else if(nRace.equals("Tiefling"))
            mRace = new Tiefling();
    }

    private void applyRace(String nRace){
        this.setRace(nRace);
        mRace.applyBuffs(stats);
    }

    // Every class has their own hit die and this re-rolls 1s
    private void addHealth(){
        int temp = mClass.rollHitDie();
        while(temp == 1)
                temp = mClass.rollHitDie();
        health = health + temp + scoreMods.get("CON") + healthBonus;
    }

    public void addHealth(Integer health){
        this.health += health;
    }

    // Mods are based off (ability score - 10) / 2
    private void calcMods(){
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
        QuickBuilder.printToUser("Would you like to increase your ability score (AS)"
                + " or gain a feat (feat)?");
        String userChoice = QuickBuilder.getUserLine();
        while(!userChoice.equals("AS") && !userChoice.equals("feat")){
            QuickBuilder.printToUser("Choice must be AS or feat");
            userChoice = QuickBuilder.getUserLine();
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
        for(int i = 0; i < 2; i++){
            QuickBuilder.printToUser("Choose an ability to increase:");
            this.printScores();
            String userScore = QuickBuilder.getUserLine();
            while(!allScores.contains(userScore) ||
                    stats.get(userScore) == 20){
                if(allScores.contains(userScore)){
                    QuickBuilder.printToUser("Scores can only be increased to 20."
                            + " Choose another.");
                }
                else{
                    QuickBuilder.printToUser("That isn't a choice");
                }
                this.printScores();
                userScore = QuickBuilder.getUserLine();
            }
            this.updateStat(userScore, 1);
        }
    }

    // Get's the user's feat choice and adds it
    private void addFeat(){
        Set<String> allowedFeats = new HashSet<>();
        for(String curr: IFeats.allFeats){
            if(IFeats.checkPreReqs(this, curr) && !feats.contains(curr)){
                allowedFeats.add(curr);
            }
        }
        QuickBuilder.printToUser("Choose a feat");
        QuickBuilder.printToUser(allowedFeats.toString());
        String userFeat = QuickBuilder.getUserLine();
        while(!allowedFeats.contains(userFeat)){
            QuickBuilder.printToUser("That is not an option. Chose another");
            QuickBuilder.printToUser(allowedFeats.toString());
            userFeat = QuickBuilder.getUserLine();
        }
        feats.add(userFeat);
        this.applyFeat(IFeats.addFeat(userFeat));
    }

    private void applyFeat(IFeats aFeat){
        aFeat.updateStats(this);
    }

    public void printScores(){
        for(Map.Entry<String, Integer> entry: stats.entrySet()){
            QuickBuilder.printToUser(entry.getKey() + " -- " + entry.getValue() +
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
        return nRace;
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

}
