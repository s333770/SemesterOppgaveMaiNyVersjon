package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import static sample.Arrangement.arrangementObservableList;


public class bestillBiletterController implements Initializable {


    @FXML private ChoiceBox antallBiletterChoiceBox;

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

    @FXML private TextField navnBilettTextfield;

    @FXML private TextField emailBilettTextfield;

    @FXML private TextField telefonBiletterTextfield;






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        antallBiletterChoiceBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
        setTabellVerdier("arrangement", "type","artister","lokale","dato","tidspunkt","bilettpris","bilettsalg","kontaktPerson");
        tableView.setItems(arrangementObservableList);

    }

    public void bestillBiletterPushed(javafx.event.ActionEvent actionEvent) {
        Arrangement valgtArrangement=tableView.getSelectionModel().getSelectedItem();
        int antallBiletter= valgtArrangement.getBilettsalg();
        int antallBiletterBestiler=Integer.parseInt(antallBiletterChoiceBox.getValue().toString());

        int sum=antallBiletter-antallBiletterBestiler;
        valgtArrangement.setBilettsalg(sum);
        tableView.refresh();
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
