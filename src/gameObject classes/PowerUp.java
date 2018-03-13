import javafx.scene.image.Image;

import java.awt.*;
public abstract class PowerUp extends Collectable{
    public PowerUp(){}
    public abstract void powerUp(Location loc, Dimension dimensions, Movement movement, Image img);
}
