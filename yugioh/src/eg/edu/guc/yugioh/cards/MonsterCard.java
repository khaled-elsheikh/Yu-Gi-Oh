package eg.edu.guc.yugioh.cards;


public class MonsterCard extends Card {
	
	private int level;
	private int defensePoints;
	private int attackPoints;
	private Mode mode;
	private int MonsterAttack;
	private int MonsterMode;

	
	
public MonsterCard(String name, String description, int level, int attack, int defence)
{
	super(name,description);
	this.level = level;
	attackPoints = attack;
	defensePoints = defence;
	this.mode = Mode.DEFENSE;
	
	MonsterAttack = 0;
	MonsterMode = 0;

}


public int getDefensePoints() {
	return defensePoints;
}

public void setDefensePoints(int defensePoints) {
	this.defensePoints = defensePoints;
}

public int getAttackPoints() {
	return attackPoints;
}

public void setAttackPoints(int attackPoints) {
	this.attackPoints = attackPoints;
}

public Mode getMode() {
	return mode;
}

public void setMode(Mode mode) {
	this.mode = mode;
}

public int getLevel() {
	return level;
}

@Override
public void action(MonsterCard monster) {
	
		if(monster.getMode().equals(Mode.ATTACK)){
			if(this.getAttackPoints() == monster.getAttackPoints()){
				Card.getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
				Card.getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
			}else{
				if(this.getAttackPoints() > monster.getAttackPoints()){
					int x = this.getAttackPoints() - monster.getAttackPoints();
					Card.getBoard().getOpponentPlayer().setLifePoints((Card.getBoard().getOpponentPlayer().getLifePoints()-x));
					Card.getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
				}else{
					if(this.getAttackPoints() < monster.getAttackPoints()){
						int x = monster.getAttackPoints() - this.getAttackPoints();
						Card.getBoard().getActivePlayer().setLifePoints((Card.getBoard().getActivePlayer().getLifePoints()-x));
						Card.getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
					}
				}
			}
		}else{
			if(this.getAttackPoints() > monster.getDefensePoints()){
				Card.getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
			}else{
				if(this.getAttackPoints() < monster.getDefensePoints()){
					int x = monster.getDefensePoints() - this.getAttackPoints();
					Card.getBoard().getActivePlayer().setLifePoints(Card.getBoard().getActivePlayer().getLifePoints() - x);
				}
			}
		}
		
	}



@Override
public void action() {
	int x = Card.getBoard().getOpponentPlayer().getLifePoints() - this.getAttackPoints();
	Card.getBoard().getOpponentPlayer().setLifePoints(x);
}


public int getMonsterAttack() {
	return MonsterAttack;
}


public void setMonsterAttack(int monsterAttack) {
	MonsterAttack = monsterAttack;
}


public void setLevel(int level) {
	this.level = level;
}


public int getMonsterMode() {
	return MonsterMode;
}


public void setMonsterMode(int monsterMode) {
	MonsterMode = monsterMode;
}
}
