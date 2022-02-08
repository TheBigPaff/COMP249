/*
 * Patrick Deniso (40194944)
 * COMP249
 * Assignment # 1
 * Due Date: 07/02/2022
 *
 * This program will let 2 to 4 people play Ladder and Snake.
 * The program will handle everything, from the rolling of the dice to the drawing of the board one the console.
 * The program also resolves any dice ties at the beginning when choosing the order of the players.
 *
 * One MAJOR feature of this program is that it randomly generates the board. The board is also customizable, it can be of any size and there can be
 * as many ladders and snakes as wanted.
 */

import java.util.Scanner;

/**
 * The driver class that prompts the user to enter the number of players, validates the input and then starts the game.
 *  <br>
 *  <br>Patrick Deniso (40194944)
 *  <br>COMP249
 *  <br>Assignment # 1
 *  <br>Due Date: 07/02/2022
 *
 *  <br>This program will let 2 to 4 people play Ladder and Snake.
 *  The program will handle everything, from the rolling of the dice to the drawing of the board one the console.
 *  The program also resolves any dice ties at the beginning when choosing the order of the players.
 *
 *  <br>One MAJOR feature of this program is that it randomly generates the board. The board is also customizable, it can be of any size and there can be
 *  as many ladders and snakes as wanted.
 */
public class PlayLadderAndSnake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ULTIMATE LADDER AND SNAKE game, made by Patrick Deniso @ Concordia University.\n");
        int playersCount = promptPlayersCount(scanner);
        if(playersCount != -1){
            LadderAndSnake game = new LadderAndSnake(playersCount, scanner);
        }

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
                int input = scanner.nextInt();
                if(input <= 4 && input >= 2){
                    numberOfPlayers = input;
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
                    System.out.print("Bad Attempt " + badAttemptCount + " - Invalid # of players. Please enter a # between 2 and 4 inclusively: ");
                }
            }
        }

        return numberOfPlayers;
    }
}
