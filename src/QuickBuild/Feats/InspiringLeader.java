package QuickBuild.Feats;
import QuickBuild.Player.Character;

public class InspiringLeader implements IFeats {

    static public Boolean metPreReqs(Character person){
        return person.getStat("CHA") >= 13;
    }

    public String featDescription(){
        return "You can spend 10 minutes inspiring your companions,\n" +
                "shoring up their resolve to fight. When you do so, choose " +
                "up to six friendly creatures (which can include yourself) " +
                "within 30 feet of you who can see or hear you and who " +
                "can understand you. Each creature can gain temporary " +
                "hit points equal to your level + your Charisma modifier. " +
                "A creature can’t gain temporary hit points from this feat " +
                "again until it has finished a short or long rest.";
    }
}
