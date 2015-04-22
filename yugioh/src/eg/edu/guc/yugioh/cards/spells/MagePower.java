package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class MagePower extends SpellCard {

	public MagePower(String name, String description) {
		super(name, description);
	}

	@Override
	public void action(MonsterCard monster)
	{
		Player p = this.getBoard().getActivePlayer();
		int atkPoints = p.getField().getSpellArea().size() * 500;
		int defPoints = p.getField().getSpellArea().size() * 500;
		int index = p.getField().getMonstersArea().indexOf(monster);
		monster.setAttackPoints(monster.getAttackPoints() + atkPoints);
		monster.setDefensePoints(monster.getDefensePoints() + defPoints);
		p.getField().getMonstersArea().remove(index);
		p.getField().getMonstersArea().add(index, monster);
	}
}
