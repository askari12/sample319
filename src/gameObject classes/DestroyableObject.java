package sample;


import javafx.scene.image.Image;

public abstract class DestroyableObject extends AttackingObject {
    private int currentHealth;
    private int maxHealth;
    private boolean destroyed;

    public DestroyableObject(Location loc, Dimension dimensions, Movement movement, Image img){
        super(loc, dimensions, movement, img);
    }
    public DestroyableObject(){

    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    public void decreaseHealth(int damage){
currentHealth=currentHealth-damage;
    }
    public boolean isDestroyed()
    {if (currentHealth<=0)
return true;
    else
        return false;
    }
}
