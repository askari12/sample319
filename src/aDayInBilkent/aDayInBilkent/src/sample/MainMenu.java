package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainMenu {

    @FXML private Button playGameButton;
    @FXML private Button selectCharacterButton;
    @FXML private Button selectCompanionButton;
    @FXML private Button shopButton;
    @FXML private Button highScoreButton;
    @FXML private Button settingsButton;
    @FXML private Button creditsButton;

    @FXML protected void playGameButtonListener(ActionEvent event) {
        Stage gameStage = (Stage) playGameButton.getScene().getWindow();
        gameStage.setScene(new Scene(new Pane()));
    }

    @FXML protected void selectCharacterButtonListener(ActionEvent event) {
        Stage characterStage = (Stage) selectCharacterButton.getScene().getWindow();
        characterStage.setScene(new Scene(new Pane()));
    }

    @FXML protected void selectCompanionButtonListener(ActionEvent event) {
        Stage companionStage = (Stage) selectCompanionButton.getScene().getWindow();
        companionStage.setScene(new Scene(new Pane()));
    }

    @FXML protected void shopButtonListener(ActionEvent event) throws Exception {

        Stage shopStage = (Stage) shopButton.getScene().getWindow();
        Parent shopRoot = FXMLLoader.load(getClass().getResource("shop.fxml"));

        Scene shopScene = new Scene(shopRoot, 737, 491);
        shopStage.setScene(shopScene);
    }

    @FXML protected void highScoreButtonListener(ActionEvent event) throws Exception {

        Stage highScoreStage = (Stage) highScoreButton.getScene().getWindow();
        Parent highScoreRoot = FXMLLoader.load(getClass().getResource("highScore.fxml"));

        Scene highScoreScene = new Scene(highScoreRoot, 737, 491);
        highScoreStage.setScene(highScoreScene);
    }

    @FXML protected void settingsButtonListener(ActionEvent event) throws Exception {

        Stage settingsStage = (Stage) settingsButton.getScene().getWindow();
        Parent settingsRoot = FXMLLoader.load(getClass().getResource("settings.fxml"));

        Scene settingsScene = new Scene(settingsRoot, 737, 491);
        settingsStage.setScene(settingsScene);
    }

    @FXML protected void creditsButtonListener(ActionEvent event) throws Exception {

        Stage creditsStage = (Stage) creditsButton.getScene().getWindow();
        Parent creditsRoot = FXMLLoader.load(getClass().getResource("credits.fxml"));

        Scene creditsScene = new Scene(creditsRoot, 737, 491);
        creditsStage.setScene(creditsScene);
    }
}
