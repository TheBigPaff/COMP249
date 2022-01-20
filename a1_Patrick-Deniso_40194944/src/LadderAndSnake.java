import java.util.Random;

public class LadderAndSnake {
    private Board board;
    private int numberOfPlayers;

    public LadderAndSnake(int numberOfPlayers){
        board = new Board();
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

    private int flipDice(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    private void play(){

    }


}
