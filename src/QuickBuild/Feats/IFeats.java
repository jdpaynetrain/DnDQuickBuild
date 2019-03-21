package QuickBuild.Feats;
import QuickBuild.Character;

public interface IFeats {
    Boolean metPreReqs(Character person);
    void updateStats(Character person);
}
