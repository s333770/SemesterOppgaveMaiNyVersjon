package sample;

import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.media.sound.InvalidFormatException;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    TableColumn<ArrangementKontakpersonSamlet, Integer> bilettprisKolonne;
    @FXML
    TableColumn<ArrangementKontakpersonSamlet, Integer> bilettsalgKolonne;
    @FXML
    TableColumn<ArrangementKontakpersonSamlet, String> kontaktPersonKolonne;

    @FXML
    private TextField txtarrangement;
    @FXML
    private TextField txttype;
    @FXML
    private TextField txtartister;
    @FXML
    private ChoiceBox choiceBox;
    @FXML
    private DatePicker txtdato;
    @FXML
    private TextField txttidspunkt;
    @FXML
    private TextField txtbilettpris;
    @FXML
    private TextField txtbilettsalg;
    @FXML
    private TextField txtkontaktPerson;

    @FXML
    private TextField txtpersonnummer;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtnettside;
    @FXML
    private TextField txtfirma;
    @FXML
    private TextField txtanneninfo;

    @FXML
    Label navnLabelKontaktPerson;
    @FXML
    Label personnummerLabelKontaktPerson;
    @FXML
    Label emailLabelKontaktPerson;
    @FXML
    Label SideLabelKontaktPerson;
    @FXML
    Label FirmaLabelKontaktPerson;
    @FXML
    Label AnnenInformasjonLabelKontaktPerson;

    Alert informasjonboks = new Alert(Alert.AlertType.INFORMATION);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    @FXML
    void btnRegistrer(ActionEvent event) throws InputException {
        try {
            int valideringInteger = 0;
            int valideringInteger2 = 0;
            if (txtarrangement.getText() == null || txtarrangement.getText().trim().isEmpty() || txttype.getText() == null || txttype.getText().trim().isEmpty() || txtartister.getText() == null || txtartister.getText().trim().isEmpty() ||
                    txttidspunkt.getText() == null || txttidspunkt.getText().trim().isEmpty() || txtbilettpris.getText() == null || txtbilettpris.getText().trim().isEmpty() || txtbilettsalg.getText() == null || txtbilettsalg.getText().trim().isEmpty()) {
                throw new InputException("Alle feltene er ikke fylt ut i arrangement");
            }
            if (txtkontaktPerson.getText() == null || txtkontaktPerson.getText().trim().isEmpty() || txtpersonnummer.getText() == null || txtpersonnummer.getText().trim().isEmpty() || txtemail.getText() == null || txtemail.getText().trim().isEmpty() ||
                    txtnettside.getText() == null || txtnettside.getText().trim().isEmpty() || txtfirma.getText() == null || txtfirma.getText().trim().isEmpty() || txtanneninfo.getText() == null || txtanneninfo.getText().trim().isEmpty()) {
                throw new InputException("Alle feltene er ikke fylt ut i kontaktperson");
            }
            Integer.parseInt(txtbilettpris.getText());
            Integer.parseInt(txtbilettsalg.getText());
            arrangementObservableList.add(new Arrangement(txtarrangement.getText(), txttype.getText(), txtartister.getText(), (String) choiceBox.getValue(), txtdato.getValue(), txttidspunkt.getText(), Integer.parseInt(txtbilettpris.getText()), Integer.parseInt(txtbilettsalg.getText()), txtkontaktPerson.getText()));
            setTabellVerdier("arrangement", "type", "artister", "lokale", "dato", "tidspunkt", "bilettpris", "bilettsalg", "kontaktPerson");
            kontaktpersonObservableList.add(new Kontaktperson(txtkontaktPerson.getText(), txtpersonnummer.getText(), txtemail.getText(), txtnettside.getText(), txtfirma.getText(), txtanneninfo.getText()));
            arrangementKontaktpersonSamletObservableList.add(new ArrangementKontakpersonSamlet(txtarrangement.getText(), txttype.getText(), txtartister.getText(), (String) choiceBox.getValue(), txtdato.getValue(), txttidspunkt.getText(), Integer.parseInt(txtbilettpris.getText()), Integer.parseInt(txtbilettsalg.getText()), txtkontaktPerson.getText(), txtpersonnummer.getText(), txtemail.getText(), txtnettside.getText(), txtfirma.getText(), txtanneninfo.getText()));

        } catch (InputException e) {
            System.err.println(e.getMessage());
            informasjonboks.setTitle("Feil i en av inputfeltene");
            informasjonboks.setContentText(e.getMessage());
            informasjonboks.show();
        }
        catch (NumberFormatException e){
            System.err.println(e.getMessage());
            informasjonboks.setTitle("Feil i en av inputfeltene");
            informasjonboks.setContentText("Bilettpris og antall ledige biletter må være på Integer-Form");
            informasjonboks.show();
        }
    }

    @FXML
    public void tilbakeTilStartside(ActionEvent event) throws IOException {
        lastInnStage(event, "/sample/sample.fxml");
    }
    @FXML public void lesInnArrangement(ActionEvent event) throws IOException, InvalidFormatException {
        FileChooser filvelger = new FileChooser();
        File valgtFil = filvelger.showOpenDialog(null);
        Scanner input = new Scanner(valgtFil);
        String filType=LesData.getFileExtension(valgtFil.toString());

        try {
            if (filType.equals("csv")) {
                LesData lesData = new LesDataCSV(input);
            }

            if (filType.equals("obj")) {
                LesData lesData=new LesDataJOBJ(input);
            }
            if(!(filType.equals("csv"))){
                throw new InvalidFormatException("Filtypen er av feil format");
            }
            if(!(filType.equals("obj"))){
                throw new InvalidFormatException("Filtypen er av feil format");
            }

        }
        catch(InvalidFormatException e){
            System.err.println(e.getMessage());
            informasjonboks.setTitle("FormatFeil");
            informasjonboks.setContentText(e.getMessage());
            informasjonboks.show();
        }
        tableView.refresh();
    }
    @FXML public void skrivUtArrangement(ActionEvent event) throws IOException, InvalidFormatException {
        FileChooser filvelger = new FileChooser();
        File fil = filvelger.showSaveDialog(null);
        String filType=SkrivData.getFileExtension(fil.toString());
        System.out.println(filType);

        try {
            if (filType.equals("csv")) {

            }

            if (filType.equals("obj")) {
                ArrangementKontakpersonSamlet ObjektSkrivUt=new ArrangementKontakpersonSamlet(tableView.getSelectionModel().getSelectedItem().getArrangementSamlet().toString(),tableView.getSelectionModel().getSelectedItem().getTypeSamlet().toString(),tableView.getSelectionModel().getSelectedItem().getArtisterSamlet().toString(),tableView.getSelectionModel().getSelectedItem().getLokaleSamlet().toString(),
                        LocalDate.parse(tableView.getSelectionModel().getSelectedItem().getDatoSamlet().toString(),formatter),tableView.getSelectionModel().getSelectedItem().getTidspunktSamlet().toString(),tableView.getSelectionModel().getSelectedItem().getBilettprisSamlet().intValue(),tableView.getSelectionModel().getSelectedItem().getBilettsalgSamlet().intValue(),
                        tableView.getSelectionModel().getSelectedItem().getKontaktPersonSamlet().toString(),tableView.getSelectionModel().getSelectedItem().getPersonNummerSamlet().toString(),tableView.getSelectionModel().getSelectedItem().getPersonEmailSamlet().toString(),tableView.getSelectionModel().getSelectedItem().getPersonSideSamlet().toString(),
                        tableView.getSelectionModel().getSelectedItem().getPersonFirmaSamlet().toString(),tableView.getSelectionModel().getSelectedItem().getPersonTekstSamlet().toString());
                System.out.println(tableView.getSelectionModel().getSelectedItem().getDatoSamlet().toString());
                SkrivData skrivData=new SkrivUtDataJOBJ(ObjektSkrivUt, fil);
            }

        }
        catch(Exception e){
            System.err.println(e.getMessage());
            informasjonboks.setTitle("FormatFeil");
            informasjonboks.setContentText(e.getMessage());
            informasjonboks.show();
        }
        tableView.refresh();
        tableView.refresh();
    }
        @FXML
    void oversiktKontaktPerson(ActionEvent event) throws ElementIkkeValgtException  {
        try{

            ArrangementKontakpersonSamlet valgtArrangement = tableView.getSelectionModel().getSelectedItem(); // Tar det elementet du trykker på
            if(valgtArrangement==null){
                throw new ElementIkkeValgtException("Du må velge et element for å få informasjon om kontaktperson");
            }
            navnLabelKontaktPerson.setText(valgtArrangement.getKontaktPersonSamlet());
            personnummerLabelKontaktPerson.setText(valgtArrangement.getPersonNummerSamlet());
            emailLabelKontaktPerson.setText(valgtArrangement.getPersonEmailSamlet());
            SideLabelKontaktPerson.setText(valgtArrangement.getPersonSideSamlet());
            FirmaLabelKontaktPerson.setText(valgtArrangement.getPersonFirmaSamlet());
            AnnenInformasjonLabelKontaktPerson.setText(valgtArrangement.getPersonTekstSamlet());
        }
        catch(ElementIkkeValgtException e){
            System.err.println(e.getMessage());
            informasjonboks.setTitle("Velg et element i tabellen");
            informasjonboks.setContentText(e.getMessage());
            informasjonboks.show();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (arrangementObservableList.size() > 0) {
            System.out.println(arrangementObservableList.get(0).toString());
            setTabellVerdier("arrangement", "type", "artister", "lokale", "dato", "tidspunkt", "bilettpris", "bilettsalg", "kontaktPerson");
        }
        tableView.setItems(arrangementKontaktpersonSamletObservableList);
        choiceBox.getItems().addAll("Kino", "Konsertsal", "Foredragssal", "Åpent areale");
        tableView.setEditable(true);
        arrangementKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
        typeKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
        artisterKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
        lokaleKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
        tidspunktKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
        kontaktPersonKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
        bilettsalgKolonne.setCellFactory(TextFieldTableCell.<ArrangementKontakpersonSamlet,Integer>forTableColumn(new IntegerStringConverter()));
        bilettprisKolonne.setCellFactory(TextFieldTableCell.<ArrangementKontakpersonSamlet,Integer>forTableColumn(new IntegerStringConverter()));
        datoKolonne.setCellFactory(TextFieldTableCell.<ArrangementKontakpersonSamlet,LocalDate>forTableColumn(new LocalDateStringConverter()));

    }
    public void setTabellVerdier(String arrangement, String type, String artister, String lokale, String dato, String tidspunkt, String bilettPris, String bilettsalg, String kontaktPerson) {
        arrangementKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet, String>("arrangementSamlet"));
        typeKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet, String>("typeSamlet"));
        artisterKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet, String>("artisterSamlet"));
        lokaleKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet, String>("lokaleSamlet"));
        datoKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet, LocalDate>("datoSamlet"));
        tidspunktKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet, String>("tidspunktSamlet"));
        bilettprisKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet, Integer>("bilettprisSamlet"));
        bilettsalgKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet, Integer>("bilettsalgSamlet"));
        kontaktPersonKolonne.setCellValueFactory(new PropertyValueFactory<ArrangementKontakpersonSamlet, String>("kontaktPersonSamlet"));
    }

    public void slettArrangement(javafx.event.ActionEvent actionEvent){
        ObservableList<ArrangementKontakpersonSamlet> listeAvValgteElementer, alleElementer;
        alleElementer=tableView.getItems();
        listeAvValgteElementer=tableView.getSelectionModel().getSelectedItems();
        listeAvValgteElementer.forEach(alleElementer::remove);
        tableView.refresh();
    }

    public void lastInnStage(javafx.event.ActionEvent actionEvent, String fxmlFil) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFil));
            Parent tableViewParent = loader.load();
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





