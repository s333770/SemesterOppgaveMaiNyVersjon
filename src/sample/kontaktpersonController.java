package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sample.Arrangement.arrangementObservableList;
import static sample.Kontaktperson.kontaktpersonObservableList;

public class kontaktpersonController implements Initializable {

    @FXML
    private TableView<Kontaktperson> tableViewKontaktperson;
    @FXML
    TableColumn<Kontaktperson, String> personNavnKolonne;
    @FXML
    TableColumn<Kontaktperson, String> personNummerKolonne;
    @FXML
    TableColumn<Kontaktperson, String> personEmailKolonne;
    @FXML
    TableColumn<Kontaktperson, String> personSideKolonne;
    @FXML
    TableColumn<Kontaktperson, LocalDate> personFirmaKolonne;
    @FXML
    TableColumn<Kontaktperson, String> personAnnenInformasjonKolonne;

    public void setTabellVerdier(String personNavn, String personNummer,String personEmail, String personSide, String personFirma, String personTekst){
        personNavnKolonne.setCellValueFactory(new PropertyValueFactory<Kontaktperson,String>("personNavn"));
        // leggTilDataObservableList(txtarrangement.getText(),txttype.getText(),txtartister.getText(), (String) choiceBox.getValue(),txtdato.getValue(),txttidspunkt.getText(),txtbilettpris.getText(),txtbilettsalg.getText(),txtkontaktPerson.getText());
        personNummerKolonne.setCellValueFactory(new PropertyValueFactory<Kontaktperson,String>("personNummer"));
        personEmailKolonne.setCellValueFactory(new PropertyValueFactory<Kontaktperson,String>("personEmail"));
        personSideKolonne.setCellValueFactory(new PropertyValueFactory<Kontaktperson,String>("personSide"));
        personFirmaKolonne.setCellValueFactory(new PropertyValueFactory<Kontaktperson, LocalDate>("personFirma"));
        personAnnenInformasjonKolonne.setCellValueFactory(new PropertyValueFactory<Kontaktperson,String>("personTekst"));

        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableViewKontaktperson.setItems(kontaktpersonObservableList);
        System.out.println(kontaktpersonObservableList);

    }
}
