package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class Settings {

    @FXML private Button backButton;
    @FXML private CheckBox musicCheckBox;
    @FXML private CheckBox audioCheckBox;
    @FXML private ToggleButton easyToggleButton;
    @FXML private ToggleButton mediumToggleButton;
    @FXML private ToggleButton hardToggleButton;


    @FXML protected void backButtonListener(ActionEvent event) throws Exception {

        Stage settingsStage = (Stage) backButton.getScene().getWindow();
        Parent settingsRoot = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));

        Scene settingsScene = new Scene(settingsRoot, 737, 491);
        settingsStage.setScene(settingsScene);
    }

    @FXML protected void musicCheckBoxListener(ActionEvent event) throws Exception {

    }

    @FXML protected void audioCheckBoxListener(ActionEvent event) throws Exception {

    }

    @FXML protected void easyToggleButtonListener(ActionEvent event) throws Exception {

    }

    @FXML protected void mediumToggleButtonListener(ActionEvent event) throws Exception {

    }
    @FXML protected void hardToggleButtonListener(ActionEvent event) throws Exception {

    }
}
