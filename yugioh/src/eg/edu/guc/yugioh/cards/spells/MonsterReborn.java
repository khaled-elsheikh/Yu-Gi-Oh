package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
public class MonsterReborn extends SpellCard {

	public MonsterReborn(String name, String description) {
		super(name, description);
	}

	@Override
	public void action(MonsterCard monster)
	{
		boolean f = false;
		Player p1 = this.getBoard().getActivePlayer();
		Player p2 = this.getBoard().getOpponentPlayer();
		if (p1.getField().getGraveyard().isEmpty() && p2.getField().getGraveyard().isEmpty())
		{
			return;
		}
		MonsterCard strongestMonster = (MonsterCard) p1.getField().getGraveyard().get(0);
		
		for (Card c: p1.getField().getGraveyard())
		{
			if (c instanceof MonsterCard)
			{
				if (((MonsterCard) c).getAttackPoints() > strongestMonster.getAttackPoints())
				{
					strongestMonster = (MonsterCard) c;
				}
			}
		}
		
		for (Card c: p2.getField().getGraveyard())
		{
			if (c instanceof MonsterCard)
			{
				if (((MonsterCard) c).getAttackPoints() > strongestMonster.getAttackPoints())
				{
					strongestMonster = (MonsterCard) c;
					f = true;
				}
			}
		}
		
		p1.getField().addMonsterToField(strongestMonster, strongestMonster.getMode(), null);
		if (f)
		{
			p2.getField().getGraveyard().remove(strongestMonster);
		}
		else
		{
			p1.getField().getGraveyard().remove(strongestMonster);
		}
	}
}
