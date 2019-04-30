package sample;

import com.sun.javaws.exceptions.InvalidArgumentException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
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
    private TableView<ArrangementKontakpersonSamlet> tableView;
    @FXML
    TableColumn<ArrangementKontakpersonSamlet, String> arrangementKolonne;
    @FXML
    TableColumn<ArrangementKontakpersonSamlet, String> typeKolonne;
    @FXML
    TableColumn<ArrangementKontakpersonSamlet, String> artisterKolonne;
    @FXML
    TableColumn<ArrangementKontakpersonSamlet, String> lokaleKolonne;
    @FXML
    TableColumn<ArrangementKontakpersonSamlet, LocalDate> datoKolonne;
    @FXML
    TableColumn<ArrangementKontakpersonSamlet, String> tidspunktKolonne;
    @FXML
    TableColumn<ArrangementKontakpersonSamlet, String> bilettprisKolonne;
    @FXML
    TableColumn<ArrangementKontakpersonSamlet, String> bilettsalgKolonne;
    @FXML
    TableColumn<ArrangementKontakpersonSamlet, String> kontaktPersonKolonne;

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

    Alert informasjonboks=new Alert(Alert.AlertType.INFORMATION);


    @FXML
    void btnRegistrer(ActionEvent event) throws InputException {
            try{
                if(txtarrangement.getText()==null ||txtarrangement.getText().trim().isEmpty() ||txttype.getText()==null ||txttype.getText().trim().isEmpty()||txtartister.getText()==null ||txtartister.getText().trim().isEmpty()||
                        txttidspunkt.getText()==null ||txttidspunkt.getText().trim().isEmpty()||txtbilettpris.getText()==null ||txtbilettpris.getText().trim().isEmpty()||txtbilettsalg.getText()==null ||txtbilettsalg.getText().trim().isEmpty()){
                         throw new InputException("Alle feltene er ikke fylt ut i arrangement");
               }
                if(txtkontaktPerson.getText()==null ||txtkontaktPerson.getText().trim().isEmpty() ){
                        /*||txtpersonnummer.getText()==null ||txtpersonnummer.getText().trim().isEmpty()||txtemail.getText()==null ||txtemail.getText().trim().isEmpty()||
                        txtnettside.getText()==null ||txtnettside.getText().trim().isEmpty()||txtfirma.getText()==null ||txtfirma.getText().trim().isEmpty()||txtanneninfo.getText()==null ||txtanneninfo.getText().trim().isEmpty()){
                   */ throw new InputException("Alle felene er ikke fylt ut i kontaktperson");
                }


                arrangementObservableList.add(new Arrangement(txtarrangement.getText(),txttype.getText(),txtartister.getText(), (String) choiceBox.getValue(),txtdato.getValue(),txttidspunkt.getText(),txtbilettpris.getText(),Integer.parseInt(txtbilettsalg.getText()),txtkontaktPerson.getText()));
                setTabellVerdier("arrangement", "type","artister","lokale","dato","tidspunkt","bilettpris","bilettsalg","kontaktPerson");
                kontaktpersonObservableList.add(new Kontaktperson(txtkontaktPerson.getText(),txtpersonnummer.getText(),txtemail.getText(),txtnettside.getText(),txtfirma.getText(),txtanneninfo.getText()));
                arrangementKontaktpersonSamletObservableList.add(new ArrangementKontakpersonSamlet(txtarrangement.getText(),txttype.getText(),txtartister.getText(), (String) choiceBox.getValue(),txtdato.getValue(),txttidspunkt.getText(),txtbilettpris.getText(),Integer.parseInt(txtbilettsalg.getText()),txtkontaktPerson.getText(),txtpersonnummer.getText(),txtemail.getText(),txtnettside.getText(),txtfirma.getText(),txtanneninfo.getText()));
            }
            catch(InputException e){
                System.err.println(e.getMessage());
                informasjonboks.setTitle("Feil");
                informasjonboks.setContentText(e.getMessage());
                informasjonboks.show();
            }

          //  if(txtarrangement.getText(),txttype.getText(),txtartister.getText(), (String) choiceBox.getValue(),txtdato.getValue(),txttidspunkt.getText(),txtbilettpris.getText(),Integer.parseInt(txtbilettsalg.getText()),txtkontaktPerson.getText()))



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
        ArrangementKontakpersonSamlet valgtArrangement=tableView.getSelectionModel().getSelectedItem(); // Tar det elementet du trykker på
        personnummerLabelKontaktPerson.setText(valgtArrangement.getPersonNummerSamlet());
        emailLabelKontaktPerson.setText(valgtArrangement.getPersonEmailSamlet());
        SideLabelKontaktPerson.setText(valgtArrangement.getPersonSideSamlet());
        FirmaLabelKontaktPerson.setText(valgtArrangement.getPersonFirmaSamlet());
        AnnenInformasjonLabelKontaktPerson.setText(valgtArrangement.getPersonTekstSamlet());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Arrangement arrangement;
        if(arrangementObservableList.size() > 0) {
            System.out.println(arrangementObservableList.get(0).toString());
            setTabellVerdier("arrangement", "type","artister","lokale","dato","tidspunkt","bilettpris","bilettsalg","kontaktPerson");
        }
       // arrangementObservableList.add(new Arrangement("Konsert","Konsert","Lady Gaga","Kirke",LocalDate.of(1986, Month.JULY,21),"19:00","199","100","Leif"));

        tableView.setItems(arrangementKontaktpersonSamletObservableList);
        choiceBox.getItems().addAll("Oranges","pears","Strawberries");

    }
    public void setTabellVerdier(String arrangement, String type,String artister, String lokale, String dato, String tidspunkt,String bilettPris,String bilettsalg, String kontaktPerson){
        arrangementKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet,String>("arrangementSamlet"));
        // leggTilDataObservableList(txtarrangement.getText(),txttype.getText(),txtartister.getText(), (String) choiceBox.getValue(),txtdato.getValue(),txttidspunkt.getText(),txtbilettpris.getText(),txtbilettsalg.getText(),txtkontaktPerson.getText());
        typeKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet,String>("typeSamlet"));
        artisterKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet,String>("artisterSamlet"));
        lokaleKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet,String>("lokaleSamlet"));
        datoKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet, LocalDate>("datoSamlet"));
        tidspunktKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet,String>("tidspunktSamlet"));
        bilettprisKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet,String>("bilettprisSamlet"));
        bilettsalgKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet,String>("bilettsalgSamlet"));
        kontaktPersonKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet,String>("kontaktPersonSamlet"));
    }

    public void endreArrangementNavn(TableColumn.CellEditEvent edittedCell){
        ArrangementKontakpersonSamlet valgtArrangement=tableView.getSelectionModel().getSelectedItem(); // Tar det elementet du trykker på
        valgtArrangement.setArrangementSamlet(edittedCell.getNewValue().toString());
    }

  

    public void lesInnBilett(ActionEvent actionEvent) {
        

    }

    public void skrivUtBilett(ActionEvent actionEvent) {
    }

    public void getTextFieldVerdi(String sometingsometing){

    }



}
