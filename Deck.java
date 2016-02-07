//Simulates a deck of cards using Card.java, can be used to make games and so on.
import java.util.*;

public class Deck {
	
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck(){
		
		for(int i=1; i<14; i++){
			cards.add(new Card(i,0));
		}
		for(int i=1; i<14; i++){
			cards.add(new Card(i,1));
		}
		for(int i=1; i<14; i++){
			cards.add(new Card(i,2));
		}
		for(int i=1; i<14; i++){
			cards.add(new Card(i,3));
		}
	}
	public int getNumberOfCards(){
		return cards.size();
	}
	public Card getCard(int value, int suit){
		
		for(int i=0; i<cards.size(); i++){
			if(value == cards.get(i).getValue() && suit == cards.get(i).getSuit()){
				return cards.get(i);
			}	
		}
		return null;
	}
	public boolean removeCard(int value, int suit){
		
		if( contains(value, suit) != -1){
			
			cards.remove(contains(value, suit));
			return true;
		}
		
		return false;
	}
	public Card drawCard(){
		Random r = new Random();
		int index = r.nextInt(cards.size() );
		Card card = cards.get(index);
		removeCard( card.getValue(), card.getSuit() );
		return card;
	}
	public int contains(int value, int suit){
	
		for(int i=0; i<cards.size(); i++){
			if(value == cards.get(i).getValue() && suit == cards.get(i).getSuit()){
				return i;
			}
		}
		return -1;
	}
	public String toString(){
		String out ="";
		for(int i=0; i<cards.size(); i++){
			out+=cards.get(i)+"\n";
		}
		return out;
	}
	public static void main(String[]args){
		Deck deck = new Deck();
		/*System.out.println(deck +"\n"+deck.getNumberOfCards());
		System.out.println( deck.getCard(1,1) );
		System.out.println( deck.removeCard(1,1) );
		System.out.println( deck.getCard(1,1) );
		System.out.println( deck.getNumberOfCards());*/
		
		System.out.println( deck.getNumberOfCards() );
		System.out.println( deck.drawCard() );
		System.out.println( deck.getNumberOfCards() );
		System.out.println(  );
		System.out.println( deck );
	}
}
