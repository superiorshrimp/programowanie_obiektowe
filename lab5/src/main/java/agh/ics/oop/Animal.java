package agh.ics.oop;

public class Animal{
    private MapDirection facing;
    private Vector2d position;
    public Animal(Vector2d initialPosition){
        this.facing = MapDirection.NORTH;
        this.position = new Vector2d(initialPosition.x, initialPosition.y);
    }
    public MapDirection getFacing(){return this.facing;}
    public Vector2d getPosition(){return this.position;}
    public boolean isAt(Vector2d loc){return this.position.equals(loc);}
    public String toString(){
        return this.facing.toString();
    }
    public void move(MoveDirection direction){
        switch (direction) {
            case LEFT: {
                this.facing = this.facing.previous();
                break;
            }
            case RIGHT: {
                this.facing = this.facing.next();
                break;
            }
            case FORWARD: {
                this.position = this.position.add(this.facing.toUnitVector());
                break;
            }
            case BACKWARD: {
                this.position = this.position.subtract(this.facing.toUnitVector());
                break;
            }
        }
    }
}