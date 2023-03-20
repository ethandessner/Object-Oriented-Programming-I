import static org.junit.Assert.*;

import org.junit.Test;


public class PublicTests {

	@Test
	public void testBasicConstructorsAndGetters() {
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble d = new MyDouble(555.729);
		
		ComplexNumber x = new ComplexNumber(a, b);
		assertTrue(x.getReal().compareTo(a) == 0 && 
				   x.getImag().compareTo(b) == 0);
		
		ComplexNumber z = new ComplexNumber(d);
		assertTrue(z.getReal().compareTo(d) == 0 && 
				   z.getImag().compareTo(new MyDouble(0)) == 0);
	}
	
	@Test
	public void testCopyConstructor() {
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(x);
		assertTrue(x != y);     // Check to be sure they are not aliased!
		assertTrue(y.getReal().compareTo(a) == 0 && 
				   y.getImag().compareTo(b) == 0);
	}
	@Test
	public void testAdd() {
		
		MyDouble a = new MyDouble(4.0);
		MyDouble c = new MyDouble(-2.3);
		
		MyDouble b = new MyDouble(-7.0);
		MyDouble d = new MyDouble(6.4);
		
		ComplexNumber cn1 = new ComplexNumber(a,b); //4 - 7i
		ComplexNumber cn2 = new ComplexNumber(c,d); //-2.3 + 6.4i
		ComplexNumber cn3 = new ComplexNumber(b,c); //-7 - 2.3i
		ComplexNumber cn4 = new ComplexNumber(a,d); //4 + 6.4i
		
		ComplexNumber comp1 = cn1.add(cn2); 
		ComplexNumber comp2 = cn1.add(cn3); 
		ComplexNumber comp3 = cn1.add(cn4); 
		ComplexNumber comp4 = cn2.add(cn3); 
		ComplexNumber comp5 = cn2.add(cn4); 
		ComplexNumber comp6 = cn3.add(cn4); 
		
		ComplexNumber compareComp1 = 
				new ComplexNumber(new MyDouble(1.7), new MyDouble(-0.6));
		assertTrue(comp1.compareTo(compareComp1) == 0);
		ComplexNumber compareComp2 = 
				new ComplexNumber(new MyDouble(-3), new MyDouble(-9.3));
		assertTrue(comp2.compareTo(compareComp2) == 0);
		ComplexNumber compareComp3 = 
				new ComplexNumber(new MyDouble(8), new MyDouble(-0.6));
		assertTrue(comp3.compareTo(compareComp3) == 0);
		ComplexNumber compareComp4 = 
				new ComplexNumber(new MyDouble(-9.3), new MyDouble(4.1));
		assertTrue(comp4.compareTo(compareComp4) == 0);
		ComplexNumber compareComp5 = 
				new ComplexNumber(new MyDouble(1.7), new MyDouble(12.8));
		assertTrue(comp5.compareTo(compareComp5) == 0);
		ComplexNumber compareComp6 = 
				new ComplexNumber(new MyDouble(-3), new MyDouble(4.1));
		assertTrue(comp6.compareTo(compareComp6) == 0);
		
	}
	@Test
	public void testSubtract() {
		
		MyDouble a = new MyDouble(4.0);
		MyDouble c = new MyDouble(-2.3);
		
		MyDouble b = new MyDouble(-7.0);
		MyDouble d = new MyDouble(6.4);
	
		ComplexNumber cn1 = new ComplexNumber(a,b); //4 - 7i
		ComplexNumber cn2 = new ComplexNumber(c,d); //-2.3 + 6.4i
		ComplexNumber cn3 = new ComplexNumber(b,c); //-7 - 2.3i
		ComplexNumber cn4 = new ComplexNumber(a,d); //4 + 6.4i
		
		ComplexNumber comp1 = cn1.subtract(cn2); 
		ComplexNumber comp2 = cn1.subtract(cn3); 
		ComplexNumber comp3 = cn1.subtract(cn4); 
		ComplexNumber comp4 = cn2.subtract(cn3); 
		ComplexNumber comp5 = cn2.subtract(cn4); 
		ComplexNumber comp6 = cn3.subtract(cn4); 
		
		ComplexNumber compareComp1 = new ComplexNumber
				(new MyDouble(6.3), new MyDouble(-13.4));
		assertTrue(comp1.compareTo(compareComp1) == 0);
		ComplexNumber compareComp2 = new ComplexNumber
				(new MyDouble(11), new MyDouble(-4.7));
		assertTrue(comp2.compareTo(compareComp2) == 0);
		ComplexNumber compareComp3 = new ComplexNumber
				(new MyDouble(0), new MyDouble(-13.4));
		assertTrue(comp3.compareTo(compareComp3) == 0);
		ComplexNumber compareComp4 = new ComplexNumber
				(new MyDouble(4.7), new MyDouble(8.7));
		assertTrue(comp4.compareTo(compareComp4) == 0);
		ComplexNumber compareComp5 = new ComplexNumber
				(new MyDouble(-6.3), new MyDouble(0));
		assertTrue(comp5.compareTo(compareComp5) == 0);
		ComplexNumber compareComp6 = new ComplexNumber
				(new MyDouble(-11), new MyDouble(-8.7));
		assertTrue(comp6.compareTo(compareComp6) == 0);
	}
	@Test
	public void testMult() {
		
		MyDouble a = new MyDouble(4.0);
		MyDouble c = new MyDouble(-2.3);
		
		MyDouble b = new MyDouble(-7.0);
		MyDouble d = new MyDouble(6.4);
		
		ComplexNumber cn1 = new ComplexNumber(a,b); //4 - 7i
		ComplexNumber cn2 = new ComplexNumber(c,d); //-2.3 + 6.4i
		ComplexNumber cn3 = new ComplexNumber(b,c); //-7 - 2.3i
		ComplexNumber cn4 = new ComplexNumber(a,d); //4 + 6.4i
				
		ComplexNumber comp1 = cn1.multiply(cn2);
		ComplexNumber comp2 = cn1.multiply(cn3); 
		ComplexNumber comp3 = cn1.multiply(cn4); 
		ComplexNumber comp4 = cn2.multiply(cn3); 
		ComplexNumber comp5 = cn2.multiply(cn4); 
		ComplexNumber comp6 = cn3.multiply(cn4); 
		
		ComplexNumber compareComp1 = new ComplexNumber
				(new MyDouble(35.6), new MyDouble(41.7));
		assertTrue(comp1.compareTo(compareComp1) == 0);
		ComplexNumber compareComp2 = new ComplexNumber
				(new MyDouble(-44.1), new MyDouble(39.8));
		assertTrue(comp2.compareTo(compareComp2) == 0);
		ComplexNumber compareComp3 = new ComplexNumber
				(new MyDouble(60.8), new MyDouble(-2.4));
		assertTrue(comp3.compareTo(compareComp3) == 0);
		ComplexNumber compareComp4 = new ComplexNumber
				(new MyDouble(30.82), new MyDouble(-39.51));
		assertTrue(comp4.compareTo(compareComp4) == 0);
		ComplexNumber compareComp5 = new ComplexNumber
				(new MyDouble(-50.16), new MyDouble(10.88));
		assertTrue(comp5.compareTo(compareComp5) == 0);
		ComplexNumber compareComp6 = new ComplexNumber
				(new MyDouble(-13.28), new MyDouble(-54));
		assertTrue(comp6.compareTo(compareComp6) == 0);
	}
	@Test
	public void testDiv() {
	
		MyDouble a = new MyDouble(4.0);
		MyDouble c = new MyDouble(-2.3);
		MyDouble b = new MyDouble(-7.0);
		MyDouble d = new MyDouble(6.4);
		
		ComplexNumber complexDiv1 = new ComplexNumber(a,b);
		ComplexNumber complexDiv2 = new ComplexNumber(c,d);
		ComplexNumber complexDiv3 = new ComplexNumber(b,c);
		ComplexNumber complexDiv4 = new ComplexNumber(a,d);
		
		ComplexNumber divTest1 = complexDiv1.divide(complexDiv2);
		//-1.167567568 - 0.2054054054i
		ComplexNumber divTest2 = complexDiv2.divide(complexDiv3);
		//0.02541900459 - 0.9226376865
		ComplexNumber divTest3 = complexDiv3.divide(complexDiv4);
		//-0.75+0.625i
		
		ComplexNumber checkDiv1 = new ComplexNumber
				(new MyDouble(-1.167567568), new MyDouble(-0.2054054054));
		assertTrue(divTest1.compareTo(checkDiv1) == 0);
		ComplexNumber checkDiv2 = new ComplexNumber
				(new MyDouble(0.02541900459), new MyDouble(-0.9226376865));
		assertTrue(divTest2.compareTo(checkDiv2) == 0);
		ComplexNumber checkDiv3 = new ComplexNumber
				(new MyDouble(-0.75), new MyDouble(0.625));
		assertTrue(divTest3.compareTo(checkDiv3) == 0);
	}
	@Test
	public void testEqComp() {
		
		MyDouble a = new MyDouble(4.0);
		MyDouble c = new MyDouble(-2.3);
		MyDouble b = new MyDouble(-7.0);
		MyDouble d = new MyDouble(6.4);
		
		ComplexNumber eq1 = new ComplexNumber(a,b);
		ComplexNumber eq2 = new ComplexNumber(a,b);
		ComplexNumber eq3 = new ComplexNumber(c,d);
		ComplexNumber eq4 = new ComplexNumber(c,d);
		ComplexNumber eq5 = new ComplexNumber(b,d);
		ComplexNumber eq6 = new ComplexNumber(b,d);
		ComplexNumber eq7 = new ComplexNumber(a,c);
		ComplexNumber eq8 = new ComplexNumber(a,c);
		ComplexNumber eq9 = new ComplexNumber(b,c);
		ComplexNumber eq10 = new ComplexNumber(b,c);
		ComplexNumber eq11 = new ComplexNumber(a,d);
		ComplexNumber eq12 = new ComplexNumber(a,d);
		
		assertTrue(eq1.compareTo(eq2) == 0);
		assertTrue(eq3.compareTo(eq4) == 0);
		assertTrue(eq5.compareTo(eq6) == 0);
		assertTrue(eq7.compareTo(eq8) == 0);
		assertTrue(eq9.compareTo(eq10) == 0);
		assertTrue(eq11.compareTo(eq12) == 0);
		
		assertTrue(eq1.equals(eq2));
		assertTrue(eq3.equals(eq4));
		assertTrue(eq5.equals(eq6));
		assertTrue(eq7.equals(eq8));
		assertTrue(eq9.equals(eq10));
		assertTrue(eq11.equals(eq12));
		
	}
	@Test
	public void testNorm() {
		MyDouble a = new MyDouble(4.0);
		MyDouble c = new MyDouble(-2.3);
		MyDouble b = new MyDouble(-7.0);
		MyDouble d = new MyDouble(6.4);
		
		ComplexNumber cn1 = new ComplexNumber(a,b); //4 - 7i
		ComplexNumber cn2 = new ComplexNumber(c,d); //-2.3 + 6.4i
		ComplexNumber cn3 = new ComplexNumber(b,c); //-7 - 2.3i
		ComplexNumber cn4 = new ComplexNumber(a,d); //4 + 6.4i
		
		MyDouble norm1 = ComplexNumber.norm(cn1);
		ComplexNumber normCheck1 = new ComplexNumber(norm1);
		MyDouble norm2 = ComplexNumber.norm(cn2);
		ComplexNumber normCheck2 = new ComplexNumber(norm2);
		MyDouble norm3 = ComplexNumber.norm(cn3);
		ComplexNumber normCheck3 = new ComplexNumber(norm3);
		MyDouble norm4 = ComplexNumber.norm(cn4);
		ComplexNumber normCheck4 = new ComplexNumber(norm4);
		
		assertTrue(cn1.compareTo(normCheck1) == 0);
		assertTrue(cn2.compareTo(normCheck2) == 0);
		assertTrue(cn3.compareTo(normCheck3) == 0);
		assertTrue(cn4.compareTo(normCheck4) == 0);
	}
	@Test
	public void testParsing() {
		String parseSubject1 = " 9 -2.8i";
		ComplexNumber complexNum1 = 
				ComplexNumber.parseComplexNumber(parseSubject1);
		ComplexNumber complexNum2 = 
				new ComplexNumber(new MyDouble(9), new MyDouble(-2.8));
		assertTrue(complexNum1.compareTo(complexNum2) == 0);
		
		String parseSubject2 = " 9 + 2.8i ";
		ComplexNumber complexNum3 = 
				ComplexNumber.parseComplexNumber(parseSubject2);
		ComplexNumber complexNum4 = 
				new ComplexNumber(new MyDouble(9), new MyDouble(2.8));
		assertTrue(complexNum3.compareTo(complexNum4) == 0);
		
		String parseSubject3 = "   -9    +     2.8    i ";
		ComplexNumber complexNum5 = 
				ComplexNumber.parseComplexNumber(parseSubject3);
		ComplexNumber complexNum6 = 
				new ComplexNumber(new MyDouble(-9), new MyDouble(2.8));
		assertTrue(complexNum5.compareTo(complexNum6) == 0);
		
		String parseSubject4 = "9-     2.8i";
		ComplexNumber complexNum7 = 
				ComplexNumber.parseComplexNumber(parseSubject4);
		ComplexNumber complexNum8 = 
				new ComplexNumber(new MyDouble(9),new MyDouble(-2.8));
		assertTrue(complexNum7.compareTo(complexNum8) == 0);
		
		String parseSubject5 = "  9   -2.8i";
		ComplexNumber complexNum9 = 
				ComplexNumber.parseComplexNumber(parseSubject5);
		ComplexNumber complexNum10 = 
				new ComplexNumber(new MyDouble(9), new MyDouble(-2.8));
		assertTrue(complexNum9.compareTo(complexNum10) == 0);
		
	}
}
