package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class HarpieFeatherDuster extends SpellCard {

	public HarpieFeatherDuster(String name, String description) {
		super(name, description);
	}

	@Override
	public void action(MonsterCard monster)
	{
		Card.getBoard().getOpponentPlayer()
		.getField().removeSpellToGraveyard(Card.getBoard()
				.getOpponentPlayer().getField().getSpellArea());
		
	}
}
