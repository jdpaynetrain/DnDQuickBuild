package QuickBuild.Player;

import QuickBuild.Classes.Classes;
import QuickBuild.Feats.IFeats;
import QuickBuild.Races.Races;

import java.util.*;

public class CharacterController {
    private Character model;
    private CharacterView view;

    // Functionality for main()
    public CharacterController(){
        this.model = new Character();
        this.view = new CharacterView();
    }

    public void getUserRace(){
        view.printLine("What race would you like to play? Options are: ");
        view.printSet(Races.allRaces);
        String userRace = view.getUserLine();
        while(!Races.allRaces.contains(userRace)){
            view.printLine("Race must be one of the following.");
            view.printSet(Races.allRaces);
            userRace = view.getUserLine();
        }
        this.setRace(userRace);
    }

    public void getUserClass(){
        view.printLine("What class would you like to play? Options are: ");
        view.printSet(Classes.allClasses);
        String userClass = view.getUserLine();
        while(!Classes.allClasses.contains(userClass)){
            view.printLine("Race must be one of the following.");
            view.printSet(Classes.allClasses);
            userClass = view.getUserLine();
        }
        this.setClass(userClass);
    }

    public void getUserLevel(){
        view.printLine("What level character do you want? (1-20)");
        int level = view.getUserInt();
        while(level > 20 || level < 1){
            view.printLine("Level must be between 1 and 20");
            level = view.getUserInt();
        }
        setMaxLevel(level);
    }

    public void printUsersStats(){
        view.printUserStats(this.model);
    }

    // Functionality for the Character class
    private void setRace(String race){
        model.setRace(race);
    }

    private void setClass(String type){
        model.setClass(type);
    }

    private void setMaxLevel(Integer level){
        model.setMaxLevel(level);
    }

    public void rollCharacter(){
        model.rollCharacter(this);
    }

    public void specialLevel(){
        view.printLine("Would you like to increase your ability score (AS)"
                + " or gain a feat (feat)?");
        String userChoice = view.getUserLine();
        while(!userChoice.equals("AS") && !userChoice.equals("feat")){
            view.printLine("Choice must be AS or feat");
            userChoice = view.getUserLine();
        }
        if(userChoice.equals("AS")){
            this.ASI();
        }
        else{
            this.addFeat();
        }
    }

    private void ASI(){
        for(int i = 0; i < 2; i++){
            view.printLine("Choose an ability to increase");
            view.printUserScores(this.model);
            String userScore = view.getUserLine();
            while(!Character.allScores.contains(userScore) ||
                    model.getStat(userScore) == 20){
                if(Character.allScores.contains(userScore)){
                    view.printLine("Scores can only be increased to 20."
                            + " Choose another.");
                }
                else{
                    view.printLine("That isn't a choice");
                }
                view.printUserScores(this.model);
                userScore = view.getUserLine();
            }
            model.increaseStat(userScore);
        }
    }

    private void addFeat(){
        Set<String> allowedFeats = new HashSet<>();
        for(String curr: IFeats.allFeats){
            if(IFeats.checkPreReqs(this.model, curr) && !model.hasFeat(curr)) {
                allowedFeats.add(curr);
            }
        }
        view.printLine("Choose a feat");
        view.printSet(allowedFeats);
        String userFeat = view.getUserLine();
        while(!allowedFeats.contains(userFeat)){
            view.printLine("That is not an option. Choose another");
            view.printSet(allowedFeats);
            userFeat = view.getUserLine();
        }
        model.addFeat(userFeat);
        model.applyFeat(IFeats.addFeat(userFeat), this);
    }

    // Races functionality
    public void addRacialProfs(Set<String> userProfs, Set<String> possibleProfs){
        view.printLine("Choose one of the following to have proficiency with: ");
        view.printSet(possibleProfs);
        String userChoice = view.getUserLine();
        while(!possibleProfs.contains(userChoice)){
            view.printLine("Choice must be one of the following");
            view.printSet(possibleProfs);
            userChoice = view.getUserLine();
        }
        userProfs.add(userChoice);
    }

    public void addRacialLanguages(Set<String> userLangs, Set<String> possibleLangs){
        view.printLine("Choose a language to learn");
        view.printSet(possibleLangs);
        String userChoice = view.getUserLine();
        while(!possibleLangs.contains(userChoice)){
            view.printLine("That language is not an option. Choose another");
            view.printSet(possibleLangs);
            userChoice = view.getUserLine();
        }
        userLangs.add(userChoice);
    }

    public void applyRaceBuffs(Map<String, Integer> stats, Set<String> statOptions){
        view.printLine("Choose an ability score to increase by 1");
        view.printSet(statOptions);
        String userChoice = view.getUserLine();
        while(!statOptions.contains(userChoice)){
            view.printLine("Choice must be on of the following: ");
            view.printSet(statOptions);
            userChoice = view.getUserLine();
        }
        stats.put(userChoice, stats.get(userChoice) + 1);
    }

    // Class functionality
    public void addClassProfs(Set<String> userProfs, Set<String> possibleProfs){
        view.printLine("Choose a skill to have proficiency in: ");
        view.printSet(possibleProfs);
        String userChoice = view.getUserLine();
        while(!possibleProfs.contains(userChoice)){
            view.printLine("That is not an option choose another");
            view.printSet(possibleProfs);
            userChoice = view.getUserLine();
        }
        userProfs.add(userChoice);
        possibleProfs.remove(userChoice);
    }

    // Feats functionality
    public void applyFeatStats(Character person, Set<String> statOptions){
        for(String curr: statOptions){
            if(person.getStat(curr) >= 20)
                statOptions.remove(curr);
        }
        switch(statOptions.size()){
            case 0:
                break;
            case 1:
                person.increaseStat(statOptions.iterator().next());
                break;
            default:
                view.printLine("Choose an ability to increase");
                view.printSet(statOptions);
                String userChoice = view.getUserLine();
                while(!statOptions.contains(userChoice)){
                    view.printLine("Options are: ");
                    view.printSet(statOptions);
                }
                person.increaseStat(userChoice);
        }
    }

    public void applyFeatLangs(Character person, Set<String> langOptions){
        view.printLine("Choose a language to learn");
        view.printSet(langOptions);
        String userChoice = view.getUserLine();
        while(!langOptions.contains(userChoice)){
            view.printLine("That language is not an option. Choose another");
            view.printSet(langOptions);
            userChoice = view.getUserLine();
        }
        person.addLang(userChoice);
        langOptions.remove(userChoice);
    }

    public void applyFeatProfs(Character person, Set<String> profOptions){
        view.printLine("Choose one of the following to have proficiency with: ");
        view.printSet(profOptions);
        String userChoice = view.getUserLine();
        while(!profOptions.contains(userChoice)){
            view.printLine("Choice must be one of the following");
            view.printSet(profOptions);
            userChoice = view.getUserLine();
        }
        person.addProf(userChoice);
        profOptions.remove(userChoice);
    }

    public void applyWeaponMaster(Character person){
        for(int i = 0; i < 4; i++){
            view.printLine("Choose 4 weapons to have proficiency with.");
            String userChoice = view.getUserLine();
            while(person.hasProf(userChoice)){
                view.printLine("You already have proficiency.");
                userChoice = view.getUserLine();
            }
            person.addProf(userChoice);
        }
    }
}
