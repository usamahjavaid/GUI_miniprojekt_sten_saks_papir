package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;

import java.io.*;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

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

    int player = 0;
    int ai = 0;

    String gameData = "";


    @FXML
    void kastPapir(ActionEvent event) {

        int Computer = random.nextInt(3) + 1;
        Image i1 = new Image("sample/billeder/Papir.png");
        Billede.setImage(i1);
        System.out.println(d.toString() + " spillere valgte papir ");

        if (Computer == PAPIR) {
            Billede2.setImage(papir);
            System.out.println("Draw");
            gameData = ("player:papir - computer:papir");

        } else if (Computer == SAKS) {
            Billede2.setImage(saks);
            System.out.println("AI wins");
            ai++;
            gameData = ("player:papir - computer:saks");
        } else if (Computer == STEN) {
            Billede2.setImage(sten);
            System.out.println("Player wins");
            player++;
            gameData = ("player:papir - computer:sten");
        }
        Score.setText(player + "-" + ai);

    }

    @FXML
    void kastSaks(ActionEvent event) {
        int Computer = random.nextInt(3) + 1;

        Image i1 = new Image("sample/billeder/Saks.png");
        Billede.setImage(i1);
        System.out.println(d.toString() + " spillere valgte saks ");

        if (Computer == PAPIR) {
            Billede2.setImage(papir);
            System.out.println("Player wins");
            player++;
            gameData = ("player:saks - computer:papir");
        } else if (Computer == SAKS) {
            Billede2.setImage(saks);
            System.out.println("draw");
            gameData = ("player:saks - computer:saks");

        } else if (Computer == STEN) {
            Billede2.setImage(sten);
            System.out.println("Ai wins");
            ai++;
            gameData = ("player:saks - computer:sten");
        }
        Score.setText(player + "-" + ai);

    }

    @FXML
    void kastSten(ActionEvent event) {
        int Computer = random.nextInt(3) + 1;

        Image i1 = new Image("sample/billeder/Sten.png");
        Billede.setImage(i1);
        System.out.println(d.toString() + " spillere valgte sten ");

        if (Computer == PAPIR) {
            Billede2.setImage(papir);
            System.out.println("AI wins");
            ai++;
            gameData = ("player:sten - computer:papir");
        } else if (Computer == SAKS) {
            Billede2.setImage(saks);
            System.out.println("Player wins");
            player++;
            gameData = ("player:sten - computer:saks");
        } else if (Computer == STEN) {
            Billede2.setImage(sten);
            System.out.println("draw");
            gameData = ("player:sten - computer:sten");


        }
        Score.setText(player + "-" + ai);
    }

    @FXML
    void loadGame(ActionEvent event) throws IOException {


        String path = "StenSaksPapirLog.txt";
        Scanner scanner = new Scanner(new File(path));

        //read line by line
        while (scanner.hasNext()) {
            //process each line
            String next = scanner.next();

            if (next.equals("er:")){
                Score.setText(scanner.next());
            }

        }
        scanner.close();


    }



    @FXML
    void saveGame(ActionEvent event) {


        try {

            FileWriter myWriter = new FileWriter("StenSaksPapirLog.txt");
            myWriter.write(d.toString() + "\n");

            myWriter.write(gameData + "\n");


            myWriter.write("\nscoren er: " + Score.getText());
            myWriter.close();
            System.out.println("Successfully saved the file");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
    }

