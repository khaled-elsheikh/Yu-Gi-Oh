package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class ChangeOfHeart extends SpellCard {

	public ChangeOfHeart(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}
	public void action(MonsterCard monster){
		getBoard().getActivePlayer().getField().addMonsterToField(monster, monster.getMode(), null);
		getBoard().getOpponentPlayer().getField().getMonstersArea().remove(monster);
	}
	

}
