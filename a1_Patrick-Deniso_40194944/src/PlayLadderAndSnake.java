/*
 * Patrick Deniso (40194944)
 * COMP249
 * Assignment # 1
 * Due Date: 07/02/2022
 */

import java.util.Scanner;

public class PlayLadderAndSnake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playersCount = promptPlayersCount(scanner);
        LadderAndSnake game = new LadderAndSnake(playersCount, scanner);

        scanner.close();
    }

    /**
     * Method that asks the user for the number of players that will play the game.
     * Returns -1 if the user has failed for 4 times to enter a valid input (integer between 1 and 4 inclusive).
     * @return number of players or -1 if the input failed.
     */
    private static int promptPlayersCount(Scanner scanner) {
        System.out.print("Enter the # of players for your game - Number must be between 2 and 4 inclusively: ");
        boolean validInput = false;
        int numberOfPlayers = -1;
        int badAttemptCount = 0;
        while(!validInput){
            if(scanner.hasNextInt()){
                numberOfPlayers = scanner.nextInt();
                if(numberOfPlayers <= 4 && numberOfPlayers >= 2){
                    validInput = true;
                }
            }
            else scanner.next(); // flush scanner

            if(!validInput){
                badAttemptCount++;
                if(badAttemptCount > 3){
                    System.out.println("Bad Attempt " + badAttemptCount + "! you have exhausted all your chances. Program will terminate!");
                    break;
                }
                else{
                    System.out.println("Bad Attempt " + badAttemptCount + " - Invalid # of players. Please enter a # between 2 and 4 inclusively:");
                }
            }
        }

        return numberOfPlayers;
    }
}
