package sample;

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
import java.time.Month;
import java.util.ResourceBundle;

import static sample.Arrangement.arrangementObservableList;

import static sample.ArrangementKontakpersonSamlet.arrangementKontaktpersonSamletObservableList;
import static sample.Kontaktperson.kontaktpersonObservableList;


public class ArrangementController implements Initializable {


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
    @FXML private ChoiceBox choiceBox;
    @FXML private DatePicker txtdato;
    @FXML private TextField txttidspunkt;
    @FXML private TextField txtbilettpris;
    @FXML private TextField txtbilettsalg;
    @FXML private TextField txtkontaktPerson;

    @FXML private TextField txtpersonnummer;
    @FXML private TextField txtemail;
    @FXML private TextField txtnettside;
    @FXML private TextField txtfirma;
    @FXML private TextField txtanneninfo;

    @FXML
    Label navnLabelKontaktPerson;
    @FXML
    Label personnummerLabelKontaktPerson;
    @FXML
    Label telefonnummerLabelKontaktPerson;
    @FXML
    Label emailLabelKontaktPerson;
    @FXML
    Label SideLabelKontaktPerson;
    @FXML
    Label FirmaLabelKontaktPerson;
    @FXML
    Label AnnenInformasjonLabelKontaktPerson;

    @FXML
    void btnRegistrer(ActionEvent event) throws IOException {
        arrangementObservableList.add(new Arrangement(txtarrangement.getText(),txttype.getText(),txtartister.getText(), (String) choiceBox.getValue(),txtdato.getValue(),txttidspunkt.getText(),txtbilettpris.getText(),Integer.parseInt(txtbilettsalg.getText()),txtkontaktPerson.getText()));
        setTabellVerdier("arrangement", "type","artister","lokale","dato","tidspunkt","bilettpris","bilettsalg","kontaktPerson");
        kontaktpersonObservableList.add(new Kontaktperson(txtkontaktPerson.getText(),txtpersonnummer.getText(),txtemail.getText(),txtnettside.getText(),txtfirma.getText(),txtanneninfo.getText()));
        arrangementKontaktpersonSamletObservableList.add(new ArrangementKontakpersonSamlet(txtarrangement.getText(),txttype.getText(),txtartister.getText(), (String) choiceBox.getValue(),txtdato.getValue(),txttidspunkt.getText(),txtbilettpris.getText(),Integer.parseInt(txtbilettsalg.getText()),txtkontaktPerson.getText(),txtkontaktPerson.getText(),txtpersonnummer.getText(),txtemail.getText(),txtnettside.getText(),txtfirma.getText(),txtanneninfo.getText()));

    }
    @FXML
    public void tilbakeTilStartside(ActionEvent event) throws IOException{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/sample.fxml"));
        Parent tableViewParent= loader.load();
        Scene tableViewScene=new Scene(tableViewParent);
        Stage window= (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    @FXML void oversiktKontaktPerson(ActionEvent event) throws IOException{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/kontaktperson.fxml"));
        Parent tableViewParent= loader.load();
        Scene tableViewScene=new Scene(tableViewParent);
        Stage window= (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();



        Arrangement valgtArrangement=tableView.getSelectionModel().getSelectedItem();
       

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Arrangement arrangement;
        if(arrangementObservableList.size() > 0) {
            System.out.println(arrangementObservableList.get(0).toString());
            setTabellVerdier("arrangement", "type","artister","lokale","dato","tidspunkt","bilettpris","bilettsalg","kontaktPerson");
        }
       // arrangementObservableList.add(new Arrangement("Konsert","Konsert","Lady Gaga","Kirke",LocalDate.of(1986, Month.JULY,21),"19:00","199","100","Leif"));

        tableView.setItems(arrangementObservableList);
        choiceBox.getItems().addAll("Oranges","pears","Strawberries");

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

    public void endreArrangementNavn(TableColumn.CellEditEvent edittedCell){
        Arrangement valgtArrangement=tableView.getSelectionModel().getSelectedItem(); // Tar det elementet du trykker på
        valgtArrangement.setArrangement(edittedCell.getNewValue().toString());
    }

}
