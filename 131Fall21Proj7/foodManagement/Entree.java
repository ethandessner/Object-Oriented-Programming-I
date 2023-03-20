package foodManagement;


/**
 * An IMMUTABLE class that represents a list of food and a name.  For example, 
 * a typical entree might be called "Big Bubba Breakfast" and might consist of
 * the list:  2 Egg, 3 Waffle, 1 Bacon, 1 Coffee
 */
public class Entree implements Listable {
	/*
	 * STUDENTS:  You may NOT add any other instance variables or static 
	 * variables!
	 */
	private String name;
	private SortedListOfImmutables foodList;  
	// This list will contain Food objects

	/**
	 * Standard constructor.  To ensure that the Entree class remains immutable,
	 * this constructor will make a copy of the list that foodListIn refers to.
	 * (This is necessary because a SortedListOfImmutables is mutable.)
	 * 
	 * @param nameIn desired name for this Entree
	 * @param foodListIn desired list of Food for this Entree
	 */
	public Entree(String nameIn, SortedListOfImmutables foodListIn) {
		/*
		 * Private variable name is created as a reference copy and is assigned
		 * to the variable nameIn. Private variable foodList is created as a 
		 * reference copy and is assigned to the variable foodListIn.
		 */
		name = new String();
		foodList = new SortedListOfImmutables(foodListIn);
		name = nameIn;
	}

	/**
	 * Getter for name of Entree
	 * 
	 * @return reference to the name of Entree
	 */
	public String getName() {
		/*
		 * Name of the current entree is returned.
		 */
		return this.name;
	}

	/**
	 *  Getter for FoodList for this entree.
	 *  
	 *  @return reference to a copy of the FoodList for this entree
	 */
	public SortedListOfImmutables getFoodList() {
		/*
		 *Reference copy of the foodList for the current entree is returned.
		 */
		return new SortedListOfImmutables(foodList);
	}

	/**
	 * Returns the wholesale cost of the food in this entree
	 * 
	 * @return wholesale cost of the food in this entree
	 */
	public int getWholesaleCost() {
		/*
		 * Wholesale cost of the variable foodList is returned by calling the
		 * getWholesaleCost() method from the SortedListOfImmutables class.
		 */
		return foodList.getWholesaleCost();
	}
	
	/**
	 * Returns the retail value of the food in this entree
	 * 
	 * @return retail value of the food in this entree
	 */
	public int getRetailValue() {
		/*
		 * Retail cost of the variable foodList is returned by calling the
		 * getRetailValue() method from the SortedListOfImmutables class.
		 */
		return foodList.getRetailValue();
	}
	
	/**
	 * Compares the current object to the parameter and returns true if they
	 * have the same name.
	 * 
	 * @param other Entree to be compared to the current object
	 * @return true if the current object and the parameter have the same name, 
	 * false otherwise
	 */
	public boolean equals(Entree other) {
		/*
		 * Boolean nameCheck checks to see if the name of the entree in the
		 * "other" object is equal to the name of the entree in the 
		 * current object. nameCheck is then returned.
		 */
		boolean nameCheck = other.name.equals(this.name);
		return nameCheck;

	}
	
	/* We'll give you this one for free.  Do not modify this method or you will
	 * fail our tests!
	 */
	public String toString() {
		String retValue = "< ";
		for (int i = 0; i < foodList.getSize(); i++) {
			if (i != 0) {
				retValue += ", ";
			}
			retValue += foodList.get(i);
		}
		retValue += " >";
		return retValue;
	}
}
