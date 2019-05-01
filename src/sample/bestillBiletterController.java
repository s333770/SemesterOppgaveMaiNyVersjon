package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sample.ArrangementKontakpersonSamlet.arrangementKontaktpersonSamletObservableList;



public class bestillBiletterController extends SkrivData implements Initializable  {

    @FXML private ChoiceBox antallBiletterChoiceBox;

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

    @FXML private TextField navnBilettTextfield;

    @FXML private TextField emailBilettTextfield;

    @FXML private TextField telefonBiletterTextfield;

    @FXML Label arrangementLabel;
    @FXML Label stedLabel;
    @FXML Label tidspunktLabel;
    @FXML Label datoLabel;
    @FXML Label navnLabel;
    @FXML Label telefonnummerLabel;
    @FXML Label emailLabel;
    @FXML Label antallBiletterLabel;

    Alert informasjonboks = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        antallBiletterChoiceBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        setTabellVerdier("arrangement", "type","artister","lokale","dato","tidspunkt","bilettpris","bilettsalg","kontaktPerson");
        tableView.setItems(arrangementKontaktpersonSamletObservableList);
    }
    public void bestillBiletterPushed(javafx.event.ActionEvent actionEvent) throws ElementIkkeValgtException,InputException,NullPointerException {
        System.out.println(tableView.getSelectionModel().getSelectedItem());
        try {
            if (navnBilettTextfield.getText() == null || navnBilettTextfield.getText().trim().isEmpty() || emailBilettTextfield.getText() == null || emailBilettTextfield.getText().trim().isEmpty() || telefonBiletterTextfield.getText() == null || telefonBiletterTextfield.getText().trim().isEmpty()) {
                throw new InputException("Alle feltene er ikke fylt ut i bestiller");
            }
            navnLabel.setText(navnBilettTextfield.getText());
            telefonnummerLabel.setText(telefonBiletterTextfield.getText());
            emailLabel.setText(emailBilettTextfield.getText());
        } catch (InputException e) {
            System.err.println(e.getMessage());
            informasjonboks.setTitle("Feil i en av tekstboksene");
            informasjonboks.setContentText(e.getMessage());
            informasjonboks.show();
        }
        try {
            ArrangementKontakpersonSamlet valgtArrangement = tableView.getSelectionModel().getSelectedItem();
            if (valgtArrangement == null) {
                throw new ElementIkkeValgtException("Du må velge et element for å bestille bilett");
            }
        } catch (ElementIkkeValgtException e) {
            System.err.println(e.getMessage());
            informasjonboks.setContentText(e.getMessage());
            informasjonboks.show();
        }
        try {
            ArrangementKontakpersonSamlet valgtArrangement = tableView.getSelectionModel().getSelectedItem();
            if (valgtArrangement.getBilettsalgSamlet().getValue() == null) {
                throw new NullPointerException("NullPointerException");
            }

        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            informasjonboks.setTitle("NullPointerException");
            informasjonboks.setContentText(e.getMessage());
            informasjonboks.show();
        }
        try {
            if (antallBiletterChoiceBox.getSelectionModel().isEmpty()) {
                throw new ElementIkkeValgtException("Du må velge antall biletter i ChoiceBox");
            }
        } catch (ElementIkkeValgtException e) {
            System.err.println(e.getMessage());
            informasjonboks.setContentText(e.getMessage());
            informasjonboks.show();
        }

            ArrangementKontakpersonSamlet valgtArrangement = tableView.getSelectionModel().getSelectedItem();
            int antallBiletter = valgtArrangement.getBilettsalgSamlet().intValue();
            int antallBiletterBestiler = Integer.parseInt(antallBiletterChoiceBox.getValue().toString());

            int sum = (Integer) antallBiletter - (Integer) antallBiletterBestiler;
            System.out.println(sum);
            valgtArrangement.setBilettsalgSamlet(sum);
            tableView.refresh();

            arrangementLabel.setText(valgtArrangement.getArrangementSamlet().toString());
            antallBiletterLabel.setText(antallBiletterChoiceBox.getValue().toString());
            stedLabel.setText(valgtArrangement.getTypeSamlet().toString());
            tidspunktLabel.setText(valgtArrangement.getTidspunktSamlet().toString());
            datoLabel.setText(valgtArrangement.getDatoSamlet().toString());


    }

    public void lagreDataTilCSVFil(javafx.event.ActionEvent actionEvent) throws FileNotFoundException {
        FileChooser filvelger= new FileChooser();
        File valgtFil= filvelger.showOpenDialog(null);
        if

        SkrivUtDataCSV csv= new SkrivUtDataCSV();
        csv.skrivDataTilCSVFil(tableView.getSelectionModel().getSelectedItem());



    }


    public void lagreDataTilJOBJFil(javafx.event.ActionEvent actionEvent) throws FileNotFoundException {
        SkrivUtDataJOBJ jobj= new SkrivUtDataJOBJ();
        jobj.skrivUtDataJobj(tableView.getSelectionModel().getSelectedItem());
    }

    public void lesUtDataTilFil(javafx.event.ActionEvent actionEvent) throws IOException {
        LesData lesdata=new LesDataCSV();
        ((LesDataCSV) lesdata).lesDataCSV();

    }


    public void tilbakeTilStartside(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/sample.fxml"));
        Parent tableViewParent= loader.load();
        Scene tableViewScene=new Scene(tableViewParent);
        Stage window= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();

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

}
