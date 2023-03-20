package foodManagement;

/**
 * A SortedListOfImmutables represents a sorted collection of immutable objects 
 * that implement the Listable interface.  
 * 
 * An array of references to Listable objects is used internally to represent 
 * the list.  
 * 
 * The items in the list are always kept in alphabetical order based on the 
 * names of the items.  When a new item is added into the list, it is inserted 
 * into the correct position so that the list stays ordered alphabetically
 * by name.
 */
public class SortedListOfImmutables {

	/*
	 * STUDENTS:  You may NOT add any other instance variables or
	 * static variables to this class!
	 */
	private Listable[] items;

	/**
	 * This constructor creates an empty list by creating an internal array
	 * of size 0.  (Note that this is NOT the same thing as setting the internal
	 * instance variable to null.) 
	 */
	public SortedListOfImmutables() {
		/*
		 * An empty array for the Listable array "items" is created.
		 */
		items = new Listable[0];
	}

	/**
	 *  Copy constructor.  The current object will become a copy of the
	 *  list that the parameter refers to.  
	 *  
	 *  The copy must be made in such a way that future changes to
	 *  either of these two lists will not affect the other. In other words, 
	 *  after this constructor runs, adding or removing things from one of 
	 *  the lists must not have any effect on the other list.
	 *  
	 *  @param other the list that is to be copied
	 */
	public SortedListOfImmutables(SortedListOfImmutables other) {
		/*
		 * The values from the "items" array in the SortedListOfImmutables 
		 * object "other" are traced into the array "items" in the current
		 * object.
		 */
		items = new Listable[other.getSize()];
		for(int i = 0; i < items.length; i++) {
			items[i] = other.items[i];
		}
	}

	/**
	 * Returns the number of items in the list.
	 * @return number of items in the list
	 */
	public int getSize() {
		/*
		 * returns the size of the "items" array in the current object.
		 */
		return this.items.length;
	}

	/**
	 * Returns a reference to the item in the ith position in the list.  
	 * (Indexing is 0-based, so the first element is element 0).
	 * 
	 * @param i index of item requested
	 * @return reference to the ith item in the list
	 */
	public Listable get(int i) {
		/*
		 * returns the Listable variable in index "i" in the "items" array
		 */
		return this.items[i];
	}

	/**
	 * Adds an item to the list.  This method assumes that the list is already
	 * sorted in alphabetical order based on the names of the items in the list.
	 * 
	 * The new item will be inserted into the list in the appropriate place so
	 * that the list will remain alphabetized by names.
	 * 
	 * In order to accomodate the new item, the internal array must be re-sized 
	 * so that it is one unit larger than it was before the call to this method.
	 *  
	 * @param itemToAdd refers to a Listable item to be added to this list
	 */
	public void add(Listable itemToAdd) {
		/*
		 * An array with a length 1 index greater than the current array
		 * is created. The values from the array of the current object are
		 * traced into the larger array. The itemToAdd variable is then added
		 * to the last index of the larger array. The larger array is then
		 * sorted alphabetically. The current array is then aliased to the
		 * larger array.
		 */
		Listable[] addItem = new Listable[this.items.length + 1];
		for(int i = 0; i < items.length; i++) {
			addItem[i] = items[i];
		}
		addItem[addItem.length - 1] = itemToAdd;
		for(int x = 0; x < addItem.length - 1; x++) {
			for(int y = x + 1; y < addItem.length; y++) {
				if(addItem[x].getName().compareTo(addItem[y].getName()) > 0) {
					Listable place = addItem[x];
					addItem[x] = addItem[y];
					addItem[y] = place;
				}
			}
		}
		this.items = addItem;
	}

	/**
	 * Adds an entire list of items to the current list, maintaining the 
	 * alphabetical ordering of the list by the names of the items.
	 * 
	 * @param listToAdd a list of items that are to be added to the current 
	 * object
	 */
	public void add(SortedListOfImmutables listToAdd) {
		/*
		 * The add() method is called and the Listable variables from 
		 * listToAdd are individually added through the for loop.
		 */
		for(int i = 0; i < listToAdd.getSize(); i++) {
			add(listToAdd.get(i));
		}
	}

	/**
	 * Removes an item from the list.
	 * 
	 * If the list contains the same item that the parameter refers to,
	 * it will be removed from the list.  
	 * 
	 * If the item appears in the list more than once, just one instance will be
	 * removed.
	 * 
	 * If the item does not appear on the list, then this method does nothing.
	 * 
	 * @param itemToRemove refers to the item that is to be removed 
	 * from the list
	 */
	public void remove(Listable itemToRemove) {
		/*
		 * First, the array of the current object is scanned to see if it
		 * contains the required item. If the item is in the array, the index
		 * of the item is stored in the variable "index". An array of 1 index
		 * smaller is created and all values from the current array are traced
		 * into the new array except for the item in the index "index".If the 
		 * array doesn't have the item that is needed to be removed, 
		 * nothing happens.The array of the current object is then aliased to
		 * the smaller array.
		 */
		int index = -1;
		boolean findFirst = false;
		while(findFirst == false) {
			for(int x = 0; x < items.length; x++) {
				if(items[x] == itemToRemove) {
					index = x;
					findFirst = true;
				}
			}
			if(index == -1 && findFirst == false) {
				findFirst = true;
			}
		}
		int counter = 0;
		if(index != -1) {
			Listable[] removedItem = new Listable[items.length - 1];
			for(int a = 0; a < items.length; a++) {
				if(a != index) {
					removedItem[counter] = items[a];
					counter++;
				}
			}
			items = removedItem;
		}
	}

	/**
	 * Removes an entire list of items from the current list.  Any items in the
	 * parameter that appear in the current list are removed; any items in the
	 * parameter that do not appear in the current list are ignored.
	 * 
	 * @param listToRemove list of items that are to be removed from this list
	 */
	public void remove(SortedListOfImmutables listToRemove) {
		/*
		 * The remove() method is called and the Listable variables from 
		 * listToRemove are individually removed through the for loop.
		 */
		for(int i = 0; i < listToRemove.getSize(); i++) {
			remove(listToRemove.get(i));
		}
	}

	/**
	 * Returns the sum of the wholesale costs of all items in the list.
	 * 
	 * @return sum of the wholesale costs of all items in the list
	 */
	public int getWholesaleCost() {
		/*
		 * The wholesale values of each item in the "items" array are added
		 * to the variable "sum". Sum is then returned.
		 */
		int sum = 0;
		for(int i = 0; i < items.length; i++) {
			sum += items[i].getWholesaleCost();
		}
		return sum;
	}

	/**
	 * Returns the sum of the retail values of all items in the list.
	 * 
	 * @return sum of the retail values of all items in the list
	 */
	public int getRetailValue() {
		/*
		 * The retail values of each item in the "items" array are added
		 * to the variable "sum". Sum is then returned.
		 */
		int sum = 0;
		for(int i = 0; i < items.length; i++) {
			sum += items[i].getRetailValue();
		}
		return sum;
	}

	/**
	 * Checks to see if a particular item is in the list.
	 * 
	 * @param itemToFind item to look for
	 * @return true if the item is found in the list, false otherwise
	 */
	public boolean checkAvailability(Listable itemToFind) {
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] == itemToFind)
				return true;
		}
		return false;
	}

	/**
	 * Checks if a list of items is contained in the current list.
	 * If more than one copy of a particular element appear in the 
	 * parameter, then the current list must contain at least that many as well.
	 * 
	 * @param listToCheck list of items that may or may not appear in the
	 * current list
	 * @return true if all items in the parameter are contained in the current 
	 * list. (If more than one copy of a particular element appear in the
	 * parameter, then the current list must contain at least that many as 
	 * well.)
	 */
	public boolean checkAvailability(SortedListOfImmutables listToCheck) {
		/*
		 * First scan listToCheck items array - see how many times the item 
		 * appears in that array - then see if that item is available in the 
		 * current array. If true, scan the current array to see if the item 
		 * appears at least as many times in the current array as it does in 
		 * the listToCheck items array if not, return false. If the current
		 * object array has all of the items in the listToCheck items array,
		 * and they appear in current object array at least as many times as
		 * they do in the listToCheck items array, return true. If not,
		 * return false.
		 */
		int itemCount = 0;
		int itemInObj = 0;
		int itemTotal = 0;
		for(int i = 0; i < listToCheck.items.length; i++) {
			Listable currentItem = listToCheck.items[i];
			itemCount = 0;
			itemInObj = 0;
			if(checkAvailability(currentItem) == true) {
				for(int a = 0; a < listToCheck.items.length; a++) {
					if(currentItem == listToCheck.items[a]) {
						itemCount++;
					}
				}
				for(int b = 0; b < items.length; b++) {
					if(currentItem == items[b])
						itemInObj++;
				}
				if(itemCount <= itemInObj && itemCount != 0)
					itemTotal++;
				else
					return false;

			}else {
				return false;
			}
		}
		if(itemTotal == listToCheck.items.length)
			return true;
		else
			return false;
	}

	/*
	 * We'll give you this one for free.  Do not modify this method or you
	 * will fail our tests!
	 */
	public String toString() {
		String retValue = "[ ";
		for (int i = 0; i < items.length; i++) {
			if (i != 0) {
				retValue += ", ";
			}
			retValue += items[i];
		}
		retValue += " ]";
		return retValue;
	}
}
