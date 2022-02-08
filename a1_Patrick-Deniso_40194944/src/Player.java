/*
 * Patrick Deniso (40194944)
 * COMP249
 * Assignment # 1
 * Due Date: 07/02/2022
 */

/**
 * The Player class that stores the player position and the player name.
 */
public class Player {
    private int playerPosition;
    private String playerName;

    public Player(String playerName){
        this.playerName = playerName;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getPlayerName() {
        return playerName;
    }

    /**
     *  Advances the player's position of tilesCount amount of tiles
     * @param tilesCount amount of tiles to advance
     */
    public void advancePlayerPosition(int tilesCount){
        playerPosition += tilesCount;
    }

    /**
     * @return the player's name
     */
    @Override
    public String toString() {
        return getPlayerName();
    }
}
