package eg.edu.guc.yugioh.board.player;

import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.DefenseMonsterAttackException;
import eg.edu.guc.yugioh.exceptions.MonsterMultipleAttackException;
import eg.edu.guc.yugioh.exceptions.MultipleMonsterAdditionException;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;

public class Player implements Duelist {
	private String name;
	private int lifePoints;
	private Field field;
	private boolean MonsterSummon;
	public Player(String name) throws IOException, UnexpectedFormatException{
		this.name=name;
		lifePoints = 8000;
		field = new Field();
		MonsterSummon = false;
		this.field.setDeck(new Deck());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLifePoints() {
		return lifePoints;
	}
	
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	public void winning(){
		if(Card.getBoard().getActivePlayer().getLifePoints() <= 0 || Card.getBoard().getActivePlayer().getField().getDeck().getDeck().size() == 0){
			Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
		}else{
			if(Card.getBoard().getOpponentPlayer().getLifePoints() <= 0 || Card.getBoard().getOpponentPlayer().getField().getDeck().getDeck().size() == 0){
				Card.getBoard().setWinner(Card.getBoard().getActivePlayer());
			}
		}
	}
	
	@Override
	public boolean summonMonster(MonsterCard monster) {
		if(Card.getBoard().getWinner() == null){
			if (this.getField().getMonstersArea().size() >= 5)
			{
				throw new NoMonsterSpaceException();
			}
			if (!(this.getField().getPhase().equals(Phase.MAIN1) || this.getField().getPhase().equals(Phase.MAIN2)))
			{
				throw new WrongPhaseException();
			}
			if (MonsterSummon)
			{
				throw new MultipleMonsterAdditionException();
			}
			if(this.equals(Card.getBoard().getActivePlayer()) && this.getField().getHand().contains(monster)){
				this.getField().addMonsterToField(monster, Mode.ATTACK, false);
				this.MonsterSummon = true;
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean summonMonster(MonsterCard monster, ArrayList<MonsterCard> sacrifices) {
		if(Card.getBoard().getWinner() == null){
			if (this.getField().getMonstersArea().size() >= 5)
			{
				throw new NoMonsterSpaceException();
			}
			if (!(this.getField().getPhase().equals(Phase.MAIN1) || this.getField().getPhase().equals(Phase.MAIN2)))
			{
				throw new WrongPhaseException();
			}
			if (MonsterSummon)
			{
				throw new MultipleMonsterAdditionException();
			}
			if(this.equals(Card.getBoard().getActivePlayer()) && this.getField().getHand().contains(monster)){
				monster.setHidden(false);
				this.getField().addMonsterToField(monster, Mode.ATTACK, sacrifices);
				this.MonsterSummon = true;
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean setMonster(MonsterCard monster) {
		if(Card.getBoard().getWinner() == null){
			if (this.getField().getMonstersArea().size() >= 5)
			{
				throw new NoMonsterSpaceException();
			}
			if (!(this.getField().getPhase().equals(Phase.MAIN1) || this.getField().getPhase().equals(Phase.MAIN2)))
			{
				throw new WrongPhaseException();
			}
			if (MonsterSummon)
			{
				throw new MultipleMonsterAdditionException();
			}
			if(this.equals(Card.getBoard().getActivePlayer()) && this.getField().getHand().contains(monster)){
				this.getField().addMonsterToField(monster, Mode.DEFENSE, true);
				
				this.MonsterSummon = true;
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean setMonster(MonsterCard monster, ArrayList<MonsterCard> sacrifices) {
		if(Card.getBoard().getWinner() == null){
			if (this.getField().getMonstersArea().size() >= 5)
			{
				throw new NoMonsterSpaceException();
			}
			if (!(this.getField().getPhase().equals(Phase.MAIN1) || this.getField().getPhase().equals(Phase.MAIN2)))
			{
				throw new WrongPhaseException();
			}
			if (MonsterSummon)
			{
				throw new MultipleMonsterAdditionException();
			}
			if(this.equals(Card.getBoard().getActivePlayer()) && this.getField().getHand().contains(monster)){
				this.getField().addMonsterToField(monster, Mode.DEFENSE, sacrifices);
				monster.setHidden(true);
				this.MonsterSummon = true;
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean setSpell(SpellCard spell) {
		if(Card.getBoard().getWinner() == null){
			if (this.getField().getSpellArea().size() >= 5)
			{
				throw new NoSpellSpaceException();
			}
			if (this.getField().getPhase().equals(Phase.BATTLE))
			{
				throw new WrongPhaseException();
			}
			if(this.equals(Card.getBoard().getActivePlayer()) && this.getField().getHand().contains(spell)){
				this.getField().addSpellToField(spell, null, true);
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean activateSpell(SpellCard spell, MonsterCard monster) {
		if(Card.getBoard().getWinner() == null){
			if (Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE))
			{
				throw new WrongPhaseException();
			}
			if(this.equals(Card.getBoard().getActivePlayer())){
				if(Card.getBoard().getActivePlayer().getField().getSpellArea().contains(spell)){
					this.getField().activateSetSpell(spell, monster);
				}else{
					Card.getBoard().getActivePlayer().setSpell(spell);
					spell.setHidden(false);
					Card.getBoard().getActivePlayer().getField().getHand().remove(spell);
					this.getField().activateSetSpell(spell, monster);
				}
			}
		}
		return false;
	}
	@Override
	public boolean declareAttack(MonsterCard activeMonster, MonsterCard opponentMonster) {
		if(Card.getBoard().getWinner() == null ){
			if (!Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE))
			{
				throw new WrongPhaseException();
			}
			if (this.equals(Card.getBoard().getActivePlayer()) && activeMonster.getMonsterAttack() != 0)
			{
				throw new MonsterMultipleAttackException();
			}
			if (activeMonster.getMode() == Mode.DEFENSE)
			{
				throw new DefenseMonsterAttackException();
			}
			if(this.equals(Card.getBoard().getActivePlayer()) && activeMonster.getMonsterAttack() == 0){
				if(Card.getBoard().getActivePlayer().getField().getMonstersArea().contains(activeMonster) && Card.getBoard().getOpponentPlayer().getField().getMonstersArea().contains(opponentMonster)){
					activeMonster.action(opponentMonster);
					activeMonster.setMonsterAttack(1);
					this.winning();
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public boolean declareAttack(MonsterCard activeMonster) {
		Player p = Card.getBoard().getWinner();
		if(Card.getBoard().getWinner() == null){
			if (!this.getField().getPhase().equals(Phase.BATTLE))
			{
				throw new WrongPhaseException();
			}
			if (this.equals(Card.getBoard().getActivePlayer()) && activeMonster.getMonsterAttack() != 0)
			{
				throw new MonsterMultipleAttackException();
			}
			if (activeMonster.getMode() == Mode.DEFENSE)
			{
				throw new DefenseMonsterAttackException();
			}
			if(this.equals(Card.getBoard().getActivePlayer()) && activeMonster.getMonsterAttack() == 0){
				if(Card.getBoard().getActivePlayer().getField().getMonstersArea().contains(activeMonster) && Card.getBoard().getOpponentPlayer().getField().getMonstersArea().isEmpty()){
					activeMonster.action();
					activeMonster.setMonsterAttack(1);
					this.winning();
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public void addCardToHand() {
		if(Card.getBoard().getWinner() == null){
			if (!(this.getField().getPhase().equals(Phase.MAIN1) || this.getField().getPhase().equals(Phase.MAIN2)))
			{
				throw new WrongPhaseException();
			}
			if(!this.getField().getDeck().getDeck().isEmpty()){
				this.getField().addCardToHand();
			}else{
				Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
			}
		}
		
	}
	@Override
	public void addNCardsToHand(int n) {
		if(Card.getBoard().getWinner() == null){
			if (!(this.getField().getPhase().equals(Phase.MAIN1) || this.getField().getPhase().equals(Phase.MAIN2)))
			{
				throw new WrongPhaseException();
			}
			if(this.getField().getDeck().getDeck().size() > n){
				this.getField().addNCardsToHand(n);;
			}else{
				Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
			}
		}
		
	}
	@Override
	public void endPhase() {
		if(Card.getBoard().getWinner() == null){
			if(this.equals(Card.getBoard().getActivePlayer())){
				if(this.getField().getPhase().equals(Phase.MAIN1)){
					this.getField().setPhase(Phase.BATTLE);
				}else{
					if(this.getField().getPhase().equals(Phase.BATTLE)){
						this.getField().setPhase(Phase.MAIN2);
					}else{
						if(this.getField().getPhase().equals(Phase.MAIN2)){
							this.endTurn();
						}
					}
				}
			}
		}
		
	}
	@Override
	public boolean endTurn() {
		if(Card.getBoard().getWinner() == null){
			if(this.equals(Card.getBoard().getActivePlayer())){
				for(int i = 0 ; i < this.getField().getMonstersArea().size() ; i++){
					this.getField().getMonstersArea().get(i).setMonsterAttack(0);
					this.getField().getMonstersArea().get(i).setMonsterMode(0);
				}
				this.MonsterSummon = false;
				this.getField().setPhase(Phase.MAIN1);
				Card.getBoard().nextPlayer();
			}
		}
		return false;
	}
	@Override
	public boolean switchMonsterMode(MonsterCard monster) {
		if(Card.getBoard().getWinner() == null){
			if (Card.getBoard().getActivePlayer().getField().getPhase().equals(Phase.BATTLE))
			{
				throw new WrongPhaseException();
			}
			if(this.equals(Card.getBoard().getActivePlayer()) && this.getField().getMonstersArea().contains(monster) && monster.getMonsterMode() == 0){
				if(monster.getMode().equals(Mode.ATTACK)){
					monster.setMode(Mode.DEFENSE);
					monster.setMonsterMode(1);
					return true;
				}else{
					monster.setMode(Mode.ATTACK);
					monster.setMonsterMode(1);
					return true;
				}
			}
		}
		return false;
	}
	
	

}
