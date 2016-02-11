public class Deck_Blackjack extends Deck{
	
	public Deck_Blackjack(){
		super();
		
		for(int i=0; i<cards.size(); i++){
			
			if(cards.get(i).getValue() > 10){
				cards.get(i).setValue(10);
			}
			if(cards.get(i).getValue() == 1){
				cards.get(i).setValue(11);
			}
		}
	}
	
	public static void main(String[]args){
		
		Deck_Blackjack deck = new Deck_Blackjack();
		Card card;
		
		for(int i=0; i<deck.getNumberOfCards(); i++){
			card = deck.getCard(i);
			System.out.println( card + " \t\t- "+card.getValue() );

		}
	}
}
