package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Kontaktperson {

    private SimpleStringProperty personNavn;
    private SimpleStringProperty personNummer;
    private SimpleStringProperty personEmail;
    private SimpleStringProperty personSide;
    private SimpleStringProperty personFirma;
    private SimpleStringProperty personTekst;



    public static ObservableList<Kontaktperson> kontaktpersonObservableList= FXCollections.observableArrayList();


    public Kontaktperson(String personNavn, String personNummer, String personEmail, String personSide, String personFirma, String personTekst) {
        this.personNavn =new SimpleStringProperty(personNavn);
        this.personNummer = new SimpleStringProperty(personNummer);
        this.personEmail = new SimpleStringProperty(personEmail);
        this.personSide = new SimpleStringProperty(personSide);
        this.personFirma = new SimpleStringProperty(personFirma);
        this.personTekst = new SimpleStringProperty(personTekst);
    }

    public SimpleStringProperty getPersonNavn() { return personNavn; }
    public void setPersonNavn(String personNavn) { this.personNavn = new SimpleStringProperty(personNavn); }
    public SimpleStringProperty getPersonNummer() { return personNummer; }
    public void setPersonNummer(String personNummer) { this.personNummer =new SimpleStringProperty(personNummer); }
    public SimpleStringProperty getPersonEmail() { return personEmail; }
    public void setPersonEmail(String personEmail) { this.personEmail =new SimpleStringProperty(personEmail); }
    public SimpleStringProperty getPersonSide() { return personSide; }
    public void setPersonSide(String personSide) { this.personSide = new SimpleStringProperty(personSide); }
    public SimpleStringProperty getPersonFirma() { return personFirma; }
    public void setPersonFirma(String personFirma) { this.personFirma = new SimpleStringProperty(personFirma); }
    public SimpleStringProperty getPersonTekst() { return personTekst; }
    public void setPersonTekst(String personTekst) { this.personTekst = new SimpleStringProperty(personTekst); }

    public SimpleStringProperty personNavnProperty() {
        return personNavn;
    }
    public SimpleStringProperty personNummerProperty() {
        return personNummer;
    }
    public SimpleStringProperty personEmailProperty() {
        return personEmail;
    }
    public SimpleStringProperty personSideProperty() {
        return personSide;
    }
    public SimpleStringProperty personFirmaProperty() {
        return personFirma;
    }
    public SimpleStringProperty personTekstProperty() {
        return personTekst;
    }

    public String toString() {
        return getPersonNavn() + " " +
                getPersonNummer() + " " +
                getPersonEmail()+ " " +
                getPersonSide() + " " +
                getPersonFirma() + " " +
                getPersonTekst() + " " ;

    }

}