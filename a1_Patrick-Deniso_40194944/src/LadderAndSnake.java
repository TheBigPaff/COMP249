import java.util.Random;

public class LadderAndSnake {
    private Board board;
    private int numberOfPlayers;

    public LadderAndSnake(int numberOfPlayers){
        setNumberOfPlayers(numberOfPlayers);
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
    public int FlipDice(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    /**
     * Initiates the core engine of the game where the players start to play the game.
     */
    public void Play(){
        board = new Board();
    }


}
