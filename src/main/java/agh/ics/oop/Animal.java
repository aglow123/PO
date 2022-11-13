package agh.ics.oop;

public class Animal{
    private static final Vector2d DEF_POSITION = new Vector2d(2,2);
    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    public Animal(IWorldMap map){
        this(map, DEF_POSITION);
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
        if(!map.place(this)){
            throw new IllegalArgumentException();
        }
    }

    public String toString(){
        switch (orientation){
            case NORTH: return "^";
            case EAST: return ">";
            case SOUTH: return "v";
            case WEST: return "<";
        }
        return this.toString();
    }

    public MapDirection getOrientation(){return this.orientation;}

    public Vector2d getPosition(){return this.position;}

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public Animal move(MoveDirection direction){
        Vector2d newPosition = null;

        switch (direction) {
            case FORWARD:
                switch (this.orientation) {
                    case NORTH:
                        newPosition = this.position.add(new Vector2d(0, 1));
                        break;
                    case SOUTH:
                        newPosition = this.position.add(new Vector2d(0, -1));
                        break;

                    case WEST:
                        newPosition = this.position.add(new Vector2d(-1, 0));
                        break;

                    case EAST:
                        newPosition = this.position.add(new Vector2d(1, 0));
                        break;

                }
                break;
            case BACKWARD:
                switch (this.orientation) {
                    case NORTH:
                        newPosition = this.position.add(new Vector2d(0, -1));
                        break;

                    case SOUTH:
                        newPosition = this.position.add(new Vector2d(0, 1));
                        break;

                    case WEST:
                        newPosition = this.position.add(new Vector2d(1, 0));
                        break;

                    case EAST:
                        newPosition = this.position.add(new Vector2d(-1, 0));
                        break;
                }
                break;
            case RIGHT:
                this.orientation = this.orientation.next();
                newPosition = this.position;
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                newPosition = this.position;
                break;
        }
        if (this.map.canMoveTo(newPosition)) {
            this.position = newPosition;
        }
        return this;
    }


}
