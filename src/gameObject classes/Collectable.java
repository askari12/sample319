import javafx.scene.image.Image;


public class Collectable extends GameObject {
    public Collectable(Location loc, Dimension dimensions, Movement movement, Image img){
        super(loc,dimensions,movement,img);
    }
    // ia this method abstract?
    public void powers(){}
}
