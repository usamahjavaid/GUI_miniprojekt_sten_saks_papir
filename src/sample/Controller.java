package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Date;
import java.util.Random;

public class Controller {

    @FXML
    private Button Sten;

    @FXML
    private Button Saks;

    @FXML
    private Button Papir;

    @FXML
    private ImageView Billede;

    @FXML
    private ImageView Billede2;

    @FXML
    private Button Save;

    @FXML
    private Button Load;

    @FXML
    private TextField Score;

    Date d = new Date();

    Random random = new Random();
    final int STEN = 1;
    final int SAKS = 2;
    final int PAPIR = 3;

    Image sten = new Image("sample/billeder/Sten.png");
    Image papir = new Image("sample/billeder/Papir.png");
    Image saks = new Image("sample/billeder/Saks.png");



    @FXML
    void kastPapir(ActionEvent event) {

        int Computer = random.nextInt(3) + 1;
        Image i1 = new Image("sample/billeder/Papir.png");
        Billede.setImage(i1);
        System.out.println(d.toString() + " spillere valgte papir ");

        if (Computer  == PAPIR) {
            Billede2.setImage(papir);
            System.out.println("Draw" );


        } else if (Computer == SAKS) {
            Billede2.setImage(saks);
            System.out.println("You win");


        } else if (Computer == STEN) {
            Billede2.setImage(sten);
            System.out.println("Computer loses");

        }


    }
    @FXML
    void kastSaks(ActionEvent event) {
        int Computer = random.nextInt(3) + 1;

        Image i1 = new Image("sample/billeder/Saks.png");
        Billede.setImage(i1);
        System.out.println(d.toString() + " spillere valgte saks " );

        if (Computer  == PAPIR) {
            Billede2.setImage(papir);
            System.out.println("Computer loses");

        } else if (Computer == SAKS) {
            Billede2.setImage(saks);
            System.out.println("draw");

        } else if (Computer == STEN){
            Billede2.setImage(sten);
            System.out.println("You win");

        }


    }

    @FXML
    void kastSten(ActionEvent event) {
        int Computer = random.nextInt(3) + 1;

        Image i1 = new Image("sample/billeder/Sten.png");
        Billede.setImage(i1);
        System.out.println(d.toString() + " spillere valgte sten " );

        if (Computer  == PAPIR) {
            Billede2.setImage(papir);
            System.out.println("Computer win");

        } else if (Computer == SAKS) {
            Billede2.setImage(saks);
            System.out.println("You win");

        } else if (Computer == STEN) {
            Billede2.setImage(sten);
            System.out.println("draw");


        }

    }

    @FXML
    void loadGame(ActionEvent event) {

    }

    @FXML
    void saveGame(ActionEvent event) {

    }

    @FXML
    void showScore(ActionEvent event) {

    Score.appendText("");



    }

}