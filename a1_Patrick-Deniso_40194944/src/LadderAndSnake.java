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

        /*
        https://stackoverflow.com/questions/35767949/struggling-to-keep-an-algorithm-to-order-players-by-dice-roll-tidy
        * You can put all of the players into an array - the order of the players in an array can be used to indicate the order of play.
        Get them all to pick a dice roll; then sort them by the number they rolled (using a custom comparator).
        Now, look for 2 or more players that rolled the same number - these are next to each other because the array is sorted.
        Now, you can recursively call the same logic to get just those players to re-roll, but only on the portion of the array where those players had the same dice roll.
        * */

        System.out.println("Reached final decision on order of playing: ");
        for(Player player : sortedPlayers){
            System.out.println(player + ",");
        }
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
