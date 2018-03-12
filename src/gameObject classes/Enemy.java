package sample;


import javafx.scene.image.Image;

public abstract class Enemy extends DestroyableObject
{
    enum EnemyType { Obstacle , Ta , Lab,Professor };
    private int type;
    public Enemy(Location loc, Dimension dimensions, Movement movement, Image img, int type)
    {
        super(loc, dimensions, movement, img);
        this.type=type;
    }
}

