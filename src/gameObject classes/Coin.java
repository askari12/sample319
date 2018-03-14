package sample;
import javafx.scene.image.Image;

public class Coin extends Collectable{
    public Coin(Location loc, Dimension dimensions, Movement movement, Image img){
        super(loc,dimensions,movement,img);
    }

    @Override
    public void renderobject() {

    }

    @Override
    public void destroy() {

    }
}
