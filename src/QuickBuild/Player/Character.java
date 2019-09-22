package QuickBuild.Player;

import QuickBuild.Classes.*;
import QuickBuild.Races.*;
import QuickBuild.Feats.*;
import QuickBuild.StatRoller;

import java.util.*;

public class Character {
    private List<Integer> baseStats;
    private Classes mClass;
    private Races mRace;
    private Map<String, Integer> stats;
    private Map<String, Integer> scoreMods;
    private String currType;
    private String currRace;
    private Set<String> proficiencies;
    private Set<String> knownLanguages;
    private Integer health;
    private Integer level;
    static public Set<String> allScores = new HashSet<>
            (Arrays.asList("STR", "DEX", "CON", "INT", "WIS", "CHA"));
    private Integer initiative;
    private Integer initBonus;
    private Set<String> feats;
    private Integer healthBonus;
    private Integer maxLevel;

    public Character(){
        feats = new HashSet<>();
        scoreMods = new LinkedHashMap<>();
        initBonus = 0;
        healthBonus = 0;

        // Base stats will be rolled right when the character is declared
        StatRoller roller = new StatRoller();
        baseStats = roller.rollStats();
    }

    public void rollCharacter(CharacterController control){
        this.level = 1;
        this.applyClass();
        this.applyRace(control);
        this.calcMods();
        this.knownLanguages = mRace.racialLanguages(control);
        this.proficiencies = mRace.racialProfs(control);
        mClass.classProfs(proficiencies, control);
        health = mClass.baseHealth() + scoreMods.get("CON");
        /*
         * Levels 4, 8, 12, 16, and 19 all have the choice of increasing two
         * ability scores or choosing a feat. At every level they gain health
         */
        if(maxLevel > 1){
            for(int i = 2; i <= maxLevel; i++) {
                if(i == 4 || i == 8 || i == 12 || i == 16 || i == 19) {
                    control.specialLevel();
                    this.calcMods();
                }
                // Rogues get an additional bonus at level 10
                else if(i == 10 && currType.equals("Rogue")){
                    control.specialLevel();
                    this.calcMods();
                }
                this.level = i;
                this.addLevelHealth();
            }
        }
    }

    public void setClass(String type){
        this.currType = type;
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

    private void applyClass(){
        stats = mClass.applyModifiers(baseStats);
    }

    public void setRace(String Race){
        this.currRace = Race;
        if(Race.equals("Hill Dwarf"))
            mRace = new DwarfHill();
        else if(Race.equals("Mountain Dwarf"))
            mRace = new DwarfMountain();
        else if(Race.equals("High Elf"))
            mRace = new ElfHigh();
        else if(Race.equals("Wood Elf"))
            mRace = new ElfWood();
        else if(Race.equals("Dark Elf"))
            mRace = new ElfDark();
        else if(Race.equals("Lightfoot Halfling"))
            mRace = new HalflingLightfoot();
        else if(Race.equals("Stout Halfling"))
            mRace = new HalflingStout();
        else if(Race.equals("Human"))
            mRace = new Human();
        else if(Race.equals("Dragonborn"))
            mRace = new Dragonborn();
        else if(Race.equals("Forest Gnome"))
            mRace = new GnomeForest();
        else if(Race.equals("Rock Gnome"))
            mRace = new GnomeRock();
        else if(Race.equals("Half Elf"))
            mRace = new HalfElf();
        else if(Race.equals("Half Orc"))
            mRace = new HalfOrc();
        else if(Race.equals("Tiefling"))
            mRace = new Tiefling();
    }

    private void applyRace(CharacterController control){
        mRace.applyBuffs(stats, control);
    }

    // Every class has their own hit die and this re-rolls 1s
    private void addLevelHealth(){
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

    public void applyFeat(IFeats aFeat, CharacterController control){
        aFeat.updateStats(this, control);
    }

    // Adders/getters/setters
    public void setMaxLevel(Integer level){
        this.maxLevel = level;
    }

    public void updateStat(String stat, Integer bonus){
        stats.put(stat, Math.min(stats.get(stat) + bonus, 20));
    }

    public void increaseStat(String stat) { stats.put(stat, Math.min(stats.get(stat) + 1, 20));}

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

    public Boolean hasFeat(String feat){
        return feats.contains(feat);
    }

    public void addFeat(String feat){
        feats.add(feat);
    }

    public Integer getStat(String stat){
        return stats.get(stat);
    }

    public Integer getMod(String stat) { return scoreMods.get(stat); }

    public Set<String> getFeats(){
        return feats;
    }

    public Integer getLevel(){
        return level;
    }

    public String getRace(){
        return currRace;
    }

    public String getType(){
        return currType;
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
