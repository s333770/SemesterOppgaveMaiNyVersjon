package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    private Arrangement valgtArrangement;

    @FXML private Label labelArrangement;
    @FXML private Label labelTidspunkt;

    @FXML private Button arrangement;


    @FXML private Button bilett;


    @FXML private Button oversiktside;


    public void leggTilArrangement(javafx.event.ActionEvent actionEvent) throws IOException {
        lastInnStage(actionEvent,"/sample/arrangement.fxml");

        /*Parent parent= FXMLLoader.load(getClass().getResource("/sample/arrangement.fxml"));
        Scene scene = new Scene(parent);
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        */

    }
    public void bestillBiletter(javafx.event.ActionEvent actionEvent) throws IOException {
        lastInnStage(actionEvent,"/sample/arrangement.fxml");

        /*
        Parent parent= FXMLLoader.load(getClass().getResource("/sample/arrangement.fxml"));
        Scene scene = new Scene(parent);
        //Denne metoden brukes for å bytte scener:
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        */

    }




    public void initData(Arrangement arrangementet){
        valgtArrangement=arrangementet;
        labelArrangement.setText(valgtArrangement.getArrangement());

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void lastInnStage(javafx.event.ActionEvent actionEvent,String fxmlFil)throws IOException{
        Parent parent= FXMLLoader.load(getClass().getResource("/sample/arrangement.fxml"));
        Scene scene = new Scene(parent);
        //Denne metoden brukes for å bytte scener:
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
