package eg.edu.guc.yugioh.board;

import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.board.player.Deck;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;

public class Board {
	private  Player activePlayer;
	private  Player opponentPlayer;
	private  Player winner = null;
	public Board(){
		Card.setBoard(this);
	}
	public void whoStarts(Player p1, Player p2) {
		double x = Math.random();
		double y = Math.random();
		if(x>y){
			setActivePlayer(p1);
			setOpponentPlayer(p2);
		}else{
			setActivePlayer(p2);
			setOpponentPlayer(p1);
		}
		
	}
	
	public void startGame(Player p1, Player p2) throws IOException{
		whoStarts( p1, p2);
		getActivePlayer().getField().addNCardsToHand(5);
		getOpponentPlayer().getField().addNCardsToHand(5);
		Card.getBoard().getActivePlayer().setName(p1.getName());
		Card.getBoard().getOpponentPlayer().setName(p2.getName());
		getActivePlayer().getField().addCardToHand();
	}
	
	public void nextPlayer(){
		Player PlayerTMP = getActivePlayer();
		setActivePlayer(getOpponentPlayer());
		setOpponentPlayer(PlayerTMP);
		getActivePlayer().addCardToHand();
	}
	
	public  Player getActivePlayer() {
		return activePlayer;
	}
	public  void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}
	public  Player getOpponentPlayer() {
		return opponentPlayer;
	}
	public  void setOpponentPlayer(Player opponentPlayer) {
		this.opponentPlayer = opponentPlayer;
	}
	public  Player getWinner() {
		return winner;
	}
	public  void setWinner(Player winner) {
		this.winner = winner;
	}
	
	
}
