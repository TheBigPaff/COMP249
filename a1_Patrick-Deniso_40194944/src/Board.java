/*
 * Patrick Deniso (40194944)
 * COMP249
 * Assignment # 1
 * Due Date: 07/02/2022
 */

import java.util.ArrayList;
import java.util.Random;


/**
 * The Board class that stores the 2D tile array and also handles board random generation and board rendering on the console.
 */
public class Board {
    /**
     * Coordinate class (works as a struct) that is useful for dealing with the 2D tile array, since we need x and y coords to access elements.
     */
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

    /**
     * Board constructor that calls the method that generates a random board.
     */
    public Board(){
        board = new Tile[BOARD_WIDTH][BOARD_HEIGHT];

        generateBoard();
    }

    /**
     * A method that prints a divider
     */
    private void divideRow(){
        // print dashes to divide each row
        for(int k = 0; k < (BOARD_WIDTH * 16) + 1; k++){
            if(k % 16 == 0) {
                System.out.print("+");
            }
            else{
                System.out.print("-");
            }
        }
        System.out.println();
    }

    /**
     * Renders the board to the console.
     */
    public void drawBoard(ArrayList<Player> players){
        // start from the top and work your way down to the bottom to draw the table
        int count = 101;
        for(int y = BOARD_HEIGHT - 1; y >= 0; y--){
            divideRow();

            // now if 'y' is odd: count decreases
            // if 'y' is even: count increases
            if(y % 2 == 0){
                count -= BOARD_WIDTH;
                for(int x = 0; x < BOARD_WIDTH; x++){
                    if(x==0) System.out.print("|");
                    System.out.format("%6s%3d%6s|", " ", count, " ");
                    count++;
                }
                System.out.println();
                for(int x = 0; x < BOARD_WIDTH; x++){
                    if(x==0) System.out.print("|");
                    // now print if there's a ladder of snake
                    printSpecialTile(y, x);
                }
                printPlayersLines(players, count - BOARD_WIDTH, true);

                count -= BOARD_WIDTH;
            }
            else{
                for(int x = BOARD_WIDTH - 1; x >= 0; x--){
                    if(x==BOARD_WIDTH - 1) System.out.print("|");
                    count--;
                    System.out.format("%6s%3d%6s|", " ", count, " ");
                }
                System.out.println();
                for(int x = BOARD_WIDTH - 1; x >= 0; x--){
                    if(x == BOARD_WIDTH - 1) System.out.print("|");
                    // now print if there's a ladder of snake
                    printSpecialTile(y, x);
                }
                printPlayersLines(players, count + 10, false);
            }

            System.out.println();
        }
        divideRow();

    }

    /**
     * Method that prints if the square is a ladder or snake
     * @param y coordinate y
     * @param x coordinate x
     */
    private void printSpecialTile(int y, int x) {
        if (board[x][y].getType() == TileType.LADDER) {
            System.out.format("%1s%10s%3d%1s|", " ", "Climb to ", board[x][y].getDestination(), " ");
        } else if (board[x][y].getType() == TileType.SNAKE) {
            System.out.format("%1s%10s%3d%1s|", " ", "Drop to ", board[x][y].getDestination(), " ");
        } else {
            for (int k = 0; k < 15; k++) {
                System.out.print(" ");
            }
            System.out.print("|");
        }
    }

    /**
     * Method that prints if there's a player in that square.
     * @param players list of players
     * @param count square's position
     * @param tilesIncreasing boolean that states if that row of squares has increasing squares or decreasing squares going to the right.
     */
    private void printPlayersLines(ArrayList<Player> players, int count, boolean tilesIncreasing) {
        for (Player player : players) {
            System.out.println();
            for (int x = 0; x < BOARD_WIDTH; x++) {
                if(x==0) System.out.print("|");
                if(!tilesIncreasing) count--;
                if (player.getPlayerPosition() == count) {
                    System.out.format("%10s%5s", player, " ");
                } else {
                    System.out.format("%15s", " ");
                }
                System.out.print("|");
                if(tilesIncreasing) count++;
            }
            if(tilesIncreasing)
                count -= BOARD_WIDTH;
            else
                count += BOARD_WIDTH;
        }
    }

    /**
     * Generates a procedurally generated board given the parameters hardcoded as constants in the Board class.
     * This board is set as the board 2D-array of the Board class.
     */
    private void generateBoard() {
        // First, let's spawn the ladders
        for(int i = 0; i < LADDERS_COUNT; i++){
            // find random tile position, that's not already occupied
            Random rand = new Random();
            // cannot be ladders after on the last row
            //Math.floor(Math.random()*(max-min+1)+min) ----> min & max are inclusive

            /*
            * Let's save the coords of the position, so that we can save the tile in the right index of the 2D-array.
            * Technically we don't need this, because of the Tile class design, we can save the tiles in a list.
            * But we get better marks for implementing the board in a 2D-array.
            * */
            int positionCoordX = 0, positionCoordY = 0;

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
                    positionCoordX = coords.x;
                    positionCoordY = coords.y;
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

            // instantiate tile and save it to board 2d-array, at the index of the position
            board[positionCoordX][positionCoordY] = new Tile(TileType.LADDER, position, destination);
        }

        // Second, let's spawn the snakes in all the tiles except the ones where there's a ladder
        for(int i = 0; i < SNAKES_COUNT; i++){
            Random rand = new Random();

            int positionCoordX = 0, positionCoordY = 0;
            int position = 0;
            boolean foundTile = false;
            while(!foundTile){
                // min is first of second row, max is the second to last tile of the last row
                int min = BOARD_WIDTH + 1;
                int max = BOARD_WIDTH * BOARD_HEIGHT - 1;
                position = (int) Math.floor(Math.random()*(max-min+1)+min);

                // check if tile is free
                Coordinate coords = getCoordinateFromTileNumber(position);
                if(board[coords.x][coords.y] == null){
                    // now check if in the whole board there's a tile (ladder) that has these coords as destination
                    boolean tileIsDestination = false;
                    for(int y = 0; y < BOARD_HEIGHT; y++){
                        for (int x = 0; x < BOARD_WIDTH; x++){
                            if (board[x][y] != null && board[x][y].getDestination() == position) {
                                tileIsDestination = true;
                                break;
                            }
                        }
                    }
                    if(!tileIsDestination){
                        foundTile = true;
                        positionCoordX = coords.x;
                        positionCoordY = coords.y;
                    }

                }
            }

            int destination = 0;
            foundTile = false;
            while(!foundTile){
                // min is 1, max is position - BOARD_WIDTH
                int min = 1;
                int max = position - BOARD_WIDTH;
                destination = (int) Math.floor(Math.random()*(max-min+1)+min);

                // check if tile is free
                Coordinate coords = getCoordinateFromTileNumber(destination);
                if(board[coords.x][coords.y] == null){
                    // free!
                    foundTile = true;
                }
            }

            // instantiate tile and save it to board 2d-array, at the index of the position
            board[positionCoordX][positionCoordY] = new Tile(TileType.SNAKE, position, destination);
        }

        // Last, let's fill all the other tiles with default tiles.
        for(int i = 1; i <= BOARD_HEIGHT * BOARD_WIDTH; i++){
            Coordinate coords = getCoordinateFromTileNumber(i);

            // check if there's a tile. if there isn't one, fill it with a default tile
            if(board[coords.x][coords.y] == null){
                board[coords.x][coords.y] = new Tile(TileType.DEFAULT, i, i+1);
            }
        }
    }

    /**
     * Returns the coordinate (struct of x and y values) given a tile number.
     * @param tileNumber number of the tile to get the coordinate from
     * @return object of type Coordinate
     */
    private Coordinate getCoordinateFromTileNumber(int tileNumber){
        int count = 0;
        Coordinate coordinate = new Coordinate();

        for(int i = 0; i < BOARD_HEIGHT; i++){
            for(int j = 0; j < BOARD_WIDTH; j++){
                count++;
                if(count == tileNumber){
                    coordinate.x = j;
                    coordinate.y = i;
                }
            }
        }

        return coordinate;
    }

    /**
     * A method that returns the a Tile object given a tile number.
     * @param tileNumber number of the tile to get the Tile from
     * @return object of type Tile
     */
    public Tile getTileFromPosition(int tileNumber){
        Coordinate coords = getCoordinateFromTileNumber(tileNumber);
        return board[coords.x][coords.y];
    }

    /**
     * Method that returns last tile number.
     * This is because this game supports multiple board sizes
     * @return last tile number
     */
    public int getLastTileNumber(){
        return BOARD_WIDTH * BOARD_HEIGHT;
    }
}
