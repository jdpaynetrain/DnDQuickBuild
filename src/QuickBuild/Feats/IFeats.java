package QuickBuild.Feats;
import QuickBuild.Character;
import QuickBuild.QuickBuilder;

import java.util.*;

public interface IFeats {
    // Some feats require the player to be able to cast a spell and since
    // spell lists are outside the scope of this program, I just see if
    // they are a spellcasting class
    Set<String> spellCasters = new HashSet<>
            (Arrays.asList("Bard", "Cleric", "Druid", "Paladin", "Ranger",
                    "Sorcerer", "Warlock", "Wizard"));
    Set<String> allFeats = new HashSet<>
            (Arrays.asList("Alert", "Athlete", "Actor", "Charger",
                    "Crossbow Expert", "Defensive Duelist", "Dual Wielder",
                    "Dungeon Delver", "Durable", "Elemental Adept",
                    "Grappler", "Great Weapon Master", "Healer",
                    "Heavily Armored", "Heavy Armor Master", "Inspiring Leader",
                    "Keen Mind", "Lightly Armored", "Linguist", "Lucky",
                    "Mage Slayer", "Magic Initiate", "Martial Adept",
                    "Medium Armor Master", "Mobile", "Moderately Armored",
                    "Mounted Combat", "Observant", "Polearm Master",
                    "Resilient", "Ritual Caster", "Savage Attacker",
                    "Sentinel", "Sharpshooter", "Shield Master", "Skilled",
                    "Skulker", "Spell Sniper", "Tavern Brawler", "Tough",
                    "War Caster", "Weapon Master"));

    void updateStats(Character person);

    String featDescription();

    // I use this a constructor since dynamic variables aren't a thing in java
    static IFeats addFeat(String feat){
        switch (feat){
            case "Alert":
                return new Alert();
            case "Athlete":
                return new Athlete();
            case "Actor":
                return new Actor();
            case "Charger":
                return new Charger();
            case "Crossbow Expert":
                return new CrossbowExpert();
            case "Defensive Duelist":
                return new DefensiveDuelist();
            case "Dual Wielder":
                return new DualWielder();
            case "Dungeon Delver":
                return new DungeonDelver();
            case "Durable":
                return new Durable();
            case "Elemental Adept":
                return new ElementalAdept();
            case "Grappler":
                return new Grappler();
            case "Great Weapon Master":
                return new GreatWeaponMaster();
            case "Healer":
                return new Healer();
            case "Heavily Armored":
                return new HeavilyArmored();
            case "Heavy Armor Master":
                return new HeavyArmorMaster();
            case "Inspiring Leader":
                return new InspiringLeader();
            case "Keen Mind":
                return new KeenMind();
            case "Lightly Armored":
                return new LightlyArmored();
            case "Linguist":
                return new Linguist();
            case "Lucky":
                return new Lucky();
            case "Mage Slayer":
                return new MageSlayer();
            case "Magic Initiate":
                return new MagicInitiate();
            case "Martial Adept":
                return new MartialAdept();
            case "Medium Armor Master":
                return new MediumArmorMaster();
            case "Mobile":
                return new Mobile();
            case "Moderately Armored":
                return new ModeratelyArmored();
            case "Mounted Combat":
                return new MountedCombat();
            case "Observant":
                return new Observant();
            case "Polearm Master":
                return new PolearmMaster();
            case "Resilient":
                return new Resilient();
            case "Ritual Caster":
                return new RitualCaster();
            case "Savage Attacker":
                return new SavageAttacker();
            case "Sentinel":
                return new Sentinel();
            case "Sharpshooter":
                return new Sharpshooter();
            case "Shield Master":
                return new ShieldMaster();
            case "Skilled":
                return new Skilled();
            case "Skulker":
                return new Skulker();
            case "Spell Sniper":
                return new SpellSniper();
            case "Tavern Brawler":
                return new TavernBrawler();
            case "Tough":
                return new Tough();
            case "War Caster":
                return new WarCaster();
            default:
                return new WeaponMaster();
        }
    }

    // Feats that have pre-reqs have static metPreReq functions so if it isn't
    // one of those I just return true
    static Boolean checkPreReqs(Character person, String feat){
        switch(feat){
            case "Defensive Duelist":
                return DefensiveDuelist.metPreReqs(person);

            case "Elemental Adept":
                return ElementalAdept.metPreReqs(person);

            case "Grappler":
                return Grappler.metPreReqs(person);

            case "Heavily Armored":
                return HeavilyArmored.metPreReqs(person);

            case "Heavy Armor Master":
                return HeavyArmorMaster.metPreReqs(person);

            case "Inspiring Leader":
                return InspiringLeader.metPreReqs(person);

            case "Medium Armor Master":
                return MediumArmorMaster.metPreReqs(person);

            case "Moderately Armored":
                return ModeratelyArmored.metPreReqs(person);

            case "Ritual Caster":
                return RitualCaster.metPreReqs(person);

            case "Skulker":
                return Skulker.metPreReqs(person);

            case "Spell Sniper":
                return SpellSniper.metPreReqs(person);

            case "War Caster":
                return WarCaster.metPreReqs(person);

            default:
                return true;
        }
    }

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
