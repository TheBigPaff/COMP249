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

    public LadderAndSnake(int numberOfPlayers){
        setNumberOfPlayers(numberOfPlayers);

        System.out.println("Game is played by "+numberOfPlayers+" players");
        System.out.println("Now deciding which player will start playing");

        // TODO ask for player's name
        // FIND ORDER OF PLAYERS
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Integer> playersThrows = new ArrayList<>();

        // for every player, throw a dice
        for(int i = 0; i < numberOfPlayers; i++){
            playersThrows.add(flipDice());
            players.add(new Player("Player"+i));
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
                    playersThrows.set(i, flipDice());
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


        /*
        https://stackoverflow.com/questions/35767949/struggling-to-keep-an-algorithm-to-order-players-by-dice-roll-tidy
        * You can put all of the players into an array - the order of the players in an array can be used to indicate the order of play.
        Get them all to pick a dice roll; then sort them by the number they rolled (using a custom comparator).
        Now, look for 2 or more players that rolled the same number - these are next to each other because the array is sorted.
        Now, you can recursively call the same logic to get just those players to re-roll, but only on the portion of the array where those players had the same dice roll.
        * */

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

        //play();
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
    private int flipDice(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    /**
     * Initiates the core engine of the game where the players start to play the game.
     */
    private void play(){
        board = new Board();
    }


}
