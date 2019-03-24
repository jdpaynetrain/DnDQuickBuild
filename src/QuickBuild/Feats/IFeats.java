package QuickBuild.Feats;
import QuickBuild.Character;

import java.util.*;

public interface IFeats {
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
                    "Medium Armor Master", "Mobile", "ModeratelyArmored",
                    "Mounted Combat", "Observant", "Polearm Master",
                    "Resilient", "Ritual Caster", "Savage Attacker",
                    "Sentinel", "Sharpshooter", "Shield Master", "Skilled",
                    "Skulker", "Spell Sniper", "Tavern Brawler", "Tough",
                    "War Caster", "Weapon Master"));

    void updateStats(Character person);

    Boolean metPreReqs(Character person);

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
            case "Weapon Master":
                return new WeaponMaster();
            default:
                return new Empty();
        }
    }

    static Boolean checkPreReqs(Character person, String feat){
        IFeats checker;
        switch(feat){
            case "Defensive Duelist":
                checker = new DefensiveDuelist();
                break;

            case "Elemental Adept":
                checker = new ElementalAdept();
                break;

            case "Grappler":
                checker = new Grappler();
                break;

            case "Heavily Armored":
                checker = new HeavilyArmored();
                break;

            case "Heavy Armor Master":
                checker = new HeavyArmorMaster();
                break;

            case "Inspiring Leader":
                checker = new InspiringLeader();
                break;

            case "Medium Armor Master":
                checker = new MediumArmorMaster();
                break;

            case "Moderately Armored":
                checker = new ModeratelyArmored();
                break;

            case "Ritual Caster":
                checker = new RitualCaster();
                break;

            case "Skulker":
                checker = new Skulker();
                break;

            case "Spell Sniper":
                checker = new SpellSniper();
                break;

            case "War Caster":
                checker = new WarCaster();
                break;

            default:
                checker = new Empty();
        }
        return checker.metPreReqs(person);
    }
}
