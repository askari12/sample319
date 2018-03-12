package sample;


import javafx.scene.image.Image;

public abstract class Enemy extends DestroyableObject
{
    enum EnemyType { Obstacle , Ta , Lab,Professor };

    public Enemy(Location loc, Dimension dimensions, Movement movement, Image img)
    {
        super(loc, dimensions, movement);

    }
}

