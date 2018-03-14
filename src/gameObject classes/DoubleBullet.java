package sample;
import javafx.scene.image.Image;

public  class DoubleBullet extends PowerUp {
    public DoubleBullet(Location loc, Dimension dimensions, Movement movement, Image img){
        super(loc,dimensions,movement,img);
    }
    public void powers(){}

    @Override
    public void powerUp(Location loc, Dimension dimensions, Movement movement, Image img) {

    }

    @Override
    public void renderobject() {

    }

    @Override
    public void destroy() {

    }
}
