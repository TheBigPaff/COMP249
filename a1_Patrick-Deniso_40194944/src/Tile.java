/*
 * Patrick Deniso (40194944)
 * COMP249
 * Assignment # 1
 * Due Date: 07/02/2022
 */

public class Tile {
    private TileType type;
    private int position;
    private int destination;

    public Tile(TileType type, int position, int destination){
        this.type = type;
        this.position = position;

        // safety check
        if(type == TileType.DEFAULT){
            destination = position + 1;
        }
        else this.destination = destination;
    }

    public TileType getType() { return type; }
    public int getDestination() { return destination; }
    public int getPosition() { return position; }


}
