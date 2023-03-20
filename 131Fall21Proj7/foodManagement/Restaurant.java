package foodManagement;

/**
 *  The Restaurant has a name (String), a menu (list of Entrees), an inventory
 *  (list of Food), and an amount of cash on hand, measured in pennies (int)
 * 
 *  This class facilitates orders being placed, deliveries being made to the
 *  inventory, and entrees being added to the menu.
 */
public class Restaurant {

	/*
	 * STUDENTS:  YOU MAY NOT ADD ANY OTHER INSTANCE VARIABLES OR 
	 * STATIC VARIABLES TO THIS CLASS!
	 */
	private String name;
	private SortedListOfImmutables menu;       // A list of Entree objects	
	private SortedListOfImmutables inventory;  // A list of Food objects
	private int cash;

	/**
	 * Standard constructor.  The menu and the inventory are both initialized as 
	 * empty lists.  The name and cash amount are set to match the paramters.
	 * 
	 * @param nameIn name of the restaurant
	 * @param startingCash cash amount that the restaurant will have, measured
	 * in pennies
	 */
	public Restaurant(String nameIn, int startingCash) {
		/*
		 * Name and cash are set equal to the parameters nameIn and 
		 * startingCash, respectively. Menu and inventory are set to new 
		 * SortedListOfImmutables objects.
		 */
		this.name = nameIn;
		this.cash = startingCash;
		this.menu = new SortedListOfImmutables();
		this.inventory = new SortedListOfImmutables();
	}

	/**
	 * Getter for the name of the restaurant.
	 * 
	 * @return reference to the name of the restaurant
	 */
	public String getName() {
		/*
		 * Name of the current restaurant is returned.
		 */
		return this.name;
	}

	/**
	 * Getter for the menu.
	 * 
	 * @return a reference to a copy of the menu
	 */
	public SortedListOfImmutables getMenu() {
		/*
		 * A reference to a copy of the menu is returned.
		 */
		return new SortedListOfImmutables(menu);
	}

	/**
	 * Adds an entree to the menu.
	 * 
	 * @param entreeToAdd reference to the entree to be added to the menu
	 */
	public void addEntree(Entree entreeToAdd) {
		/*
		 * An entree is added to the menu by calling the add() method from
		 * the SortedListOfImmutables class.
		 */
		menu.add(entreeToAdd);
	}
	
	/**
	 * Getter for the inventory.
	 * 
	 * @return a reference to a copy of the inventory
	 */
	public SortedListOfImmutables getInventory() {
		/*
		 * A reference to a copy of the inventory of the current object is
		 * returned.
		 */
		return new SortedListOfImmutables(inventory);
	}

	/**
	 * Getter for the current amount of cash on hand
	 * 
	 * @return the current amount of cash, measured in pennies
	 */
	public int getCash() {
		/*
		 * The variable cash, representing the amount of cash the restaurant 
		 * currently has, is returned.
		 */
		return this.cash;
	}

	/**
	 * Checks if the Food items contained in the specified Entree are 
	 * actually contained in the restaurant's inventory.
	 * 
	 * @param entree Entree that we are checking against the inventory
	 * @return true if the list of Food items contained in the Entree are
	 * all present in the inventory, false otherwise.
	 */
	public boolean checkIfInInventory(Entree entree) {
		/*
		 * The inventory of the current object is scanned to see if the 
		 * "entree" variable is in it. This is done by returning the value
		 * of the checkAvailibility() method from the SortedListOfImmutables
		 * class.
		 */
		SortedListOfImmutables newItem = 
				new SortedListOfImmutables(entree.getFoodList());
		return inventory.checkAvailability(newItem);
	}

	/**
	 * Adds the specified list of food items to the inventory.  If the 
	 * total wholesale cost of all of the food items combined exceeds 
	 * the amount of cash on hand, then NONE of the food items are added 
	 * to the inventory.  If the amount of cash on hand is sufficient to
	 * pay for the shipment, then the amount of cash on hand is reduced by 
	 * the wholesale cost of the shipment.
	 * 
	 * @param list food items to be added to the inventory
	 * @return true if the food items are added; false if the food items are
	 * not added because their wholesale cost exceeds the current cash
	 * on hand
	 */
	public boolean addShipmentToInventory(SortedListOfImmutables list) {
		/*
		 * The values in "list" variable is added to the current inventory, if
		 * the wholesale value of the list is less than the amount of cash.
		 * If the restaurant can afford it, the wholesale value of the items
		 * in "list" are subtracted from "cash"
		 */
		if(list.getWholesaleCost() > cash) {
			return false;
		}else {
			inventory.add(list);
			cash -= list.getWholesaleCost();
			return true;
		}

	}

	/**
	 * Removes the food items contained in the specified Entree from the 
	 * inventory. If the inventory does not contain all of the items required
	 * for this Entree, then NOTHING is removed from the inventory. If the 
	 * inventory contains all of the required items, then the amount of cash
	 * on hand is INCREASED by the retail value of the Entree.
	 *  
	 * @param entree Entree that has been ordered
	 * @return true if the food items are removed from the inventory; false
	 * if the food items were not removed because one or more required items
	 * were not contained in the inventory
	 */
	public boolean placeOrder(Entree entree) {
		/*
		 * The inventory is checked to see if it contains the required food
		 * items. If true, the retail value of the entree is added to the
		 * amount of cash and the entree is then removed from the inventory.
		 * The method then returns true.
		 * If the required items are not in the inventory, the method returns
		 * false.
		 */
		if(inventory.checkAvailability(entree.getFoodList())) {
			cash += entree.getRetailValue();
			inventory.remove(entree.getFoodList());
			return true;
		}else {
			return false;
		}
	}

}
