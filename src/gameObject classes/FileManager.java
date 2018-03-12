package sample;

import javafx.scene.image.Image;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    private File currFile;
    private FileWriter fw;
    private Scanner in;

    // File Names
    private String coinFile = "coins";

    public FileManager() {
    }

    /***********************************************************************************************************/

    // Getters

    /*
        Gets the Coins of the User.
    */
    public int getCoins() {

        // Open the Scanner
        openScanner(coinFile);

        // Get Data
        int coins = 0;
        while(in.hasNextInt()) {
            coins = in.nextInt();
        }

        // Close the Scanner
        closeScanner();

        return coins;
    }

    //public ArrayList<Character> getCharacters(){}
    //public ArrayList<Companion> getCompanion(){}
    //public Character getCurrentCharacter(){}
    //public Companion[] getCurrentCompanions(){}
    //public ArrayList<Item> getItems(){}
    //public void getSound(){}

    /*
        Gets the sound settings of the User.
    */
    public boolean getSoundOn(){

        // Open the Scanner
        openScanner("SoundOn");

        // Get Data
        String bool = "false";
        while(in.hasNext()) {
            bool = in.next();
        }

        // Close Scanner
        closeScanner();

        if (bool.equals("false")) {
            return false;
        } else {
            return true;
        }
    }

    //public boolean getMusicOn(){}
    //public int getDifficulty(){}
    //public ArrayList<String> getHighScore(){}
    //public String getCredits(){}
    //public ArrayList<Enemy> getEnemies(){}
    //public ArrayList<PowerUp> getPowerUps(){}
    //public ArrayList<Image> getImages(){}

    /***********************************************************************************************************/

    // Setters

    public void updateCoins(int coins) {

        // open the File Writere
        openFileWriter(coinFile);

        try {
            // Clear The value
            fw.flush();

            // Write to file
            fw.append(coins + "");
        }

        catch (IOException e) {
            System.err.println("File Not Found");
            System.exit(1);
        }

        closeFileWriter();
    }

    //public void updateCurrentCharacter(Character character){}
    //public void updateCurrentCompanions(Companion[] companions){}
    //public void updateSound(boolean soundOn){}
    //public void updateMusic(boolean soundOff){}
    //public void updateDifficulty(int difficulty){}
    //public void updateHighScore(ArrayList<String> hs){}


    /***********************************************************************************************************/

    // Private Methods

    // Open File
    private void openFile(String title){
        // Create File
        this.currFile = new File(title + ".txt");
    }

    // Open File Writer
    private void openFileWriter(String title) {

        openFile(title);

        try {
            this.fw = new FileWriter(currFile);
        } catch (IOException e) {
            System.err.println("File Not Found");
            System.exit(1);
        }

    }

    // Open Scanner
    private void openScanner(String title) {

        openFile(title);

        try {
            this.in = new Scanner(currFile);
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
            System.exit(11);
        }
    }

    // Close File
    private void closeFileWriter() {
        try {
            this.fw.close();
        } catch (IOException e) {
            System.err.println("File Not Found");
            System.exit(12);
        }
    }

    private void closeScanner() {
        this.in.close();
    }
}
