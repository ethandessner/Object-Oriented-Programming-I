package poker;

public class Deck {

	private Card[] cards;

	public Deck() {
		/*
		 * An array of type Card is set to have 52 indices to fit all 52 cards.
		 * The deck is created by suit, going from ace to king. The suits are
		 * changed every 13 cards to make sure all 4 suits are placed properly.
		 */
		cards = new Card[52];
		for(int i = 1; i <= 52; i++) {
			if(i <= 13)
				cards[i-1] = new Card(i, 0);
			else if(i >= 14 && i <= 26)
				cards[i-1] = new Card(i - 13,1);
			else if(i >= 27 && i <= 39)
				cards[i-1] = new Card(i - 26,2);
			else if(i >= 40 && i <= 52)
				cards[i-1] = new Card(i - 39,3);
		}
	}

	public Deck(Deck other) {
		/*
		 * An object of the Deck class is used to make a copy of the card array.
		 * The length of the cards array is set to the variable copyLength and
		 * is used as a parameter so the values from the cards array can be 
		 * filled into the copy array "other.cards".
		 */
		cards = new Card[other.cards.length];
		int copyLength = cards.length;
		for(int i = 0; i < copyLength; i++) {
			cards[i] = other.cards[i];
		}
	}

	public Card getCardAt(int position) {
		/*
		 * This returns the value of a card at the index "position". The
		 * posiiton parameter uses base 0 indexing so it will never go out of
		 * bounds.
		 */
		return cards[position];
	}

	public int getNumCards() {
		/*
		 * This returns the amount of cards in the cards array by returning
		 * the length of the cards array
		 */
		return cards.length;
	}

	public void shuffle() {
		/*
		 * The values in the top half and the bottom half of the cards array
		 * are set to two different arrays. The array topHalf has the top half
		 * of the elements in the cards array and the bottomHalf array has the
		 * the values in the bottom half of the cards array. If there is an odd
		 * amount of cards the topHalf is given one more index to account for
		 * the rounding down when an it is divided by two. The topHalf and
		 * bottomHalf arrays are loaded into the array shuffleDeck, which has
		 * the same amount of elements as the cards array, with the values of
		 * the topHalf array being copied in for all even indices, and the
		 * bottomHalf array being copied in for all odd indices. The cards
		 * variable is then aliased to the shuffleDeck array.
		 */
		int numOfElements = cards.length;
		int topNum;
		int bottomNum;
		if(numOfElements % 2 == 0) {
			topNum = cards.length/2;
			bottomNum = cards.length/2;
		}else {
			topNum = (cards.length/2) + 1;
			bottomNum = (cards.length/2);
		}
		Card[] topHalf = new Card[topNum];
		Card[] bottomHalf = new Card[bottomNum];
		Card[] shuffleDeck = new Card[numOfElements];
		for(int i = 0; i < topHalf.length; i++) {
			topHalf[i] = cards[i];
		}
		int a = 0;
		for(int i = topHalf.length; i <= numOfElements - 1; i++) {
			bottomHalf[a] = cards[i];
			a++;
		}
		int x = 0;
		int y = 0;
		for(int i = 0; i < numOfElements; i++) {
			if(i % 2 == 0) {
				shuffleDeck[i] = topHalf[x];
				x++;
			}else {
				shuffleDeck[i] = bottomHalf[y];
				y++;
			}
		}
		cards = shuffleDeck;
	}

	public void cut(int position) {
		/*
		 * Two arrays are made when the user clicks on a card in the GUI. All
		 * cards that are before the clicked card are copied into an array
		 * called topHalf, and all cards, including the one clicked, are put
		 * into another array called bottomHalf. An array called cutDeck is made
		 * and has the same amount of elements as the cards array. The cutDeck
		 * array is filled with the elements of the bottomHalf array first, then
		 * the elements of the topHalf. The cards variable is then aliased to 
		 * the cutDeck array.
		 */
		int numOfElements = cards.length;
		Card[] topHalf = new Card[position];
		Card[] bottomHalf = new Card[cards.length - position];
		Card[] cutDeck = new Card[numOfElements];
		for(int i = 0; i < topHalf.length; i++) {
			topHalf[i] = cards[i];
		}
		for(int i = position; i < cards.length; i++) {
			bottomHalf[i - position] = cards[i];	
		}
		for(int i = 0; i < bottomHalf.length; i++) {
			cutDeck[i] = bottomHalf[i];
		}
		for(int i = bottomHalf.length; i < cards.length; i++) {
			cutDeck[i] = topHalf[i - bottomHalf.length];
		}
		cards = cutDeck;
	}

	public Card[] deal(int numCards) {
		/*
		 * The array topHalf is set to the amount of cards that will be dealt.
		 * The array bottomHalf is set to the amount of cards that will be
		 * leftover once numCards are dealt. the cards variable is aliased to 
		 * the bottomHalf array, and topHalf is returned.
		 */
	//	int numOfElements = cards.length;
		Card[] topHalf = new Card[numCards];
		Card[] bottomHalf = new Card[cards.length - numCards];
	//	Card[] cutDeck = new Card[numOfElements];
		for(int i = 0; i < topHalf.length; i++) {
			topHalf[i] = cards[i];
		}
		for(int i = numCards; i < cards.length; i++) {
			bottomHalf[i - numCards] = cards[i];	
		}
		cards = bottomHalf;
		return topHalf;
	}

}
