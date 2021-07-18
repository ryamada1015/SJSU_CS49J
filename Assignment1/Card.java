package edu.sjsu.assignment1;

public class Card {

	public static void main(String[] args) {
		Card card = new Card("10H");
		String str = card.getDescription();
		System.out.println(str);
	}
	
	private String notation;
	
	public Card(String notation) {
		this.notation = notation;
	}
	
	public String getDescription() {
		String number = null;
		String suit = null;
		char ch = notation.charAt(0);
		
		if(notation.length() == 2) {
			if(Character.isDigit(ch)) {
				switch(ch) {
				case '2': number = "Two";
				break;
				case '3': number = "Three";
				break;
				case '4': number = "Four";
				break;
				case '5': number = "Five";
				break;
				case '6': number = "Six";
				break;
				case '7': number = "Seven";
				break;
				case '8': number = "Eight";
				break;
				case '9': number = "Nine";
				break;
				}
			}
			else if(!Character.isDigit(ch)) {
				switch(ch) {
				case 'A': number = "Ace";
				break;
				case 'J': number = "Jack";
				break;
				case 'Q': number = "Queen";
				break;
				case 'K': number = "King";
				break;
				}
			}
			else {
				return "Unknown";
			}
			char ch2 = notation.charAt(1);
			switch(ch2) {
			case 'S': suit = "Spades";
			break;
			case 'C': suit = "Clubs";
			break;
			case 'H': suit = "Hearts";
			break;
			case 'D': suit = "Diamonds";
			break;
			}
		}
		else if(notation.length() == 3) {
			if(notation.charAt(0) == '1' && notation.charAt(1) == '0') {
				number = "Ten";
			}
			else {
				return "Unknown";
			}
			
			char ch3 = notation.charAt(2);
			switch(ch3) {
			case 'S': suit = "Spades";
			break;
			case 'C': suit = "Clubs";
			break;
			case 'H': suit = "Hearts";
			break;
			case 'D': suit = "Diamonds";
			break;
			}
		}
		else {
			return "Unknown";
		}
		
		return (number + " of " + suit);
	}

}
