import java.util.Random;

public class LadderAndSnake {
    static final int BOARD_WIDTH = 10;
    static final int BOARD_HEIGHT = 10;

    private Tile[][] board;
    private int numberOfPlayers;

    public LadderAndSnake(int numberOfPlayers){
        generateBoard();
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
    private void generateBoard() {
        board = new Tile[BOARD_WIDTH][BOARD_HEIGHT];

        // TO-DO: MAKE BOARD RANDOMLY GENERATED
        /*
        for(int i = 0; i < BOARD_WIDTH; i++){
            for(int j = 0; j < BOARD_HEIGHT; j++){

            }
        }

         */
    }

    private int flipDice(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    private void play(){

    }


}
