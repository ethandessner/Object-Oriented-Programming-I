package poker;
public class PokerHandEvaluator {
	
	public static boolean hasPair(Card[] cards) {
		/*
		 * Compares each card in the array with the other cards, but never
		 * compares a card with itself since that is not an actual pair.
		 * Once a pair is found, true is returned. If a pair is never found,
		 * the method returns false.
		 */
		for(int x = 0; x < 5; x++) {
			for(int y = 0; y < 5; y++) {
				if(cards[x].getValue() == cards[y].getValue() && x != y) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean hasTwoPair(Card[] cards) {
		/*
		 * The first set of for loops has the same logic as the hasPair method.
		 * Once the first pair is found, the value of that pair is stored into
		 * the variable firstPair. This makes sure that when the array of cards
		 * is scanned again, the second pair is not mistaken for the first pair.
		 * In order for this method to work, we need two distinct pairs.
		 * If there is a second pair, the boolean twoPair is set to true. If
		 * twoPair is true and firstPair is set to a card value, then the method
		 * returns true.
		 */
		boolean twoPair = false;
		int firstPair = -1;
		for(int x = 0; x < 5; x++) {
			for(int y = x+1; y < 5; y++) {
				if(cards[x].getValue() == cards[y].getValue() && x != y) {
					firstPair = cards[y].getValue();
				}
			}
		}
		for(int x = 0; x < 5; x++) {
			for(int y = x+1; y < 5; y++) {
				if(cards[x].getValue() == cards[y].getValue() 
						&& cards[x].getValue() != firstPair) {
					twoPair = true;
				}
			}
		}
		if(twoPair == true && firstPair >= 0)
			return true;
		else
			return false;
	}
	
	public static boolean hasThreeOfAKind(Card[] cards) {
		/*
		 * An array that represents all possible cards is implemented and is 
		 * filled with the first for loop. (A,2,3,...,J,Q,K).
		 * The next for loop counts how many of these are in the cards array.
		 * If there are at least three of one type in the array, the method
		 * returns true.
		 */
		int[] allCards = new int[14];
		//accounts for cards 0 - 13 - checks how many are in each
		int pairCheck = 0;
		for(int x = 0; x < 5; x++) {
			allCards[cards[x].getValue()] += 1;
			//counts how many cards of each value there are in the array
		}
		for(int x = 0; x < 14; x++) {
			if(allCards[x] >= 3)
				pairCheck++;
		}
		if(pairCheck == 1)
			return true;
		else
			return false;
	}
	
	public static boolean hasStraight(Card [] cards) {
		/*
		 * First the method checks to see if hasPair, hasTwoPair,
		 * hasThreeOfAKind, and hasFourOfAKind are all false. This ensures that
		 * all the cards in the array are unique. Next the card with the 
		 * smallest value is identified. If it is equal to 1, this means the 
		 * smallest value is an ace. This allows the method to account for the 
		 * special condition of an ace being in the last index of the array.
		 * The next for loop checks to see if the consecutive values of the 
		 * cards in the array are 1 apart. If the array has cards that are
		 * 1 value apart from each other in an ascending order, then the
		 * variable consecutive should be 4. If the ace is on top and the
		 * cards are 1 value apart in a descending order, then the variable
		 * aceTopTrue should be 4. If either one of these conditions are
		 * satisfied, all the cards are unique, then the method returns true.
		 */
		boolean allUnique = false;
		if(hasPair(cards) == false 
				&& hasTwoPair(cards) == false
				&& hasThreeOfAKind(cards) == false 
				&& hasFourOfAKind(cards) == false) {
			allUnique = true;
		}else {
			return false;
		}		
		int minimum = cards[0].getValue();
		for(int i = 0; i < 5; i++) {
			if(cards[i].getValue() < minimum) {
				minimum = cards[i].getValue();
			}
		}
		//checks consecutivity for rest of the array
		int consectutive = 0;
		for(int x = 0; x < 5; x++) {
			if(cards[x].getValue() == minimum + 1)
				consectutive++;
			else if(cards[x].getValue() == minimum + 2)
				consectutive++;
			else if(cards[x].getValue() == minimum + 3)
				consectutive++;
			else if(cards[x].getValue() == minimum + 4)
				consectutive++;	
		}
		//if ace is minimum in the array
		int aceTopTrue = 0;
		if(minimum == 1) {
			for(int x = 0; x < 5; x++) {
				if(cards[x].getValue() == 10)
					aceTopTrue++;
				else if(cards[x].getValue() == 11)
					aceTopTrue++;
				else if(cards[x].getValue() == 12)
					aceTopTrue++;
				else if(cards[x].getValue() == 13)
					aceTopTrue++;	
			}
		}		
		if(allUnique == true && (aceTopTrue == 4 || consectutive == 4))
			return true;
		else
			return false;
	}
	public static boolean hasFlush(Card[] cards) {
		/*
		 * The suits in the array are compared. If they are all the same, then
		 * the variable sameSuit should be 5 and will return true. 
		 * If it is not, then the method will return false.
		 */
		 int suit = cards[0].getSuit(); 
		 int sameSuit = 0; 
		 for(int i = 0; i < 5; i++) { 
		 	if(suit == cards[i].getSuit()) 
		 	   sameSuit++; 
		 } 
		 if(sameSuit == 5) 
			 return true; 
		 else 
		 	 return false;
	}
	
	public static boolean hasFullHouse(Card[] cards) {
		/*
		 * An array containing the numerical values of the cards array are
		 * copied into the array "order". Order is then sorted with its values
		 * ascending. If the first and third elements in the array are the same,
		 * then that means the first three elements are he same. If the last two
		 * elements are the same, and are different from the first three, then
		 * there is three of a kind in the first three elements of the array,
		 * and a pair in the last two elements. This logic is copied for when
		 * there is a pair in the first two elements and a three of a kind
		 * in the last three elements. If either one of these scenarios are
		 * true, then the method returns true. Otherwise, the method returns
		 * false.
		 */
		int[] order = new int[5];
		for(int i  = 0; i < 5; i++) {
			order[i] = cards[i].getValue();
		}
		for(int x = 0; x < 4; x++) {
			if(order[x] > order[x+1]) {
				int current = order[x];
				order[x] = order[x+1];
				order[x+1] = current;
				x = -1; //restarts the loop
			}
		}
		if(order[0] == order[2] && order[3] == order[4] && order[2] != order[3])
			return true;
		else if(order[0] == order[1] && order[2] == order[4] 
				&& order[1] != order[2])
			return true;
		else
			return false;
	}
	
	public static boolean hasFourOfAKind(Card[] cards) {
		/*An array containing the numerical values of the cards array are
		 * copied into the array "order". Order is then sorted with its values
		 * ascending. If the first four elements are the same and the last
		 * element is different, then the method returns true. This logic
		 * is copied if the last four elements are the same and the first
		 * element is different. If one of these two scenarios are true,
		 * then the method returns true. Otherwise, the method returns false.
		 * 
		 */
		int[] order = new int[5];
		for(int i  = 0; i < 5; i++) {
			order[i] = cards[i].getValue();
		}
		for(int x = 0; x < 4; x++) {
			if(order[x] > order[x+1]) {
				int current = order[x];
				order[x] = order[x+1];
				order[x+1] = current;
				x = -1; //restarts the loop
			}
		}
		if(((order[0] != order[1]) && (order[1] == order[4])) || 
			((order[0] == order[3]) && (order[3] != order[4])))
			return true;
		else
			return false;
	}
	
	public static boolean hasStraightFlush(Card[] cards) {
		/*
		 * This method calls the hasStraight and hasFlush methods. If they are
		 * both true, then this method returns true. Otherwise, the method
		 * returns false.
		 */
		if(hasFlush(cards) == true && hasStraight(cards) == true)
			return true;
		else
			return false;
	}
}

