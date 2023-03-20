package fighters;

import framework.BattleField;
import framework.Random131;

public class BasicSoldier {
	public final static int INITIAL_HEALTH = 10;
	/*Amount of damage the soldier can sustain when he first comes to life,
	 *or when he has fully recovered from injuries */
	
	public final static int ARMOR = 20;
	//Defense level (How hard is he to hit?
	
	public final static int STRENGTH = 30;
	//Amount of damage done when successfully striking an enemy
	
	public final static int SKILL = 40;
	//Likelihood of striking an enemy during an attack
	//DO NOT MODIFY THE NUMERICAL VALUES OF THE FOLLOWING 9 VARIABLES:
	
	public final static int UP = 0;
	public final static int RIGHT = 1;
	public final static int DOWN = 2;
	public final static int LEFT = 3;
	public final static int UP_AND_RIGHT = 4;
	public final static int DOWN_AND_RIGHT = 5;
	public final static int DOWN_AND_LEFT = 6;
	public final static int UP_AND_LEFT = 7;
	public final static int NEUTRAL = -1;
	
	/* NOTE FROM FAWZI: You may add final static constants of your own, 
	but you are forbidden from adding static variables that are not final.*/
	public final BattleField grid;
	public int row, col; 
	public int health;
	public final int team;

	//Constructor for initializing soldier data at the start of the program
	public BasicSoldier(BattleField gridIn, int teamIn, int rowIn, int colIn) {
		grid = gridIn;
		health = INITIAL_HEALTH;
		team = teamIn;
		row = rowIn;
		col = colIn;
	}
	public boolean canMove() {
		/*
		 * Method checks soldier's surroundings to see if it can move
		 * Checks for empty spaces since it covers all posibilies of
		 * something being in the way
		 */
		if(grid.get(row + 1, col) == BattleField.EMPTY || 
				grid.get(row - 1, col) == BattleField.EMPTY || 
				grid.get(row, col + 1) == BattleField.EMPTY ||
				grid.get(row, col - 1) == BattleField.EMPTY ) {
			return true;
		}else {
			return false;
		}
	}
	public int numberOfEnemiesRemaining() {
		/* 
		 * Method scans the entire grid and adds 1 to a counter called numRed
		 * and numBlue. If team is blue, number of soldiers on the red team
		 * will be returned and vice versa
		 */
		int numBlue = 0, numRed = 0;
		for(int i = 0; i < grid.getCols(); i++) {
			for(int q = 0; q < grid.getRows(); q++) {
				if(grid.get(i, q) == BattleField.RED_TEAM) {
					numRed++;
				}
				if(grid.get(i, q) == BattleField.BLUE_TEAM) {
					numBlue++;
				}
			}
		}
		if(team == BattleField.RED_TEAM)
			return numBlue;
		else
			return numRed;
	}
	public int getDistance(int destinationRow, int destinationCol) {
		/* 
		 * Distance is calculated by finding the absolute value between a
		 * soldiers x and y coordinate with that of something else on the grid.
		 * destinationRow is the row coordinate of the target
		 * destinationCol is the column coordinate of the target
		 * Absolute value is used to account for target being in a different
		 * direction that could cause the difference between coordinates to be
		 * negative and therefore altering the final distance.
		 */
		int rowDistance = Math.abs(destinationRow - row);
		int colDistance = Math.abs(destinationCol - col);
		return rowDistance + colDistance;
	}
	public int getDirection(int destinationRow, int destinationCol) { 
		/*
		 * Method compares the coordinates of a target with that of the current
		 * soldier.
		 * If there is no target, then NEUTRAL is returned
		 */
		if(destinationCol == col && destinationRow < row)
			return UP;
		else if(destinationCol == col && destinationRow > row)	
			return DOWN;
		else if(destinationRow == row && destinationCol > col)
			return RIGHT;
		else if(destinationRow == row && destinationCol < col)	
			return LEFT;
		else if(destinationRow < row && destinationCol > col)
			return UP_AND_RIGHT;
		else if(destinationRow > row && destinationCol > col)
			return DOWN_AND_RIGHT;
		else if(destinationRow > row && destinationCol < col)
			return DOWN_AND_LEFT;
		else if(destinationRow < row && destinationCol < col)
			return UP_AND_LEFT;
		else
			return NEUTRAL;
	}
	public int getDirectionOfNearestFriend() {
		/*
		 * Method calculates the distance between a soldier and a friendly unit
		 * If a friendly soldier is found to be closer than that of the
		 * previously stored distance, then the variable "smallestDistance" 
		 * is reassigned. "smallestDistance" returns as being the distance of
		 * the closest friendly unit.
		 * 
		 * Dev Notes: execute for loop that goes examines the squares up down 
		 * left and right of the current soldier
		 * the radius method, a parameter for stoppage will be the radius.
		 * Use an if statement every increment to check if the square contains
		 * a friendly unit
		 * Use the getDistance method to calculate how many moves
		 * Use the getDirection method to calculate the combination of distances
		 */
		int smallestDistance = Integer.MAX_VALUE;
		int soldierDistance = 0;
		int soldierDirection = NEUTRAL;
		for(int i = 0; i < grid.getRows(); i++) {
			for(int q = 0; q < grid.getCols(); q++) {
				if(grid.get(i, q) == team && getDistance(i, q) > 0) {
					soldierDistance = getDistance(i,q);
					if(soldierDistance <= smallestDistance) {
						smallestDistance = soldierDistance;
						soldierDirection = getDirection(i, q);
						}
					}
				}
			}
			return soldierDirection;
		}
	public int countNearbyFriends(int radius) {
		int numFriends = -1;
		/* 
		 * numFriends accounts for you not being your own friend so it is set to
		 * -1 for when the scanner goes over the current soldier
		 */
		for(int i = 0; i < grid.getRows(); i++) {
			for(int q = 0; q < grid.getCols(); q++) {
				if(grid.get(i, q) == team && getDistance(i, q) <= radius) 
					numFriends++;	
			}
		}
		return numFriends;
	}
	public int getDirectionOfNearestEnemy(int radius) {
		/*
		 * Method works the same way as the getDirectionOfNearestFriend method,
		 * except the grid is scanned for enemies in a set radius.
		 * To account for the radius, the value for the radius is put in
		 * as a parameter when checking to see if a soldier is an enemy soldier,
		 * then the distance of that enemy unit will be calculated.
		 */
		int smallestDistance = Integer.MAX_VALUE;
		int enemyDistance = 0;
		int enemyDirection = NEUTRAL;
		int enemyTeam = 0;
		if(team == BattleField.BLUE_TEAM) 
			enemyTeam = BattleField.RED_TEAM;
		else if(team == BattleField.RED_TEAM) 
			enemyTeam = BattleField.BLUE_TEAM;
		for(int i = 0; i < grid.getRows(); i++) {
			for(int q = 0; q < grid.getCols(); q++) {
				if(grid.get(i, q) == enemyTeam && getDistance(i, q) <= radius) {
					enemyDistance = getDistance(i,q);
					if(enemyDistance <= smallestDistance) {
						smallestDistance = enemyDistance;
						enemyDirection = getDirection(i, q);
					}
				}
			}
		}
		return enemyDirection;
	}
	public void performMyTurn() {
		/*
		 * This method lets the soldier know what it can do. First the soldier's
		 * surroundings are scanned to see if it can attack. If the soldier is
		 * completely surrounded by enemies, it will attack the unit to the
		 * left. If the soldier is not surrounded, it checks for obstacles and
		 * if there are any out of bounds point adjacent to the soldier. If
		 * there are no obstacles, team mates, or out of bounds points, and 
		 * there is an enemy unit in the tested direction, the soldier may
		 * attack in that direction. If the target soldier cannot attack, then
		 * the canMove method is called to see if the soldier can move. If the
		 * tested direction has no obstacle, soldier, or out of bounds point,
		 * the soldiers coordinates are set to the tested direction.
		 */
		int enemyTeam = 0;
		if(team == BattleField.BLUE_TEAM)
			enemyTeam = BattleField.RED_TEAM;
		else if(team == BattleField.RED_TEAM)
			enemyTeam = BattleField.BLUE_TEAM;
			//ATTACK
			if(grid.get(row + 1, col) == enemyTeam && //down
				grid.get(row, col + 1) == enemyTeam	&& //right
				grid.get(row - 1, col) == enemyTeam && //up
				grid.get(row, col - 1) == enemyTeam) //left
					grid.attack(row, col - 1);
			//ATTACK RIGHT
			if(grid.get(row, col + 1) == enemyTeam && 
				grid.get(row, col + 1) != BattleField.OUT_OF_BOUNDS &&
				grid.get(row, col + 1) != team &&
				grid.get(row, col + 1) != BattleField.OBSTACLE)
					grid.attack(row, col + 1);
			//ATTACK LEFT
			else if(grid.get(row, col - 1) == enemyTeam && 
					grid.get(row, col - 1) != BattleField.OUT_OF_BOUNDS &&
					grid.get(row, col - 1) != team &&
					grid.get(row, col - 1) != BattleField.OBSTACLE)
						grid.attack(row, col - 1);
			//ATTACK DOWN
			else if(grid.get(row + 1, col) == enemyTeam && 
					grid.get(row + 1, col) != BattleField.OUT_OF_BOUNDS &&
					grid.get(row + 1, col) != team &&
					grid.get(row + 1, col) != BattleField.OBSTACLE)
						grid.attack(row + 1, col);
			//ATTACK UP
			else if(grid.get(row - 1, col) == enemyTeam && 
					grid.get(row - 1, col) != BattleField.OUT_OF_BOUNDS &&
					grid.get(row - 1, col) != team &&
					grid.get(row - 1, col) != BattleField.OBSTACLE)
						grid.attack(row - 1, col);
			else if(canMove() == true) {
			//MOVE RIGHT
			if(grid.get(row, col + 1) == BattleField.EMPTY && 
				grid.get(row, col + 1) != BattleField.OUT_OF_BOUNDS &&
				grid.get(row, col + 1) != team &&
				grid.get(row, col + 1) != enemyTeam)
					col++;
			//MOVE LEFT
			else if(grid.get(row, col - 1) == BattleField.EMPTY && 
					grid.get(row, col - 1) != BattleField.OUT_OF_BOUNDS &&
					grid.get(row, col - 1) != team &&
					grid.get(row, col - 1) != enemyTeam)
						col--;
			//MOVE DOWN
			else if(grid.get(row + 1, col) == BattleField.EMPTY && 
					grid.get(row + 1, col) != BattleField.OUT_OF_BOUNDS &&
					grid.get(row + 1, col) != team &&
					grid.get(row + 1, col) != enemyTeam)
						row++;
			//MOVE UP
			else if(grid.get(row - 1, col) == BattleField.EMPTY && 
					grid.get(row - 1, col) != BattleField.OUT_OF_BOUNDS &&
					grid.get(row - 1, col) != team &&
					grid.get(row - 1, col) != enemyTeam)
						row--;
			}		
	}
}	


