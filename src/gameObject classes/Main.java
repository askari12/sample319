package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application {

    private Stage primaryStage;
    private Parent root;
    private Keyboard keyboard;

    private Character player;
    //private ArrayList<Enemy> enemyList;
    private Enemy enemy;

    @Override
    public void start(Stage primaryStage) throws Exception{

        root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        this.primaryStage = primaryStage;

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 700  , 1000));
        primaryStage.show();

        keyboard = new Keyboard(primaryStage);
        keyboard.kbInputs();

        createPlayer();
        player.renderobject();

        createEnemy();
        enemy.renderobject();

        new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
            }
        }.start();

    }

    public void update() {
        player.move();
        player.wrap();

        enemy.move();

    }

    public void createPlayer() {
        try {
            player = new Character(
                    new Location(500 , 300) ,
                    new Dimension(20) ,
                    new Movement(0 , 0 , 5) ,
                    new Image(new FileInputStream("/home/askari/Pictures/aliensprite.png")) ,
                    0,
                    root,
                    keyboard);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createEnemy() {
        try{

            enemy = new Ta(
                    new Location(100 , 100) ,
                    new Dimension(10) ,
                    new Movement(1 , 0 , 5) ,
                    new Image(new FileInputStream("/home/askari/Pictures/aliensprite.png")),
                    root
            );

        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}
