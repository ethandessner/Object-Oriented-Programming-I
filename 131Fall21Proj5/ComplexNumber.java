
public class ComplexNumber {
	
	/* STUDENTS:  You may NOT add any further instance or static variables! */
	private final MyDouble real;   // To be initialized in constructors
	private final MyDouble imag;   // To be initialized in constructors

	public ComplexNumber(MyDouble realComp, MyDouble imagComp) {
		/*
		 * Constructor that gives a ComplexNumber a real value and an
		 * imaginary value.
		 */
		real = realComp;
		imag = imagComp;
	}
	public ComplexNumber(MyDouble realComp) {
		/*
		 * Constructor that gives a ComplexNumber a real value but sets
		 * the imaginary value equal to 0. Set imag to a MyDouble since
		 * that are the parameters of the ComplexNumber constructor
		 */
		real = realComp;
		imag = new MyDouble(0.0);
	}
	public ComplexNumber(ComplexNumber other) {
		/*
		 * Copy constructor for the ComplexNumber constructor
		 * Use an object "other" of type ComplexNumber to create copies.
		 */
		this.real = other.real;
		this.imag = other.imag;
	}

	public MyDouble getReal() {
		/*
		 * Since real is a private variable, we use a getter to return
		 * the value of the variable real.
		 */
		return real;
	}
	public MyDouble getImag() {
		/*
		 * Since imag is a private variable, we use a getter to return
		 * the value of the variable imag.
		 */
		return imag;
	}
	public ComplexNumber add(ComplexNumber addComp) {
		/*
		 * Taking variable real and adding to the real component of the
		 * ComplexNumber addComp.
		 * Use addComp. when accessing variables of the addComp object
		 * Taking imaginary and adding to imaginary component of the
		 * ComplexNumber addComp.
		 * The process of add() is simply adding like terms and then
		 * creating a new ComplexNumber with the calculated realAdd and imagAdd
		 * variables
		 */
		MyDouble realAdd = addComp.getReal().add(this.real);
		MyDouble imagAdd = addComp.getImag().add(this.imag);
		ComplexNumber addComplex = new ComplexNumber(realAdd, imagAdd);
		return addComplex;
	}
	public ComplexNumber subtract(ComplexNumber subComp) {
		/*
		 * Taking variable real and subtracting from the real component of the
		 * ComplexNumber subComp.
		 * Use subComp. when accessing variables of the addComp object
		 * Taking imaginary and subtracting from the imaginary component of the
		 * ComplexNumber subComp.
		 * The process of subtract() is simply subtracting and then
		 * creating a new ComplexNumber with the calculated realSub and imagSub
		 * variables
		 */
		MyDouble a = this.getReal();
		MyDouble bi = this.getImag();
		MyDouble c = subComp.getReal();
		MyDouble di = subComp.getImag();
		MyDouble realSub = a.subtract(c);
		MyDouble imagSub = bi.subtract(di);
		ComplexNumber subComplex = new ComplexNumber(realSub, imagSub);
			return subComplex;
	}
	public ComplexNumber multiply(ComplexNumber multComp) {
		/*
		 * First create a variable called isquared to account for the fact that
		 * when two imaginary numbers are multiplied together, they will create
		 * a variable with i^2 which is equal to -1.
		 * Just like addition and subtraction, combine by like terms.
		 * a (real): Take the real number from the current object and multiply 
		 * by the real number from the multComp object.
		 * b (real): Take the real number from the multComp object and multiply 
		 * by the imaginary number from the current object.
		 * c (imaginary): Take the imaginary number from the multComp object and 
		 * multiply by the imaginary number from the current object. 
		 * Then multiply by -1 to account for the i^2.
		 * d (imaginary) : Take the imaginary number from the multComp object 
		 * and multiply by the real number from the current object.
		 * 
		 * Add together like terms: a and b, and c and d - this creates a
		 * real and imaginary part which will be create a new complex number
		 * multComplex
		 */
		MyDouble isquared = new MyDouble(-1);
		MyDouble realPart = multComp.getReal().multiply(this.real);
		MyDouble realPartCross = multComp.getReal().multiply(this.imag);
		MyDouble imagPart = (multComp.getImag().multiply(this.imag))
				.multiply(isquared);
		MyDouble imagPartCross = multComp.getImag().multiply(this.real);
		ComplexNumber multComplex = new ComplexNumber
				(realPart.add((imagPart)),
						realPartCross.add(imagPartCross));
		return multComplex;
	}
	public ComplexNumber divide(ComplexNumber divideComp) {
		/*
		 * Formula for dividing complex numbers is
		 * (ac + bd)/(c^2+d^2) + (bc - ad)/(c^2+d^2)i
		 * multiply ab and add to bd - divide by c^2+d^2 - this gets you the
		 * real portion of your answer
		 * multiply bc and subtract ad - divide by c^2+d^2 - this gets you the
		 * imaginary portion of your answer
		 * 
		 * declare the real and imaginary parts as parameters in 
		 * ComplexNumber divideComplex
		 */
		MyDouble a = this.getReal();
		MyDouble bi = this.getImag();
		MyDouble c = divideComp.getReal();
		MyDouble di = divideComp.getImag();
		MyDouble cdSquare = (c.multiply(c)).add(di.multiply(di));
		MyDouble realPart = (a.multiply(c).add(bi.multiply(di)))
				.divide(cdSquare);
		MyDouble imagPart = bi.multiply(c).subtract(a.multiply(di))
				.divide(cdSquare);
		ComplexNumber divideComplex = new ComplexNumber(realPart, imagPart);
		return divideComplex;
	}
	public boolean equals(ComplexNumber complexEq) {
		/*
		 * Check to see if real value of current object equals the real value of
		 * the parameter complexEq AND if the imag value of the current object 
		 * equals the imag value of the parameter complexEq.
		 * If true, return true, if not, return false.
		 */
		if(getReal().equals(complexEq.getReal()) && getImag()
				.equals(complexEq.getImag()))
			return true;
		else
			return false;
	}
	public int compareTo(ComplexNumber compareCN) {
		/*
		 * Create new complex number with values from the constructor of the
		 * current object. Make two new MyDoubles with the parameters from the
		 * current object and the parameters from compareCN.
		 * If they are equal, return 0, if the MyDouble made from the current
		 * object is less than that of compareCN, -1 is returned, if the 
		 * MyDouble made from the current object is greater than that of 
		 * compareCN, 1 is returned.
		 * return 5 is included at the end since a return value needs to be
		 * recognized by the method, but 5 will never return. -1, 0, 1 will
		 * always return.
		 */
		ComplexNumber complexNorm = new ComplexNumber(this.getReal(),
				this.getImag());
		MyDouble compNorm1 = norm(complexNorm);
		MyDouble compNorm2 = norm(compareCN);
		int compareComplex = compNorm1.compareTo(compNorm2);
		if(compareComplex == 0)
			return 0;
		else if(compareComplex < 0)
			return -1;
		else if(compareComplex > 0)
			return 1;
		return 5;
	}
	public static MyDouble norm(ComplexNumber normNum) {
		/*
		 * The real value and imaginary values from the object normNum are
		 * squared, added together, and is lastly taken the square root of.
		 * This value is then returned
		 */
		MyDouble aSquared = normNum.getReal().multiply(normNum.getReal());
		MyDouble bSquared = normNum.getImag().multiply(normNum.getImag());
		MyDouble abPlus = aSquared.add(bSquared);
		MyDouble normCalc = abPlus.sqrt();
		return normCalc;
	}
	public String toString() {
		/*
		 * Checks to see if real and imaginary values exist in the current
		 * object
		 * Checks to see if the real and imaginary values are positive or
		 * negative to see if a positive or negative sign needs to be inserted
		 * when the complex number is returned as a string
		 * if else methods account for each scenario, real value being negative
		 * imag value being positive, etc. 
		 */
		int realCheck = this.getReal().compareTo(new MyDouble(0));
		int imagCheck = this.getImag().compareTo(new MyDouble(0));
		if(realCheck > 0 && imagCheck > 0)
			return real.toString() + "+" + imag.toString()+"i";
		else if(realCheck > 0 && imagCheck < 0)
			return real.toString() + imag.toString()+"i";
		else if(realCheck < 0 && imagCheck > 0)
			return real.toString() + "+" + imag.toString()+"i";
		else if(realCheck < 0 && imagCheck < 0)
			return real.toString()+imag.toString()+"i";
		return "";
	}
	public static ComplexNumber parseComplexNumber(String complexString) {
		/*
		 * A new string is made with all of the white space taken out of the
		 * parameter complexString. The boolean "plus" checks to see if the
		 * complex number has components that are being added. The doubles
		 * realPart and imagPart are created to store the values of the
		 * extracted real and imaginary values.
		 * The int iIndex finds where the "i" is in the string, so the program
		 * knows where to cut off the imaginary value and store it into the 
		 * String iString. The real value is stored by starting at the first 
		 * index and stopping right before the plus/minus sign and is stored 
		 * into the String rString. These two strings are then parsed with the
		 * Java method Double.parseDouble and are then stored into their
		 * corresponding doubles. 
		 * Two new MyDoubles, realDouble and imagDouble, are created with the 
		 * values of newly created doubles realPart and imagPart. These
		 * MyDoubles are used to make the complex number 
		 * complexStringDouble and is then returned.
		 */
		String compString = complexString.replaceAll("\\s", "");
		boolean plus = compString.contains("+");
		double realPart;
		double imagPart;
		int iIndex = compString.indexOf("i");
		
		if(plus == true) {
			int plusIndex = compString.indexOf("+");
			String rString = compString.substring(0, plusIndex);
			String iString = compString.substring(plusIndex, iIndex);
			realPart = Double.parseDouble(rString);
			imagPart = Double.parseDouble(iString);
		}else {
			int negIndex = compString.lastIndexOf("-");
			//make sure it is the subtraction sign and not a negation sign
			String rString = compString.substring(0, negIndex);
			String iString = compString.substring(negIndex, iIndex);
			realPart = Double.parseDouble(rString);
			imagPart = Double.parseDouble(iString);
		}
		MyDouble realDouble = new MyDouble(realPart);
		MyDouble imagDouble = new MyDouble(imagPart);
		ComplexNumber complexStringDouble = new ComplexNumber
				(realDouble, imagDouble);
		return complexStringDouble;
	}
}