package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class DarkHole extends Raigeki {

	public DarkHole(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}
	public void action(MonsterCard monster){
		super.action(monster);
		while(!Card.getBoard().getActivePlayer().getField().getMonstersArea().isEmpty()){
			Card.getBoard().getActivePlayer()
			.getField().getMonstersArea().get(0).setLocation(Location.GRAVEYARD);
			Card.getBoard().getActivePlayer().getField()
			.getGraveyard().add(Card.getBoard().getActivePlayer()
					.getField().getMonstersArea().remove(0));
		}
	}

}
