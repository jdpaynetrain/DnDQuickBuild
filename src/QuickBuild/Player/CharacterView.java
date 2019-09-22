package QuickBuild.Player;

import java.util.Scanner;
import java.util.Set;

public class CharacterView {
    private static final Scanner sc = new Scanner(System.in);

    public String getUserLine(){
        return sc.nextLine();
    }

    public Integer getUserInt(){
        Integer value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    public void printLine(String message){
        System.out.println(message);
    }

    public void printSet(Set<?> message){
        System.out.println(message.toString());
    }

    public void printUserStats(Character person){
        System.out.println(person.getRace() + "-" + person.getType());
        System.out.println("Level: " + person.getLevel());
        this.printUserScores(person);
        System.out.println("Initiative: " + person.getInitiative());
        System.out.println("Health: " + person.getHealth());
        System.out.println("Proficiencies are:");
        System.out.println(person.getProficiencies().toString());
        System.out.println("Known languages are:");
        System.out.println(person.getKnownLanguages().toString());
        if(person.getFeats().size() > 0) {
            System.out.println("Feats:");
            System.out.println(person.getFeats().toString());
        }
    }

    public void printUserScores(Character person){
        System.out.println("Strength     -- " + person.getStat("STR") + "(" + person.getMod("STR") + ")");
        System.out.println("Dexterity    -- " + person.getStat("DEX") + "(" + person.getMod("DEX") + ")");
        System.out.println("Constitution -- " + person.getStat("CON") + "(" + person.getMod("CON") + ")");
        System.out.println("Intelligence -- " + person.getStat("INT") + "(" + person.getMod("INT") + ")");
        System.out.println("Wisdom       -- " + person.getStat("WIS") + "(" + person.getMod("WIS") + ")");
        System.out.println("Charisma     -- " + person.getStat("CHA") + "(" + person.getMod("CHA") + ")");
    }
}
