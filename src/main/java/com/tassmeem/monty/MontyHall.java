package com.tassmeem.monty;

import java.util.Random;
import java.util.Scanner;

/**
 * @author tawfiq
 *
 *         This Class To Simulate and Play with 'Monty Hall Problem'
 * 
 */

public class MontyHall {

	/**
	 * 
	 * This Method will read door number from user and (open not chosen 'Goat
	 * Door') and ask user if he want switch door ? and print result (Win or
	 * Lost)
	 * 
	 */
	public Result playGame(int numberOfDoors) {

		// Get Random Number (Car Door) range between 1 and Number of Doors
		Integer carDoor = getRandomNumber(numberOfDoors);

		System.out.println("Enter Door Number Between (1, " + numberOfDoors + ")");

		// Get door number from scanner
		Integer chosenDoorNumber = getChosenDoorNumber();

		// Check if chosen door number is valid and in the range
		if (chosenDoorNumber <= 0) {

			return new Result(ResultMessage.INVALID_INPUT, false);
		} else if (chosenDoorNumber > numberOfDoors) {

			return new Result(ResultMessage.INPUT_OUT_OF_RANGE, false);
		}

		// Get Other Door
		// If user Choose Car Door return Random Door else return Car Door
		Integer otherDoor = getOtherDoor(carDoor, chosenDoorNumber, numberOfDoors);

		// ask user if he want change chosen door
		System.out.println("Do You Want Change your Door (" + chosenDoorNumber + ") To (" + otherDoor + ") [Y/N]");

		// Check Answer
		boolean changed = isChanged();

		if ((changed && otherDoor == carDoor) || (!changed && chosenDoorNumber == carDoor)) {

			return new Result(ResultMessage.WIN, true);
		}

		return new Result(ResultMessage.LOST, false);

	}

	/**
	 * To Read Door Number from user
	 * 
	 * @return
	 */
	private Integer getChosenDoorNumber() {

		// Read door number
		Scanner inputDoorNumber = new Scanner(System.in);

		// Check if input has integer value and return it
		if (inputDoorNumber.hasNextInt()) {

			int chosenNumber = inputDoorNumber.nextInt();
			
			// close Scanner
			inputDoorNumber.close();
			
			// return chosenNumber
			return chosenNumber;
		}

		// close Scanner
		inputDoorNumber.close();
					
		// if input is not integer return 0
		return 0;
	}

	/**
	 * Return true if user want change door and false if not
	 * 
	 * @return
	 */
	private boolean isChanged() {

		// Read Input
		Scanner input = new Scanner(System.in);

		// Check if has input 'Y'
		if (input.hasNext()) {

			String answer = input.nextLine();
			
			// Close Scanner
			input.close();
			
			// if input is 'Y' return true , but ant other value return false
			if (answer.trim().equalsIgnoreCase("Y")) {
				
				return true;
			}
		}

		return false;
	}

	/**
	 * If the user choose car door this method return random door but if he not
	 * choose car door this method return car door
	 * 
	 * @param carDoor
	 * @param chosenDoor
	 * @param numberOfDoor
	 * @return
	 */
	private Integer getOtherDoor(int carDoor, int chosenDoor, int numberOfDoors) {

		if (carDoor != chosenDoor) {
			return carDoor;
		}

		// get random number
		int otherDoor = getRandomNumber(numberOfDoors - 1);

		// if the random number equal car door then add 1 to get other door
		return otherDoor != carDoor ? otherDoor : otherDoor + 1;
	}

	/**
	 * Generate Random Number
	 * 
	 * @param range
	 * @return
	 */
	private Integer getRandomNumber(int range) {

		Random rand = new Random();
		
		// return random number between (1, range)
		return rand.nextInt(range) + 1;
	}

}
