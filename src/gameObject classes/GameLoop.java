package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//All needed imports

public class GameLoop extends Application {//Class that contains game engine and controlls
    private Stage primaryStage;//For UI
    private Parent root;//For UI
    private Keyboard keyboard;//for keyboard listening
    private Character player;//player instance
    private Companion companion;//companion instance
    private Companion companion2;//companion instance
    //private ArrayList<Enemy> enemyList;
    private Ta enemy;//enemy instance

    @Override
    public void start(Stage primaryStage) throws Exception {//Game loop

        root = FXMLLoader.load(getClass().getResource("sample.fxml"));//play game screen fxml
        this.primaryStage = primaryStage;//stage becomes game screen

        primaryStage.setTitle("Play Game");                            //Game screen created
        primaryStage.setScene(new Scene(root, 737, 491));  //
        primaryStage.show();// game started to show
        keyboard = new Keyboard(primaryStage);//Keyboard instance created and made to listen inputs
        keyboard.kbInputs();                  //

        createPlayer();             //
        player.renderobject();      //
        createCompanions();         //Character and companions are showing in screen simultaneously
        companion.renderobject();   //
        companion2.renderobject();  //
        createEnemy();              //
        enemy.renderobject();       //


        new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
            }
        }.start();//loop

    }

    public void update() {//gets move and wrap information from characher and companions
        player.move();
        player.wrap();
        companion.move();
        companion2.move();
        companion.wrap();
        companion2.wrap();
        if(enemy!=null){
        enemy.move();
        //enemy.wrap();//if you get out from comment enemy will always comes to screen
        }
        checkcollisions();


    }

    public void checkcollisions() {
        if (enemy != null && player.bullet != null)
            if (enemy.hasCollided(player.bullet.loc, player.bullet.dimensions) == true) {
                if (enemy.isDestroyed() == true) {
                    enemy.destroy();
                    enemy = null;
                } else
                    enemy.decreaseHealth(player.bullet.getDamage());
            }
        if (enemy != null && companion.bullet != null)
            if (enemy.hasCollided(companion.bullet.loc, companion.bullet.dimensions) == true) {
                if (enemy.isDestroyed() == true) {
                    enemy.destroy();
                    enemy = null;
                } else
                    enemy.decreaseHealth(companion.bullet.getDamage());
            }
        if (enemy != null && companion2.bullet != null)
            if (enemy.hasCollided(companion2.bullet.loc, companion2.bullet.dimensions) == true) {
                if (enemy.isDestroyed() == true) {
                    enemy.destroy();
                    enemy = null;
                } else
                    enemy.decreaseHealth(companion2.bullet.getDamage());
            }
    }

    public void createPlayer() {//player instance being created
        try {
            player = new Character(
                    new Location(500, 300),
                    new Dimension(20),
                    new Movement(0, 0, 5),
                    new Image(new FileInputStream("C:\\Users\\Enes Varol\\IdeaProjects\\src\\resources\\image.jpeg")),
                    0,
                    root,
                    keyboard);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createCompanions() {//companion instances being created
        try {
            companion = new Companion(
                    new Location(450, 350),
                    new Dimension(20),
                    new Movement(0, 0, 5),
                    new Image(new FileInputStream("C:\\Users\\Enes Varol\\IdeaProjects\\src\\resources\\image.jpeg")),
                    0,
                    root,
                    keyboard);

            companion2 = new Companion(
                    new Location(550, 350),
                    new Dimension(20),
                    new Movement(0, 0, 5),
                    new Image(new FileInputStream("C:\\Users\\Enes Varol\\IdeaProjects\\src\\resources\\image.jpeg")),
                    0,
                    root,
                    keyboard);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createEnemy() {//enemy instance being created
        try {

            enemy = new Ta(
                    new Location(100, 100),
                    new Dimension(10),
                    new Movement(1, 0, 5),
                    new Image(new FileInputStream("C:\\Users\\Enes Varol\\IdeaProjects\\src\\resources\\image.jpeg")),
                    root
            );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private Button backButton;

    @FXML protected void backButtonListener(ActionEvent event) throws Exception {//to be able to go back

        Stage settingsStage = (Stage) backButton.getScene().getWindow();
        Parent settingsRoot = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));

        Scene settingsScene = new Scene(settingsRoot, 737, 491);
        settingsStage.setScene(settingsScene);
    }
}