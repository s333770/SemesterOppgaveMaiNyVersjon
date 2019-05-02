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
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

import static sample.Arrangement.arrangementObservableList;
import static sample.ArrangementKontakpersonSamlet.arrangementKontaktpersonSamletObservableList;


public class Controller implements Initializable{
    private Arrangement valgtArrangement;

    @FXML private Label labelArrangement;
    @FXML private Label labelTidspunkt;

    @FXML private Button arrangement;


    @FXML private Button bilett;


    @FXML private Button oversiktside;

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


    public void leggTilArrangement(javafx.event.ActionEvent actionEvent) throws IOException {
        lastInnStage(actionEvent,"/sample/arrangement.fxml");
    }
    public void bestillBiletter(javafx.event.ActionEvent actionEvent) throws IOException {
        lastInnStage(actionEvent,"/sample/bestillBiletter.fxml");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        arrangementObservableList.add(new Arrangement("Disko","Kinosal","Lady Gaga", "Kjeller",LocalDate.of(1915, Month.DECEMBER,12),"19:00",100,100,"Fredrik"));
        arrangementKontaktpersonSamletObservableList.add(new ArrangementKontakpersonSamlet("Konsert","kino","Hellbillies","Menighetshuset",LocalDate.of(1915, Month.DECEMBER,12),"19:00",100,100,"Fredrik","Fredrik Ulvestad","090891","tm2_93@hotmail.com","www.Fredrik.com","Inget firma"));
        setTabellVerdier("arrangement", "type","artister","lokale","dato","tidspunkt","bilettpris","bilettsalg","kontaktPerson");
        tableView.setItems(arrangementKontaktpersonSamletObservableList);
    }

    public void lastInnStage(javafx.event.ActionEvent actionEvent,String fxmlFil){
        try{
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFil));
            Parent tableViewParent= loader.load();
            Scene tableViewScene=new Scene(tableViewParent);
            Stage window= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        }
         catch (IOException e) {
            e.printStackTrace();
        }

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
