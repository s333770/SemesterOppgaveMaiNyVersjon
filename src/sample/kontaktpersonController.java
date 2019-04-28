package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

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
    TableColumn<Kontaktperson, String> personFirmaKolonne;
    @FXML
    TableColumn<Kontaktperson, String> personAnnenInformasjonKolonne;

    public void setTabellVerdier(String personNavn, String personNummer,String personEmail, String personSide, String personFirma, String personTekst){
        personNavnKolonne.setCellValueFactory(new PropertyValueFactory<Kontaktperson,String>("personNavn"));
        // leggTilDataObservableList(txtarrangement.getText(),txttype.getText(),txtartister.getText(), (String) choiceBox.getValue(),txtdato.getValue(),txttidspunkt.getText(),txtbilettpris.getText(),txtbilettsalg.getText(),txtkontaktPerson.getText());
        personNummerKolonne.setCellValueFactory(new PropertyValueFactory<Kontaktperson,String>("personNummer"));
        personEmailKolonne.setCellValueFactory(new PropertyValueFactory<Kontaktperson,String>("personEmail"));
        personSideKolonne.setCellValueFactory(new PropertyValueFactory<Kontaktperson,String>("personSide"));
        personFirmaKolonne.setCellValueFactory(new PropertyValueFactory<Kontaktperson, String>("personFirma"));
        personAnnenInformasjonKolonne.setCellValueFactory(new PropertyValueFactory<Kontaktperson,String>("personTekst"));

        }

    public void byttSceneTilbakeTilStart(javafx.event.ActionEvent actionEvent) throws IOException {
        lastInnStage(actionEvent,"/sample/arrangement.fxml");}

    public void lastInnStage(javafx.event.ActionEvent actionEvent,String fxmlFil)throws IOException{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFil));
        Parent tableViewParent= loader.load();
        Scene tableViewScene=new Scene(tableViewParent);
        Stage window= (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableViewKontaktperson.setItems(kontaktpersonObservableList);
        setTabellVerdier("personNavn","personNummer","personEmail","personSide","personFirma","personTekst");
        System.out.println(kontaktpersonObservableList);
        tableViewKontaktperson.setEditable(true);
        personNummerKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
        personEmailKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
        personSideKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
        personFirmaKolonne.setCellFactory(TextFieldTableCell.forTableColumn());
        personAnnenInformasjonKolonne.setCellFactory(TextFieldTableCell.forTableColumn());


    }
    /*
    public void endreNavnKontaktPerson(TableColumn.CellEditEvent edittedCell){
        Person personSelected=tableView.getSelectionModel().getSelectedItem(); // Tar det elementet du trykker på
        personSelected.setFirstName(edittedCell.getNewValue().toString());
    }
    */

}
