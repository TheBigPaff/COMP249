/*
 * Patrick Deniso (40194944)
 * COMP249
 * Assignment # 1
 * Due Date: 07/02/2022
 */

import java.util.*;

public class LadderAndSnake {
    private Board board;
    int numberOfPlayers;
    private ArrayList<Player> players;

    public LadderAndSnake(int numberOfPlayers, Scanner scanner){
        setNumberOfPlayers(numberOfPlayers);

        System.out.println("Game is played by "+numberOfPlayers+" players");


        players = new ArrayList<>();

        // for every player, ask name
        promptPlayersNames(numberOfPlayers, scanner);

        System.out.println("\nNow deciding which player will start playing...");
        playersDiceRoll();

        // Print sorted players
        System.out.println("Reached final decision on order of playing: ");
        for(int i = 0; i < numberOfPlayers; i++){
            if(i == numberOfPlayers - 1){
                System.out.print(players.get(i));
            }
            else{
                System.out.print(players.get(i) + ", ");
            }
        }
        System.out.println();


        scanner.nextLine(); // flush scanner
        System.out.println("\nPress Enter key to play the game...");
        if(scanner.hasNextLine()){
            scanner.nextLine();
            play(scanner);
        }
    }

    private void promptPlayersNames(int numberOfPlayers, Scanner scanner) {
        for(int i = 0; i < numberOfPlayers; i++){
            System.out.print("Enter name for Player "+ i + ": ");
            String name = scanner.next();
            players.add(new Player(name));
        }
    }

    /**
     * Method that for every player in the ArrayList players of the class LadderAndSnake, will roll a die and resolve any ties.
     * Based on the die rolls, the players are sorted accordingly in the list.
     */
    private void playersDiceRoll() {
        ArrayList<Integer> playersThrows = new ArrayList<>();

        // for every player, throw a dice
        for(int i = 0; i < numberOfPlayers; i++){
            playersThrows.add(flipDie());
            System.out.printf("%s got a dice value of %d\n", players.get(i), playersThrows.get(i));
        }

        // sort the array
        for (int i = 0; i < numberOfPlayers-1; i++)
            for (int j = 0; j < numberOfPlayers-i-1; j++)
                if (playersThrows.get(j) < playersThrows.get(j+1))
                {
                    // swap arr[j+1] and arr[j]
                    int temp = playersThrows.get(j);
                    Player tempPlayer = players.get(j);
                    playersThrows.set(j, playersThrows.get(j+1));
                    players.set(j, players.get(j+1));
                    playersThrows.set(j+1, temp);
                    players.set(j+1, tempPlayer);
                }

        boolean areThereTies = true;
        int tieSubsetStartIndex = -1, tieSubsetEndIndex = -1;
        while(areThereTies){
            int i = 0;
            int forEnd = numberOfPlayers - 1;
            if(tieSubsetStartIndex != -1){
                i = tieSubsetStartIndex;
                tieSubsetStartIndex = -1;
                forEnd = tieSubsetEndIndex;
                tieSubsetEndIndex = -1;
            }

            // check if there are any ties, they will be next to each other
            for(; i < forEnd; i++){
                if(playersThrows.get(i) == playersThrows.get(i+1)){
                    // found a tie
                    if(tieSubsetStartIndex == -1){ // update only if it's the first time
                        tieSubsetStartIndex = i;
                    }
                    tieSubsetEndIndex = i+1;
                }
            }
            if(tieSubsetStartIndex == -1) areThereTies = false;
                // resolve ONLY the ties, in that subset of the array
            else{
                System.out.print("A tie was achieved between: ");
                for(i = tieSubsetStartIndex; i <= tieSubsetEndIndex; i++){
                    if(i == tieSubsetEndIndex){
                        System.out.printf("%s", players.get(i));
                    }
                    else{
                        System.out.printf("%s, ", players.get(i));
                    }
                }
                System.out.print(". Attempting to break the tie.\n");

                for(i = tieSubsetStartIndex; i <= tieSubsetEndIndex; i++){
                    playersThrows.set(i, flipDie());
                    System.out.printf("%s got a dice value of %d\n", players.get(i), playersThrows.get(i));
                }

                // sort the subset of the array and repeat for any other ties
                // sort the array
                for (i = tieSubsetStartIndex; i < tieSubsetEndIndex; i++)
                    for (int j = tieSubsetStartIndex; j < tieSubsetEndIndex; j++)
                        if (playersThrows.get(j) < playersThrows.get(j+1))
                        {
                            // swap arr[j+1] and arr[j]
                            int temp = playersThrows.get(j);
                            Player tempPlayer = players.get(j);
                            playersThrows.set(j, playersThrows.get(j+1));
                            players.set(j, players.get(j+1));
                            playersThrows.set(j+1, temp);
                            players.set(j+1, tempPlayer);
                        }
            }
        }
    }

    // ACCESSOR/MUTATORS METHODS
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        if(numberOfPlayers > 4) this.numberOfPlayers = 4;
        else if(numberOfPlayers < 2) this.numberOfPlayers = 2;
        else this.numberOfPlayers = numberOfPlayers;
    }


    // METHODS

    /**
     *
     * @return random value between 1 and 6 inclusively.
     */
    private int flipDie(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    /**
     * Initiates the core engine of the game where the players start to play the game.
     */
    private void play(Scanner scanner){
        board = new Board();
        board.drawBoard(players);

        boolean gameOver = false;
        while(!gameOver){
            System.out.println("Press the Enter key for the next turn...");
            if(scanner.hasNextLine()) scanner.nextLine();

            // advance each player
            for (Player value : players) {
                int dieValue = flipDie();
                System.out.printf("%s got die value of %d; ", value, dieValue);


                // check if player would tile 100
                if ((value.getPlayerPosition() + dieValue) > board.getLastTileNumber()) {
                    int newSquare = board.getLastTileNumber() - (dieValue - (board.getLastTileNumber() - value.getPlayerPosition()));
                    value.setPlayerPosition(newSquare);
                    System.out.printf("surpassed tile %d, ", board.getLastTileNumber());
                } else {
                    value.advancePlayerPosition(dieValue);
                }

                Tile newTile = board.getTileFromPosition(value.getPlayerPosition());
                if (newTile.getType() == TileType.LADDER) {
                    System.out.printf("gone to square %d then climbed up to square %d\n", value.getPlayerPosition(), newTile.getDestination());
                    value.setPlayerPosition(newTile.getDestination());
                } else if (newTile.getType() == TileType.SNAKE) {
                    System.out.printf("gone to square %d then dropped down to square %d\n", value.getPlayerPosition(), newTile.getDestination());
                    value.setPlayerPosition(newTile.getDestination());
                } else {
                    System.out.println("now in square " + value.getPlayerPosition());
                }
            }

            // TODO render new board
            board.drawBoard(players);

            // check if anyone has won
            for (Player player : players) {
                if (player.getPlayerPosition() == 100) {
                    gameOver = true;
                    System.out.printf("\n%s WON THE GAME!!!", player);
                }
            }
            if(!gameOver){
                System.out.println("Game not over; flippin again");
            }
            else{
                System.out.println("\n\nGame over. I hope every had fun!");
            }
        }
    }


}
