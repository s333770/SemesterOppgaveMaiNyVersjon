package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class ArrangementController implements Initializable {

    @FXML private ChoiceBox choiceBox;
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

    @FXML private TextField txtarrangement;
    @FXML private TextField txttype;
    @FXML private TextField txtartister;
    @FXML private TextField txtlokale;
    @FXML private DatePicker txtdato;
    @FXML private TextField txttidspunkt;
    @FXML private TextField txtbilettpris;
    @FXML private TextField txtbilettsalg;
    @FXML private TextField txtkontaktPerson;

    ObservableList<Arrangement> arrangementObservableList= FXCollections.observableArrayList();

    @FXML
    void btnRegistrer(ActionEvent event) throws IOException {
        //Vi skriver både til ett lokale objekt og et observable arraylist
        Arrangement arrangement= new Arrangement(txtarrangement.getText(),txttype.getText(),txtartister.getText(),(String) choiceBox.getValue(),txtdato.getValue(),txttidspunkt.getText(),txtbilettpris.getText(),txtbilettsalg.getText(),txtkontaktPerson.getText());
        arrangementObservableList.add(new Arrangement(txtarrangement.getText(),txttype.getText(),txtartister.getText(), (String) choiceBox.getValue(),txtdato.getValue(),txttidspunkt.getText(),txtbilettpris.getText(),txtbilettsalg.getText(),txtkontaktPerson.getText()));
        arrangementKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("arrangement"));
        typeKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("type"));
        artisterKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("artister"));
        lokaleKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("lokale"));
        datoKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement, LocalDate>("dato"));
        tidspunktKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("tidspunkt"));
        bilettprisKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("bilettpris"));
        bilettsalgKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("bilettsalg"));
        kontaktPersonKolonne.setCellValueFactory(new PropertyValueFactory<Arrangement,String>("kontaktPerson"));
        System.out.println(arrangement);
        tableView.setItems(arrangementObservableList);
    }
    @FXML
    public void tilbakeTilStartside(ActionEvent event) throws IOException{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/sample.fxml"));
        Parent tableViewParent= loader.load();

        Scene tableViewScene=new Scene(tableViewParent);

        Controller controller=loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());

        Stage window= (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().add("Kirke");
        choiceBox.getItems().add("bananas");
        choiceBox.getItems().addAll("Oranges","pears","Strawberries");

    }


}
