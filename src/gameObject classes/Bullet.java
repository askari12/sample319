package sample;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bullet extends GameObject {

    private int damage;
    private Circle bullet;
    private Parent root;


    public Bullet(Location loc, Dimension dimensions, Movement movement, int damage , Parent root) {
        super(loc, dimensions , movement, null);

        this.damage = damage;
        this.root = root;
    }


    @Override
    public void renderobject() {
        bullet = new Circle();
        bullet.setCenterX(loc.getX());
        bullet.setCenterY(loc.getY());
        bullet.setRadius(5);

        bullet.setStroke(Color.RED);
        bullet.setFill(Color.BLACK);

        ((Pane) root).getChildren().add(bullet);
    }

    public void move() {
        loc.setX(loc.getX() + movement.getspeed() * movement.getDx());
        loc.setY(loc.getY() + movement.getspeed() * movement.getDy());

        bullet.setCenterX(loc.getX());
        bullet.setCenterY(loc.getY());
    }

    @Override
    public void destroy() {
        bullet.setVisible(false);
    }
}
