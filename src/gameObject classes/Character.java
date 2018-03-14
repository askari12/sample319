package sample;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


public class Character extends AttackingObject{

    private int type;
    private Parent root;
    private Keyboard kb;
    private Circle player;

    private int timer;
    private int maxTimer;
    private Bullet bullet;

    public Character(Location loc, Dimension dimensions, Movement movement, Image img, int type, Parent root , Keyboard kb){
        super(loc, dimensions, movement, img);
        this.type = type;
        this.root = root;
        this.kb = kb;
        maxTimer = 25;
        timer = 0;
    }

    public Character(){
    }

    @Override
    public void renderobject() {
        player = new Circle();
        player.setFill(new ImagePattern(this.img));
        player.setStroke(Color.SEAGREEN);

        player.setCenterX(loc.getX());
        player.setCenterY(loc.getY());
        player.setRadius(dimensions.getRadius());

        ((Pane) root).getChildren().add(player);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void shoot() {
        bullet = new Bullet(
                new Location(loc.getX() , loc.getY()) ,
                new Dimension(5) ,
                new Movement(0 , -1 , 15),
                1 , root);
        bullet.renderobject();
    }

    @Override
    public void move() {
        if (kb.getRightPressed()) {
            loc.setX(loc.getX() - movement.getspeed());
            player.setCenterX(loc.getX());
        }

        if (kb.getLeftPressed()) {
            loc.setX(loc.getX() + movement.getspeed());
            player.setCenterX(loc.getX());
        }

        if (kb.getUpPressed()) {
            loc.setY(loc.getY() - movement.getspeed());
            player.setCenterY(loc.getY());
        }

        if (kb.getDownPressed()) {
            loc.setY(loc.getY() + movement.getspeed());
            player.setCenterY(loc.getY());
        }

        if (kb.getSpacePressed()) {
            if (bullet == null) {
                shoot();
            }
        }

        if (bullet != null) {

            timer++;

            bullet.move();

            if (timer >= maxTimer){
                timer = 0;
                bullet.destroy();
                bullet = null;
            }
        }
    }

    public void wrap() {
        if (getX() < 0 ) {
            setX( (int) root.getScene().getWidth());
        } else if (getX() > root.getScene().getWidth()) {
            setX(0);
        } else if (getY() < 0) {
            setY( (int) root.getScene().getHeight());
        } else if (getY() > root.getScene().getHeight()) {
            setY(0);
        }
    }

    // Getters and setters

    public int getX(){
        return loc.getX();
    }

    public int getY(){
        return loc.getY();
    }

    public void setX(int x) {
        loc.setX(x);
    }

    public void setY(int y) {
        loc.setY(y);
    }
}
