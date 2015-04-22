package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class Raigeki extends SpellCard {

	public Raigeki(String name, String description) {
		super(name, description);
	}
	public void action(MonsterCard monster){
		while(!Card.getBoard().getOpponentPlayer().getField().getMonstersArea().isEmpty()){
			Card.getBoard().getOpponentPlayer()
			.getField().getMonstersArea().get(0).setLocation(Location.GRAVEYARD);
			Card.getBoard().getOpponentPlayer().getField()
			.getGraveyard().add(Card.getBoard().getOpponentPlayer()
					.getField().getMonstersArea().remove(0));
		}
		
	}

}
