import javax.swing.text.Position;
import java.util.Random;

public class Board {
    class Coordinate{
        int x;
        int y;
    }

    static final int BOARD_WIDTH = 10;
    static final int BOARD_HEIGHT = 10;
    static final int LADDERS_COUNT = 9;
    static final int SNAKES_COUNT = 8;
    static final int DEFAULT_COUNT = BOARD_WIDTH * BOARD_HEIGHT - (LADDERS_COUNT + SNAKES_COUNT);

    static final int MAX_LADDER_LENGTH = 60;
    static final int MIN_LADDER_LENGTH = 10;
    static final int MAX_SNAKE_LENGTH = 70;
    static final int MIN_SNAKE_LENGTH = 10;

    private Tile[][] board;

    public Board(){
        board = new Tile[BOARD_WIDTH][BOARD_HEIGHT];
        generateBoard();
    }

    private void generateBoard() {
        // First, let's spawn the ladders
        for(int i = 0; i < LADDERS_COUNT; i++){
            // find random tile position, that's not already occupied
            Random rand = new Random();
            // cannot be ladders after on the last row
            //Math.floor(Math.random()*(max-min+1)+min) ----> min & max are inclusive

            int position = 0;
            boolean foundTile = false;
            while(!foundTile){
                // min is 1, max is the last tile of the second to last row
                position = (int) Math.floor(Math.random()*(BOARD_WIDTH * BOARD_HEIGHT - BOARD_WIDTH)+1);

                // check if tile is free
                Coordinate coords = getCoordinateFromTileNumber(position);
                if(board[coords.x][coords.y] == null){
                    // free!
                    foundTile = true;
                }
            }

            int destination = 0;
            foundTile = false;
            while(!foundTile){
                // min is position+BOARD_WIDTH (always 1 row up), max the last tile
                destination = (int) Math.floor(Math.random()*((BOARD_WIDTH * BOARD_HEIGHT)- (position+BOARD_WIDTH)) + (position+BOARD_WIDTH));

                // check if tile is free
                Coordinate coords = getCoordinateFromTileNumber(destination);
                if(board[coords.x][coords.y] == null){
                    // free!
                    foundTile = true;
                }
            }



        }

        // Second, let's spawn the snakes in all the tiles except the ones where there's a ladder
        for(int i = 0; i < SNAKES_COUNT; i++){

        }

        // Last, let's fill all the other tiles with default tiles.
        for(int i = 0; i < DEFAULT_COUNT; i++){

        }
    }

    private Coordinate getCoordinateFromTileNumber(int tileNumber){
        // TODO: remake, very bad

        int count = 0;
        Coordinate coordinate = new Coordinate();

        for(int i = 0; i < BOARD_WIDTH; i++){
            for(int j = 0; j < BOARD_HEIGHT; j++){
                count++;
                if(count == tileNumber){
                    coordinate.x = i;
                    coordinate.y = j;
                }
            }
        }

        return coordinate;
    }
}
