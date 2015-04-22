package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class CardDestruction extends SpellCard{

	public CardDestruction(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}
	
	public void action(MonsterCard monster) {
		int P1NumberOfCards = Card.getBoard().getActivePlayer().getField().getHand().size();
		int P2NumberOfCards = Card.getBoard().getOpponentPlayer().getField().getHand().size();
		while(!getBoard().getActivePlayer().getField().getHand().isEmpty()){
			Card.getBoard().getActivePlayer().getField().getGraveyard().add(getBoard().getActivePlayer().getField().getHand().get(0));
			Card.getBoard().getActivePlayer().getField().getHand().remove(0);
		}
		Card.getBoard().getActivePlayer().getField().getHand().clear();
		while(!getBoard().getOpponentPlayer().getField().getHand().isEmpty()){
			Card.getBoard().getOpponentPlayer().getField().getGraveyard().add(getBoard().getOpponentPlayer().getField().getHand().get(0));
			Card.getBoard().getOpponentPlayer().getField().getHand().remove(0);
		}
		Card.getBoard().getOpponentPlayer().getField().getHand().clear();
		
		
		Card.getBoard().getActivePlayer().getField().addNCardsToHand(P1NumberOfCards);
		Card.getBoard().getOpponentPlayer().getField().addNCardsToHand(P2NumberOfCards);
	}

	
	
	

}
