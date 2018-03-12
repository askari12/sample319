package sample;


import javafx.scene.image.Image;

public abstract class GameObject {

    protected Location loc;
    protected Dimension dimensions;
    protected Movement movement;
    protected Image img;

    public GameObject(Location loc, Dimension dimensions, Movement movement, Image img){
        this.loc=loc;
        this.dimensions=dimensions;
        this.movement=movement;
        this.img=img;
    }

    public GameObject(){
    }

    public abstract void renderobject();
    public abstract void destroy();

    private boolean hasCollided(Location loc, Dimension dimensions)
    {
        float distance = this.loc.getDistance(this.loc, loc);
        distance = distance - dimensions.getRadius() - this.dimensions.getRadius();

        if(distance <= 0)
            return true;
        else
            return false;
    }
}
