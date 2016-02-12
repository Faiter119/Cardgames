import static javax.swing.JOptionPane.*;

import java.io.*;
import java.util.ArrayList;

public class Blackjack {
	
	private static int aceConvert(ArrayList<Card> cards){
		int sum = 0;
		
		for(int i=0; i<cards.size(); i++){
			if(cards.get(i).getValue() == 11){
				cards.get(i).setValue(1);
			}
			sum+=cards.get(i).getValue();
		}
		return sum;
	}
	private static int sum(ArrayList<Card> cards){
		int out = 0;
		for(int i=0; i<cards.size(); i++){
			out+= cards.get(i).getValue();
		}
		return out;
	}
	public static void main(String[]args) throws Exception{
		
		boolean spill = true;
		BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt",true));
		
		while(spill){
		
			Deck_Blackjack deck = new Deck_Blackjack();
			
			ArrayList<Card> spiller = new ArrayList<Card>();
				spiller.add(deck.drawCard());
				spiller.add(deck.drawCard());
				int pSum = sum(spiller);
				if(pSum > 21){
					pSum = aceConvert(spiller);
				}
			ArrayList<Card> dealer = new ArrayList<Card>();
				dealer.add(deck.drawCard());
				dealer.add(deck.drawCard());
				int dSum = sum(dealer);
										
			String[] valgene = {"Hit me","Stand"};
			
			showMessageDialog(null, "You have: "+spiller.get(0)+", "+spiller.get(1));
			
			boolean go = true;
			while(go && pSum < 21 ){
				
				int valg = showOptionDialog(null,"Dealer has: Hidden card, "+dealer.get(1) ,"Your sum: "+pSum, YES_NO_CANCEL_OPTION,INFORMATION_MESSAGE, null, valgene,null);
				
				switch(valg){
					case 0:
						spiller.add(deck.drawCard());
						pSum = sum(spiller);
						
						if(pSum > 21){
							pSum = aceConvert(spiller);
						}
						showMessageDialog(null,"You draw: "+spiller.get(spiller.size()-1) +" - Sum: "+pSum );
						break;
					case 1:
						go = false;
						break;
				}
			}
			if(pSum <= 21){
				showMessageDialog(null, "Dealer has: "+dealer.get(0)+" and "+dealer.get(1));
				if(sum(dealer) > 21 ){
					dSum = aceConvert(dealer);
				}
				while(dSum < 17){
					dealer.add(deck.drawCard());
					dSum = sum(dealer);
					if(dSum > 21){	
						dSum = aceConvert(dealer);
					}
					showMessageDialog(null, "Dealer draws: "+dealer.get(dealer.size()-1)+" - Sum: "+dSum);
				}
			}
			System.out.println("\nSpiller");
			writer.write("Player: \n");
			for(int i=0; i<spiller.size(); i++ ){
				writer.write(spiller.get(i).toString()+" \n");
				System.out.println(spiller.get(i));
			}
			System.out.println("\nDealer");
			writer.write("Dealer: \n");
			for(int i=0; i<dealer.size(); i++ ){
				writer.write(dealer.get(i).toString()+" \n");
				System.out.println(dealer.get(i));
			}
			System.out.println("\nDealer har "+dSum+" - Du har "+pSum);
			writer.write("Dealer: "+dSum+" - Player: "+pSum);
			writer.newLine();
			
			if(pSum > 21){
				showMessageDialog(null, "You break with "+pSum+" and lose.");
			}
			else if(pSum > dSum || pSum <=21 && dSum >21){
				showMessageDialog(null, "You win with "+pSum+" point, against the dealers "+dSum+" points!");
			}
			else if(pSum == dSum){
				showMessageDialog(null,"Both of you have "+pSum+" points. Noone won.");	
			}
			else if(pSum < dSum && dSum <= 21 && pSum <=21){
				showMessageDialog(null, "You lose with "+pSum+" points, against the dealers "+dSum+" points :(");
			}
			int valg = showOptionDialog(null,"Play Again?","Play Again?",YES_NO_OPTION,QUESTION_MESSAGE,null,null,null);
			if(valg == 1){
				spill = false;
			}
		}
		writer.newLine();
		writer.write("---------------");
		writer.newLine();

		writer.close();
	}
}
