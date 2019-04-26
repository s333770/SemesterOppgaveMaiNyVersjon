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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sample.Arrangement.arrangementObservableList;

public class Controller implements Initializable{
    private Arrangement valgtArrangement;

    @FXML private Label labelArrangement;
    @FXML private Label labelTidspunkt;

    @FXML private Button arrangement;


    @FXML private Button bilett;


    @FXML private Button oversiktside;

    @FXML
    private TableView<Arrangement> tableView;
    @FXML
    TableColumn<Arrangement, String> arrangementKolonne;
    @FXML
    TableColumn<Arrangement, String> typeKolonne;
    @FXML
    TableColumn<Arrangement, String> artisterKolonne;
    @FXML
    TableColumn<Arrangement, String> lokaleKolonne;
    @FXML
    TableColumn<Arrangement, LocalDate> datoKolonne;
    @FXML
    TableColumn<Arrangement, String> tidspunktKolonne;
    @FXML
    TableColumn<Arrangement, String> bilettprisKolonne;
    @FXML
    TableColumn<Arrangement, String> bilettsalgKolonne;
    @FXML
    TableColumn<Arrangement, String> kontaktPersonKolonne;


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



    /*
    public void initData(Arrangement arrangementet){
        valgtArrangement=arrangementet;
        labelArrangement.setText(valgtArrangement.getArrangement());

    }
    */


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setTabellVerdier("arrangement", "type","artister","lokale","dato","tidspunkt","bilettpris","bilettsalg","kontaktPerson");
        tableView.setItems(arrangementObservableList);

    }

    public void lastInnStage(javafx.event.ActionEvent actionEvent,String fxmlFil)throws IOException{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFil));
        Parent tableViewParent= loader.load();
        Scene tableViewScene=new Scene(tableViewParent);
        Stage window= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

    }
    public void setTabellVerdier(String arrangement, String type,String artister, String lokale, String dato, String tidspunkt,String bilettPris,String bilettsalg, String kontaktPerson){
        arrangementKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("arrangement"));
        // leggTilDataObservableList(txtarrangement.getText(),txttype.getText(),txtartister.getText(), (String) choiceBox.getValue(),txtdato.getValue(),txttidspunkt.getText(),txtbilettpris.getText(),txtbilettsalg.getText(),txtkontaktPerson.getText());
        typeKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("type"));
        artisterKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("artister"));
        lokaleKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("lokale"));
        datoKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement, LocalDate>("dato"));
        tidspunktKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("tidspunkt"));
        bilettprisKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("bilettpris"));
        bilettsalgKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("bilettsalg"));
        kontaktPersonKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("kontaktPerson"));
    }
}
