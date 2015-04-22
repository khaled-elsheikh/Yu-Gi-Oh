package eg.edu.guc.yugioh.board.player;

import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;

public class Field {
	private Phase phase;
	private ArrayList<MonsterCard> monstersArea;
	private ArrayList<SpellCard> spellArea;
	private Deck deck;
	private ArrayList<Card> hand;
	private ArrayList<Card> graveyard;

	public Field() throws IOException, UnexpectedFormatException {
		this.monstersArea = new ArrayList<MonsterCard>();
		this.spellArea = new ArrayList<SpellCard>();
		this.hand = new ArrayList<Card>();
		this.graveyard = new ArrayList<Card>();
		this.deck = new Deck();
		this.phase = Phase.MAIN1;
	}
	public void addMonsterToField(MonsterCard monster, Mode m, boolean isHidden)
	{
		if (monstersArea.size() < 5) //max size = 5
		{
			monster.setMode(m);
			monster.setHidden(isHidden);
			monstersArea.add(monster);
			monster.setLocation(Location.FIELD);
		}
	}
	
	public void addMonsterToField(MonsterCard monster, Mode mode, ArrayList<MonsterCard> sacrifices)
	{
		if (monstersArea.size() < 5)
		{
			if (sacrifices == null && monster.getLevel() <=4)
			{
				monster.setMode(mode);
				monstersArea.add(monster);
				monster.setLocation(Location.FIELD);
			}
			else
			{
				if (monstersArea.size() < sacrifices.size())
				{
					System.out.print("Not enough monsters available on field.");
				}
				else
				{
						if((monster.getLevel() == 5 && sacrifices.size() == 1) || (monster.getLevel() == 6 && sacrifices.size() == 1) || (monster.getLevel() == 7 && sacrifices.size() == 2) || (monster.getLevel() == 8 && sacrifices.size() == 2)){
							removeMonsterToGraveyard(sacrifices);
							monster.setMode(mode);
							monstersArea.add(monster);
							monster.setLocation(Location.FIELD);
					}
				}
			}
		}
	}
	
	public void removeMonsterToGraveyard(MonsterCard monster)
	{
		if(monstersArea.contains(monster)){
			int x = monstersArea.indexOf(monster);
			monstersArea.get(x).setLocation(Location.GRAVEYARD);
			graveyard.add(monstersArea.get(x));
			monstersArea.remove(x);
		}
	}

	public void removeMonsterToGraveyard(ArrayList<MonsterCard> monsters)
	{
		while(!monsters.isEmpty())
		{
			MonsterCard c = monsters.remove(0);
			removeMonsterToGraveyard(c);
		}
	}
	
	public void addSpellToField(SpellCard action, MonsterCard monster, boolean hidden)
	{
		if (spellArea.size() < 5)
		{
			action.setHidden(hidden);
			spellArea.add(action);
			action.setLocation(Location.FIELD);
			if (hidden == false)
			{
				activateSetSpell(action, monster);
			}
		}
	}
	
	public void activateSetSpell(SpellCard action, MonsterCard monster)
	{
		if (spellArea.contains(action))
		{
			spellArea.get(spellArea.indexOf(action)).setHidden(false);
			action.action(monster);
			removeSpellToGraveyard(action);
		}
		
		
	}
	
	public void removeSpellToGraveyard(SpellCard spell)
	{
		if(spellArea.contains(spell)){
			spellArea.remove(spell);
			graveyard.add(spell);
			System.out.println(graveyard.size());
			spell.setLocation(Location.GRAVEYARD);
		}
	}
	
	public void removeSpellToGraveyard(ArrayList<SpellCard> spells)
	{
		while(!spells.isEmpty())
		{
			SpellCard s = spells.remove(0);
			removeSpellToGraveyard(s);
		}
	}
	
	public void addCardToHand()
	{
		Card c = deck.drawOneCard();
		hand.add(c);
		c.setLocation(Location.HAND);
	}
	
	public void addNCardsToHand(int n)
	{
		if(this.getDeck().getDeck().size()>=n){
		ArrayList<Card> cards = deck.drawNCards(n);
		for (Card c: cards)
		{
			c.setLocation(Location.HAND);
			hand.add(c);
		}
		System.out.println(hand.size());
	}else{
		Card.getBoard().getActivePlayer().winning();
	}
	}
	public Phase getPhase() {
		return phase;
	}
	public void setPhase(Phase phase) {
		this.phase = phase;
	}
	public ArrayList<MonsterCard> getMonstersArea() {
		return monstersArea;
	}
	public void setMonstersArea(ArrayList<MonsterCard> monstersArea) {
		this.monstersArea = monstersArea;
	}
	public ArrayList<SpellCard> getSpellArea() {
		return spellArea;
	}
	public void setSpellArea(ArrayList<SpellCard> spellArea) {
		this.spellArea = spellArea;
	}
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	public ArrayList<Card> getHand() {
		return hand;
	}
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	public ArrayList<Card> getGraveyard() {
		return graveyard;
	}
	public void setGraveyard(ArrayList<Card> graveyard) {
		this.graveyard = graveyard;
	}
}
