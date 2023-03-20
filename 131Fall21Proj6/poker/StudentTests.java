package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {

	/* Use the @Test annotation for JUnit 4 
	 * [This is just an example, please erase
	 * it and write some real tests.]    */
	@Test
	public void test() {
		Card card1 = new Card(2,3);
		Card card2 = new Card(2,0);
		Card card3 = new Card(2,1);
		Card card4 = new Card(2,2);
		Card card5 = new Card(9,0);
		
		Card[] testCards = {card1, card2, card3, card4, card5};
		
		assertTrue(PokerHandEvaluator.hasPair(testCards));
		assertFalse(PokerHandEvaluator.hasTwoPair(testCards));
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(testCards));
		assertFalse(PokerHandEvaluator.hasStraight(testCards));
		assertFalse(PokerHandEvaluator.hasFlush(testCards));
		assertFalse(PokerHandEvaluator.hasFullHouse(testCards));
		assertTrue(PokerHandEvaluator.hasFourOfAKind(testCards));
		assertFalse(PokerHandEvaluator.hasStraightFlush(testCards));
	}
	@Test
	public void test2() {
		Card card1 = new Card(1,3);
		Card card2 = new Card(1,0);
		Card card3 = new Card(1,1);
		Card card4 = new Card(11,0);
		Card card5 = new Card(11,3);
		
		Card[] testCards = {card1, card2, card3, card4, card5};
		
		assertTrue(PokerHandEvaluator.hasPair(testCards));
		assertTrue(PokerHandEvaluator.hasTwoPair(testCards));
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(testCards));
		assertFalse(PokerHandEvaluator.hasStraight(testCards));
		assertFalse(PokerHandEvaluator.hasFlush(testCards));
		assertTrue(PokerHandEvaluator.hasFullHouse(testCards));
		assertFalse(PokerHandEvaluator.hasFourOfAKind(testCards));
		assertFalse(PokerHandEvaluator.hasStraightFlush(testCards));
	}
}
