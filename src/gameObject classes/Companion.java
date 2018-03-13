package sample;

import javafx.scene.image.Image;

public abstract class Companion extends AttackingObject {

    public Companion(Location loc, Dimension dimensions, Movement movement, Image img){
        super(loc, dimensions, movement, img);
    }

    public abstract  void powers();
}
