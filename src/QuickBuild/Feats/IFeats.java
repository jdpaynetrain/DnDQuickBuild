package QuickBuild.Feats;
import QuickBuild.Character;

import java.util.*;

public interface IFeats {
    Set<String> allFeats = new HashSet<>
            (Arrays.asList("Alert", "Athlete"));

    void updateStats(Character person);

    static IFeats addFeat(String feat){
        switch (feat){
            case "Alert":
                return new Alert();
            case "Athlete":
                return new Athlete();

        }
    }

    static Boolean checkPreReqs(Character person, String feat){
        IFeats checker;
        switch(feat){
            case "Defensive Duelist":
                //checker = new DefensiveDuelist();
                break;

            case "Elemental Adept":
                //checker = new ElementalAdept();
                break;

            case "Grappler":
                //checker = new Grappler();
                break;

            case "Heavily Armored":
                //checker = new HeavilyArmored();
                break;

            case "Heavy Armor Master":
                //checker = new HeavyArmorMaster();
                break;

            case "Inspiring Leader":
                //checker = new InspiringLeader();
                break;

            case "Medium Armor Master":
                //checker = new MediumArmorMaster();
                break;

            case "Moderately Armored":
                //checker = new ModeratelyArmored();
                break;

            case "Ritual Caster":
                //checker = new RitualCaster();
                break;

            case "Skulker":
                //checker = new Skulker();
                break;

            case "Spell Sniper":
                //checker = new SpellSniper();
                break;

            case "War Caster":
                //checker = new WarCaster();
                break;

            default:
                checker = new Empty();
        }
        return checker.metPreReqs(person);
    }
}
