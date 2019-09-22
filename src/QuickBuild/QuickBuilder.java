package QuickBuild;

import QuickBuild.Player.CharacterController;

public class QuickBuilder {
    public static void main(String[] args){
        CharacterController quickBuild = new CharacterController();

        quickBuild.getUserRace();
        quickBuild.getUserClass();
        quickBuild.getUserLevel();
        quickBuild.rollCharacter();
        quickBuild.printUsersStats();
    }
}
