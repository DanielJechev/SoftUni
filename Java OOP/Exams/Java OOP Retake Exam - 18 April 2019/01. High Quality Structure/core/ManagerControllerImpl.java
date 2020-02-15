package core;

import common.ConstantMessages;
import core.interfaces.ManagerController;
import models.Advanced;
import models.Beginner;
import models.MagicCard;
import models.TrapCard;
import models.cards.interfaces.Card;
import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;
import repositories.interfaces.CardRepositoryImpl;
import repositories.interfaces.PlayerRepository;
import repositories.interfaces.PlayerRepositoryImpl;


public class ManagerControllerImpl implements ManagerController {
    private PlayerRepository playerRepository;
    private CardRepository cardRepository;



    public ManagerControllerImpl() {
        this.playerRepository=new PlayerRepositoryImpl();
        this.cardRepository=new CardRepositoryImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        Player player;
        if (type.equals("Beginner")){
            player=new Beginner(new CardRepositoryImpl(),username);
        }else {
            player=new Advanced(new CardRepositoryImpl(),username);
        }
        this.playerRepository.add(player);

        return  String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER,type,username);
    }

    @Override
    public String addCard(String type, String name) {
        Card card;
        if (type.equals("Trap")){
            card=new TrapCard(name);
        }else {
            card=new MagicCard(name);
        }

        this.cardRepository.add(card);

        return  String.format(ConstantMessages.SUCCESSFULLY_ADDED_CARD,type,name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        return  null;
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        return  null;
    }

    @Override
    public String report() {
        return  null;
    }
}
