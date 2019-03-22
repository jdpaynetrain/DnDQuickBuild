package QuickBuild.Feats;
import QuickBuild.Character;

public interface IFeats {
    Boolean metPreReqs(Character person);
    void updateStats(Character person);

    default void addFeat(Character person, String feat){
        IFeats temp;
        switch (feat) {
            case "Athlete":
                temp = new Athlete();
                break;
            default:
                temp = new Alert();
                break;
        }
        temp.updateStats(person);
    }
}
