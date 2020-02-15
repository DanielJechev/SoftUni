package core.interfaces;

public interface ManagerController {
    String addPlayer(String type, String username);
    String addCard(String type, String name);
    String addPlayerCard(String username,String cardName);
    String fight(String attackUser, String enemyUser);
    String report();
}
