package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class GracefulDice extends SpellCard {

	public GracefulDice(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}
	public void action(MonsterCard monster){
		int x = (int)(Math.random()*10)+1;
		
		int P1MonsterNumber = Card.getBoard().getActivePlayer().getField().getMonstersArea().size();
		for(int i = 0 ; i < P1MonsterNumber ; i++){
			
			Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).setAttackPoints(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getAttackPoints()+(x*100));
			Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).setDefensePoints(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getDefensePoints()+(x*100));
		}
	}
	

}
