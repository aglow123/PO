package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public String toString(){
        return this.position + ", " + this.orientation;
    }

    public MapDirection getOrientation(){return this.orientation;}

    public Vector2d getPosition(){return this.position;}

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public Animal move(MoveDirection direction){
        switch (direction){
            case FORWARD:
                switch (this.orientation){
                    case NORTH:
                        if (this.position.y < 4){
                            this.position = this.position.add(new Vector2d(0, 1));
                        }
                        return this;
                    case SOUTH:
                        if (this.position.y > 0){
                            this.position = this.position.add(new Vector2d(0,-1));
                        }
                        return this;
                    case WEST:
                        if (this.position.x > 0){
                            this.position = this.position.add(new Vector2d(-1,0));
                        }
                        return this;
                    case EAST:
                        if (this.position.x < 4){
                            this.position = this.position.add(new Vector2d(1,0));
                        }
                        return this;
                }
            case BACKWARD:
                switch (this.orientation){
                    case NORTH:
                        if (this.position.y > 0){
                            this.position = this.position.add(new Vector2d(0, -1));
                        }
                        return this;
                    case SOUTH:
                        if (this.position.y < 4){
                            this.position = this.position.add(new Vector2d(0,1));
                        }
                        return this;
                    case WEST:
                        if (this.position.x < 4){
                            this.position = this.position.add(new Vector2d(1,0));
                        }
                        return this;
                    case EAST:
                        if (this.position.x > 0){
                            this.position = this.position.add(new Vector2d(-1,0));
                        }
                        return this;
                }
            case RIGHT:
                this.orientation = this.orientation.next();
                return this;
            case LEFT:
                this.orientation = this.orientation.previous();
                return this;
            default:
                return this;
        }
    }
}
