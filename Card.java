//Simulates a playing-card

public class Card {
	
	private int value;
	private int suit;
	
	public static final int SPADES = 0;
	public static final int CLUBS = 1;
	public static final int HEARTHS = 2;
	public static final int DIAMONDS = 3;
	
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	public static final int ACE = 1;
	
	public Card(int value, int suit){
	
		this.value = value;
		this.suit = suit;
	}
	public int getValue(){
		return value;
	}
	public int getSuit(){
		return suit;
	}
	public int compareValue(Card card){
		
		return value-card.getValue(); //positiv hvis this er størst, 0 hvis like, negativ hvis card er størst
	}
	public boolean compareSuit(Card card){
		if(suit == card.getSuit() ){
			return true;
		}
		return false;
	}
	@Override
	public String toString(){
		String nominal = Integer.toString(value);
		switch(value){
			case JACK:
				nominal = "Jack of ";
				break;
			case QUEEN:
				nominal = "Queen of ";
				break;
			case KING:
				nominal = "King of ";
				break;
			case ACE:
				nominal = "Ace of ";
				break;
			default:
				nominal += " of ";
		}
		switch(suit){
			case SPADES:
				nominal += "Spades";
				break;
			case CLUBS:
				nominal += "Clubs";
				break;
			case HEARTHS:
				nominal += "Hearts";
				break;
			case DIAMONDS:
				nominal += "Diamonds";
				break;
			default:
				return "Not a Card";
		}
		return nominal;
	}
	
	public static void main(String[]args){
		
		Card card = new Card(1, 1);
		Card card1 = new Card(13, 1);
		
		System.out.println(card +"\n"+ card1+"\n"+card.compareValue(card1)+"\n"+card.compareSuit(card1));
	}
}
