import java.util.*;
public class MarylandBaseball {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final String PITCHER = "DEAN";
		final String OUTFIELDER = "ALLEYNE";
		final String INFIELDER1 = "SHAW";
		final String INFIELDER2 = "COSTES";
		final int PITCHERNUMB = 42;
		final int OUTFIELDERNUMB = 11;
		final int INFIELDER1NUMB = 6;
		final int INFIELDER2NUMB = 4;

		System.out.println("Type 1 to enter a number or 2 to enter a name:");
		int trackChoice = input.nextInt();
		if(trackChoice == 1) {
			System.out.println("Enter player number:");
			int numbPlay = input.nextInt();
		if(numbPlay == PITCHERNUMB || numbPlay == OUTFIELDERNUMB || numbPlay == INFIELDER1NUMB || numbPlay == INFIELDER2NUMB) {
			System.out.println("Which player wears number " + numbPlay + " on his jersey?");
			input.nextLine();
			String namePlay = input.nextLine();
			namePlay = namePlay.toUpperCase();
			if(numbPlay == PITCHERNUMB && namePlay.equals(PITCHER)) {
				System.out.println("Correct!");
			}else if(numbPlay == OUTFIELDERNUMB && namePlay.equals(OUTFIELDER)) {
				System.out.println("Correct!");
			}else if(numbPlay == INFIELDER1NUMB && namePlay.equals(INFIELDER1)) {
				System.out.println("Correct!");
			}else if(numbPlay == INFIELDER2NUMB && namePlay.equals(INFIELDER2)) {
				System.out.println("Correct!");
			}
			else {
				System.out.println("Incorrect!");
			}
		}
		else {
			System.out.println("Invalid choice.");
		}
		}else if(trackChoice == 2) {
			System.out.println("Choose a name:");
			input.nextLine();
			String choosePlayer = input.nextLine();
			choosePlayer = choosePlayer.toUpperCase();
			if(choosePlayer.equals(PITCHER) ||choosePlayer.equals(OUTFIELDER) || choosePlayer.equals(INFIELDER1) || choosePlayer.equals(INFIELDER2)) {
				System.out.println("What number does " + choosePlayer +  " wear?");
				int playerNumb = input.nextInt();
				if(playerNumb == PITCHERNUMB && choosePlayer.equals(PITCHER)) {
					System.out.println("Correct!");
				}else if(playerNumb == OUTFIELDERNUMB && choosePlayer.equals(OUTFIELDER)) {
					System.out.println("Correct!");
				}else if(playerNumb == INFIELDER1NUMB && choosePlayer.equals(INFIELDER1)) {
					System.out.println("Correct!");
				}else if(playerNumb == INFIELDER2NUMB && choosePlayer.equals(INFIELDER2)) {
					System.out.println("Correct!");
				}
				else {
					System.out.println("Incorrect!");
				}
			}
			else {
				System.out.println("Invalid choice.");
			}
			}
		else {
			System.out.println("Invalid choice.");
		}
		input.close();
		
	
}
}
		