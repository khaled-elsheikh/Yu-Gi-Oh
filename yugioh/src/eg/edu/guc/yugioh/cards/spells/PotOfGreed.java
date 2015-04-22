package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class PotOfGreed extends SpellCard{

	public PotOfGreed(String name, String description) {
		super(name, description);
	}

	@Override
	public void action(MonsterCard monster)
	{
		this.getBoard().getActivePlayer().getField().addNCardsToHand(2);
	}
}
