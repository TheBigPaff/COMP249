public class Tile {
    TileType type;
    int position;
    int destination;

    public Tile(TileType type, int position, int destination){
        this.type = type;
        this.position = position;
        if(type == TileType.DEFAULT){
            destination = position + 1;
        }
        else this.destination = destination;
    }

    public TileType getType() { return type; }
    public int getDestination() { return destination; }
    public int getPosition() { return position; }


}
